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
 * @author Mileidy
 */
@WebServlet(name = "MaestroUsuario", urlPatterns = {"/MaestroUsuario"})
public class MaestroUsuario extends HttpServlet {
    
    
    Usuarios usuario = new Usuarios();
    NUsuario negocio = new NUsuario();

    public void limpiar() {
        usuario.setNombre("");
        usuario.setClave("");
        usuario.setPerfil("");
        usuario.setEstado("");
    }

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
        String nombre = request.getParameter("txtnombre");
        String clave = request.getParameter("txtclave");
        String perfil = request.getParameter("cboperfil");
        String estado = request.getParameter("optionStateS");
        
         String mensaje = "";
        String modulo = "Usuarios.jsp"; // validar con la vista

        //request.setAttribute("mensaje", null);
        request.setAttribute("modulo", null);
        request.setAttribute("datos", null);
        
        if ("Guardar".equals(request.getParameter("action"))) {
                    if (perfil.equals("1")) {
                        mensaje = "Usuario Administrador ya existe";
                    }else {
                    try {
                        usuario.setNombre(nombre);
                        usuario.setClave(clave);
                        usuario.setPerfil(perfil);
                        usuario.setEstado(estado);
                        
                        //se guarda los datos en la tabla
                        negocio.guardarUsuario(usuario);
                        mensaje = "El Usuario se registró correctamente";
                        limpiar();
                    } catch (Exception e2) {
                        mensaje = "Error en el registro de Usuario, favor verificar";
                        limpiar();
                    }
           }
                }//fin guardar
        
        if ("Buscar".equals(request.getParameter("action"))) {
            try {
                usuario = negocio.buscarUsuario(nombre);
                 if (usuario.getNombre().equals(nombre)) {
//si encuentra el dato cargamos los datos en el setAttribute
                    request.setAttribute("datos", usuario);
                } else {
                    mensaje = "El Usuario: " + nombre + " no se encuentra registrado ";
                    request.setAttribute("datos", null);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } //cierra buscar
        request.setAttribute("mensaje", mensaje);
        request.getRequestDispatcher(modulo).forward(request, response);

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
