/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.servlet;

import com.project.ememusic.entidad.Ventas;
import com.project.ememusic.negocio.NVenta;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author max
 */
@WebServlet(name = "MaestroVentas", urlPatterns = {"/MaestroVentas"})
public class MaestroVentas extends HttpServlet {
    
     Ventas venta = new Ventas();
    NVenta negocio = new NVenta();

    public void limpiar() {
        venta.setIdArtista("");
        venta.setIdEmpresa("");
        venta.setReproduccion(0.0);
        
    }//limpiar

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
        String idArtista = request.getParameter("cboartista");
        String idEmpresa = request.getParameter("cboempresa");
        String reproduccion = request.getParameter("txtreproduccion");
        double reprod = Double.parseDouble(reproduccion);
        String mensaje = "";
        String modulo = "RegistrarVentas.jsp"; // validar con la vista

        //request.setAttribute("mensaje", null);
        request.setAttribute("modulo", null);
        request.setAttribute("datos", null);
        
        if ("Guardar".equals(request.getParameter("action"))) {
           
                    try {
                        venta.setIdArtista(idArtista);
                        venta.setIdEmpresa(idEmpresa);
                        venta.setReproduccion(reprod);
                        
                        //se guarda los datos en la tabla
                        negocio.guardarVenta(venta);
                        mensaje = "El informe de las ventas se registró correctamente";
                        limpiar();
                    } catch (Exception e2) {
                        mensaje = "Error en el registro de informe de ventas, favor verificar";
                        limpiar();
                    }
                }//fin guardar
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

