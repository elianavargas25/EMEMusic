/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.servlet;

import com.project.ememusic.entidad.Usuarios;
import com.project.ememusic.negocio.NUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eliana.vargas
 */
@WebServlet(name = "ValidacionServlet", urlPatterns = {"/ValidacionServlet"})
public class ValidacionServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String user = request.getParameter("Usuario");
        String password = request.getParameter("Clave");
        request.setAttribute("target", null);
        request.setAttribute("usuario", null);
        request.setAttribute("mensaje", null);
        request.setAttribute("modulo", null);
        String modulo = "";
        String mensaje = "";
        // JOptionPane.showMessageDialog(null,user+" "+password);
        Usuarios usu = new Usuarios();
        NUsuario negocio = new NUsuario();
        try {
            usu = negocio.validarIngreso(user, password);
            if (usu.getNombre().equals(user) && usu.getClave().equals(password)) {
                String id_usu = usu.getIdUsuario();
                //Compruebo el estado del usuario al ingresar al sistema (activo o inactivo)
                if (usu.getEstado().equals("S")) {
                    //Compruebo el perfil del usuario que se esta logueando.

                    String perfil = usu.getPerfil();
                    if (perfil.equals("Administrador")) {
                        mensaje = "Bienvenido al Sistema";
                        id_usu = usu.getIdUsuario();
                        user = usu.getNombre();
                        perfil = usu.getPerfil();
                        modulo = "Menu.jsp";
                        request.setAttribute("mensaje", mensaje);
                        request.getSession(true).setAttribute("usuario", usu);
                        request.getRequestDispatcher(modulo).forward(request, response);

                    } else if (perfil.equals("Operario")) {
                        mensaje = "Bienvenido al Sistema";
                        id_usu = usu.getIdUsuario();
                        user = usu.getNombre();
                        perfil = usu.getPerfil();
                        modulo = "Menu.jsp";
                        request.setAttribute("mensaje", mensaje);
                        request.getSession(true).setAttribute("usuario", usu);
                        request.getRequestDispatcher(modulo).forward(request, response);
                    }

                } else {
                    modulo = "loguin.jsp";
                    mensaje = "Su estado es inactivo, por favor comuníquese con el Administrador";
                    request.setAttribute("mensaje", mensaje);
                    request.getRequestDispatcher(modulo).forward(request, response);
                }
            } else {
                modulo = "loguin.jsp";
                mensaje = "Usuario y/o Contraseña incorrectos";
                request.setAttribute("mensaje", mensaje);
                request.getRequestDispatcher(modulo).forward(request, response);
            }
        } catch (Exception e) {
            modulo = "loguin.jsp";
            mensaje = "Usuario y/o Contraseña incorrectos";
            request.setAttribute("mensaje", mensaje);
            request.getRequestDispatcher(modulo).forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
