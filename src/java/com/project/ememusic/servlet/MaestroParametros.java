/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.servlet;

import com.project.ememusic.entidad.Parametros;
import com.project.ememusic.negocio.NParametros;
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
@WebServlet(name = "MaestroParametros", urlPatterns = {"/MaestroParametros"})
public class MaestroParametros extends HttpServlet {

   Parametros paramet = new Parametros();
    NParametros negocio = new NParametros();

    public void limpiar() {
        paramet.setIdParametro("");
        paramet.setNombreParametro("");
        paramet.setValor("");

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
        PrintWriter out = response.getWriter();
        String idParametro = request.getParameter("txtIdParametro");
        String nombreParametro = request.getParameter("txtnombreParametro");
        String valor = request.getParameter("txtvalor");

        String mensaje = "";
        String modulo = "Index.jsp";

        request.setAttribute("modulo", null);
        request.setAttribute("mensaje", null);
        request.setAttribute("datos", null);

        if ("buscar".equals(request.getParameter("action"))) {
            try {
                paramet = negocio.buscarParametros(idParametro);
                if (!"*".equals(paramet.getIdParametro())) {
//si encuentra el dato cargamos los datos en el setAttribute
                    request.setAttribute("datos", paramet);
                } else {
                    mensaje = "El parámetro: " + idParametro + " no se encuentra registrado ";
                    request.setAttribute("datos", null);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } //cierra buscar

        if ("modificar".equals(request.getParameter("action"))) {
            try {
                //vereificamos que el registro no exista en la tabla   
                paramet = negocio.buscarParametros(idParametro);
                if (!paramet.getIdParametro().equals(idParametro)) {
                    mensaje = "El eparámetro no se encuentra registrado";
                } else {
                    try {
                        paramet.setNombreParametro(nombreParametro);
                        paramet.setValor(valor);

                        //guardamos los datos en la tabla
                        negocio.actualizarParametro(paramet);
                        mensaje = "El parámetro se actualizocorrectamente";
                        limpiar();

                    } catch (Exception e2) {
                        mensaje = "Error al actualizar el parámetro";
                        limpiar();
                    }

                }
            } catch (Exception e1) {
                mensaje = "El parámetro no se encuentra registrado";
                limpiar();
            }
        } //cierra modificar
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
