/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.servlet;

import com.project.ememusic.entidad.InfoInformes;
import com.project.ememusic.negocio.NInformes;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author max
 */
@WebServlet(name = "MaestroInformes", urlPatterns = {"/MaestroInformes"})
public class MaestroInformes extends HttpServlet {

    InfoInformes info = new InfoInformes();
    NInformes ninfo = new NInformes();

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
        String Filtro = request.getParameter("Filtro");
        int filtro = Integer.parseInt(Filtro);
        String fechaDesde = request.getParameter("txtDateFrom");
        String fechaHasta = request.getParameter("txtDateTo");
        Date fechaFrom = Date.valueOf(fechaDesde);
        Date fechaTo = Date.valueOf(fechaHasta);
        String mensaje = "";
        String modulo = "Informes.jsp";
        request.setAttribute("mensaje", null);
        request.setAttribute("modulo", null);
        request.setAttribute("lista", null);
        request.setAttribute("filtro", null);

        if ("Buscar".equals(request.getParameter("action"))) {
            if (fechaFrom.equals("") && fechaTo.equals("")) {
                mensaje = "Debe ingresar la fecha";
            }else
            if (filtro==1) {
                try {
                        List<InfoInformes> lista = ninfo.listarporArtis(fechaFrom, fechaTo);
                        request.setAttribute("lista", lista);
                        //request.setAttribute("filtro", filtro);
                    } catch (Exception e) {
                        Logger.getLogger(MaestroInformes.class.getName())
                                .log(Level.SEVERE, null, e);
                        mensaje += "" + e.getMessage();
                    }
            }else if (filtro==2) {
                try {
                        List<InfoInformes> lista = ninfo.listarporEmpre(fechaFrom, fechaTo);
                        request.setAttribute("lista", lista);
                        //request.setAttribute("filtro", filtro);
                      
                    } catch (Exception e) {
                        Logger.getLogger(MaestroInformes.class.getName())
                                .log(Level.SEVERE, null, e);
                        mensaje += "" + e.getMessage();
                    }
            }else if (filtro==3) {
                try {
                        List<InfoInformes> lista = ninfo.listarporEmpre(fechaFrom, fechaTo);
                        request.setAttribute("lista", lista);
                        //request.setAttribute("filtro", filtro);
                    } catch (Exception e) {
                        Logger.getLogger(MaestroInformes.class.getName())
                                .log(Level.SEVERE, null, e);
                        mensaje += "" + e.getMessage();
                    }
            }else {
                    mensaje = "Debe seleccionar una opción de la lista";
            }
        }
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
