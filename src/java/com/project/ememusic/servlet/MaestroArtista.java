/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.servlet;

import com.project.ememusic.entidad.Artistas;
import com.project.ememusic.negocio.NArtista;
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
@WebServlet(name = "MaestroArtista", urlPatterns = {"/MaestroArtista"})
public class MaestroArtista extends HttpServlet {

    Artistas artista = new Artistas();
    NArtista negocio = new NArtista();

    public void limpiar() {
        artista.setTipoDocumento("");
        artista.setNroDocumento("");
        artista.setPrimerNombre("");
        artista.setSegundoNombre("");
        artista.setPrimerApellido("");
        artista.setSegundoApellido("");
        artista.setNombreArtistico("");
        artista.setEmpresa("");
        artista.setEstado("");
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
        String TipoDocumento = request.getParameter("cbotipodocumento");
        String NroDocumento = request.getParameter("txtnumdocumento");
        String PrimerNombre = request.getParameter("txtprimernombre");
        String SegundoNombre = request.getParameter("txtsegundonombre");
        String PrimerApellido = request.getParameter("txtprimerapellido");
        String SegundoApellido = request.getParameter("txtsegundopellido");
        String NombreArtistico = request.getParameter("txtnombreartistico");
        String Empresa = request.getParameter("cboempresa");
        String Estado = request.getParameter("optionStateS");//validar

        String mensaje = "";
        String modulo = "Artista.jsp"; // validar con la vista

        request.setAttribute("mensaje", null);
        request.setAttribute("modulo", null);
        request.setAttribute("datos", null);

        if ("Guardar".equals(request.getParameter("action"))) {
            try {
                //verifica si existe el dato
                artista = negocio.buscarArtistas(NroDocumento, TipoDocumento);
                //if (artista.getNroDocumento().equals(NroDocumento) && artista.getTipoDocumento().equals(TipoDocumento) || artista.getNombreArtistico().equals(NombreArtistico)) {
                if (artista != null) {
                    mensaje = "El Artista que desea registrar, ya se encuentra en sistema";
                } else {
                    try {
                        artista = new Artistas();
                        artista.setTipoDocumento(TipoDocumento);
                        artista.setNroDocumento(NroDocumento);
                        artista.setPrimerNombre(PrimerNombre);
                        artista.setSegundoNombre(SegundoNombre);
                        artista.setPrimerApellido(PrimerApellido);
                        artista.setSegundoApellido(SegundoApellido);
                        artista.setNombreArtistico(NombreArtistico);
                        artista.setEmpresa(Empresa);
                        artista.setEstado(Estado);

                        //se guarda los datos en la tabla
                        negocio.guardarArtista(artista);
                        mensaje = "El artista se registró correctamente";
                        limpiar();
                    } catch (Exception e2) {
                        mensaje = "Error en el registro de artista, favor verificar";
                        limpiar();
                    }
                }
            } catch (Exception e1) {
                mensaje = "El artista ya se encuentra registrado en la base de datos";
                limpiar();

            }
        }//fin guardar

        if ("modificar".equals(request.getParameter("action"))) {
            try {
                //vereificamos que el registro no exista en la tabla   
                artista = negocio.buscarArtistas(NroDocumento, TipoDocumento);
                if (artista.getNroDocumento().equals(NroDocumento) && artista.getTipoDocumento().equals(TipoDocumento)) {
                    mensaje = "El Artista no se  encuentra registrado";
                } else {
                    try {
                        artista.setPrimerNombre(PrimerNombre);
                        artista.setSegundoNombre(SegundoNombre);
                        artista.setPrimerApellido(PrimerApellido);
                        artista.setSegundoApellido(SegundoApellido);
                        artista.setNombreArtistico(NombreArtistico);
                        artista.setEmpresa(Empresa);
                        artista.setEstado(Estado);
                        //guardamos los datos en la tabla
                        negocio.actualizarArtistas(artista);
                        mensaje = "El Artista fue actualizado correctamente";
                        limpiar();
                        request.setAttribute("datos", artista);
                    } catch (Exception e2) {
                        mensaje = "Error al actualizar el Artista";
                        limpiar();
                        request.setAttribute("datos", artista);
                    }
                }
            } catch (Exception e1) {
                mensaje = "El Artista no esta registrado";
                limpiar();
                request.setAttribute("datos", artista);
            }
        } //cierra modificar

        //modificar
        if ("Actualizar".equals(request.getParameter("action"))) {
            try {
                //vereficamos que el registró no exista en la tabla 
                artista = negocio.buscarArtistas(NroDocumento, TipoDocumento);
                if (artista.getNroDocumento().equals(NroDocumento) && artista.getTipoDocumento().equals(TipoDocumento)) {
                    mensaje = "El artistaque desea registrar, ya se encuentra en sistema";
                } else {
                    try {
                        artista.setTipoDocumento(artista.getTipoDocumento());//validar

                        //guardamos los datos en la tabla
                        negocio.actualizarArtistas(artista);
                        mensaje = "El artista se ha actualizado correctamente";
                        limpiar();

                    } catch (Exception e2) {
                        mensaje = "Error al actualizar datos del artista " + NroDocumento + "";
                        limpiar();
                    }
                }
            } catch (Exception e1) {
                mensaje = "El artista no se encuentra registrado en la base de datos - verificar";
                limpiar();
            }
        }//fin modificar
        if ("Cancelar".equals(request.getParameter("action"))) {
            limpiar();
            request.setAttribute("datos", artista);
        }//fin linpiar

        if ("Buscar".equals(request.getParameter("action"))) {
            try {
                artista = negocio.buscarArtistas(NroDocumento, TipoDocumento);
                if (artista.getNroDocumento().equals(NroDocumento) && artista.getTipoDocumento().equals(TipoDocumento)) {
//si encuentra el dato cargamos los datos en el setAttribute
                    request.setAttribute("datos", artista);
                } else {
                    mensaje = "El artista: " + TipoDocumento + "" + NroDocumento + " no se encuentra registrado ";
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
