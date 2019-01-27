package com.project.ememusic.servlet;

import com.project.ememusic.entidad.Empresa;
import com.project.ememusic.negocio.NEmpresa;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Estefanía
 */
@WebServlet(name = "MaestroEmpresa", urlPatterns = {"/MaestroEmpresa"})
public class MaestroEmpresa extends HttpServlet {

    Empresa empresa = new Empresa();
    NEmpresa negocio = new NEmpresa();

    public void limpiar() {
        empresa.setId_empresa("");
        empresa.setTipoDocumento("");
        empresa.setNroDcumento("");
        empresa.setNombre("");
        empresa.setPago_operacion("");
        empresa.setEstado("");
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
        String NroDocumento = request.getParameter("txtnrodocumento");
        String Nombre = request.getParameter("txtnombre");
        String PagoOperacion = request.getParameter("txtpagooperacion");
        String Estado = request.getParameter("optionStateS");
        String mensaje = "";
        String modulo = "Empresa.jsp";
        request.setAttribute("mensaje", null);
        request.setAttribute("modulo", null);
        request.setAttribute("datos", null);

        if ("Guardar".equals(request.getParameter("action"))) {
            try {
                //verifica si existe el dato
                empresa = negocio.buscarEmpresas(NroDocumento, TipoDocumento);
               // if (empresa.getNroDocumento().equals(NroDocumento) && empresa.getTipoDocumento().equals(TipoDocumento) || empresa.getNombre().equals(Nombre)) {
                if (empresa!=null) {
                    mensaje = "La empresa que desea registrar, ya se encuentra en sistema ";
                } else {
                    try {
                        empresa = new Empresa();
                        empresa.setTipoDocumento(TipoDocumento);
                        empresa.setNroDcumento(NroDocumento);
                        empresa.setNombre(Nombre);
                        empresa.setPago_operacion(PagoOperacion);
                        empresa.setEstado(Estado);

                        //se guarda los datos en la tabla
                        negocio.guardarEmpresa(empresa);
                        mensaje = "Registro guardado correctamente";

                    } catch (Exception e2) {
                        mensaje = "Error en el registro , favor verificar";

                    }
                }
            } catch (Exception e1) {
                mensaje = "La empresa ya se encuentra registrado en la base de datos";
                limpiar();
                request.setAttribute("datos", empresa);

            }
        }//fin guardar

        //modificar
        if ("Modificar".equals(request.getParameter("action"))) {
            try {
                //vereficamos que el registró no exista en la tabla 
                empresa = negocio.buscarEmpresas(NroDocumento, TipoDocumento);
                if (empresa.getNroDocumento().equals(NroDocumento) && empresa.getTipoDocumento().equals(TipoDocumento)) {
                    mensaje = "La empresa que desea registrar, ya se encuentra en sistema";
                } else {
                    try {
                        empresa.setTipoDocumento(empresa.getTipoDocumento());//validar%$&%%/////////7

                        //guardamos los datos en la tabla
                        negocio.actualizarEmpresa(empresa);
                        mensaje = "La empresa se ha actualizado correctamente";
                        limpiar();

                    } catch (Exception e2) {
                        mensaje = "Error al actualizar datos de la empresa" + NroDocumento + "";
                        limpiar();
                    }
                }
            } catch (Exception e1) {
                mensaje = "La empresa no se encuentra registrado en la base de datos - verificar";
                limpiar();
            }
        }//fin modificar
        if ("Cancelar".equals(request.getParameter("action"))) {
            limpiar();
            request.setAttribute("datos", empresa);
        }//fin linpiar

        if ("Buscar".equals(request.getParameter("action"))) {
            try {
                empresa = negocio.buscarEmpresas(NroDocumento, TipoDocumento);
                if (empresa.getNroDocumento().equals(NroDocumento) && empresa.getTipoDocumento().equals(TipoDocumento)) {
                    //si encuentra el dato cargamos los datos en el setAttribute
                    request.setAttribute("datos", empresa);
                } else {
                    mensaje = "La empresa: " + empresa.getTipoDocumento() + " " + NroDocumento + " no se encuentra registrado ";
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
