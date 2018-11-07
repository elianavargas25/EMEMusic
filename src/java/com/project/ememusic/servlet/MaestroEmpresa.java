
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
public class MaestroEmpresa  extends HttpServlet {
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
        try (PrintWriter out = response.getWriter()) {
            String IdEmpresa = request.getParameter("txtempresa");
            String TipoDocumento = request.getParameter("cbotipodocumento ");
            String NroDocumento = request.getParameter("txtnrodocumento");
            String Nombre = request.getParameter("txtnombre");
            String PagoOperacion = request.getParameter("txtpagooperacion");
            String Estado = request.getParameter("txtestadoS");
            String mensaje = "";
            String modulo = "Empresa.jsp"; // validar con la vista

            if ("Guardar".equals(request.getParameter("action"))) {
                try {
                    //verifica si existe el dato
                    empresa = negocio.buscarEmpresa( NroDocumento);
                    if (empresa.getNroDcumento().equals(NroDocumento)){
                        mensaje = "La empresa que desea registrar, ya se encuentra en sistema";
                    } else {
                        try {
                            empresa.setId_empresa(IdEmpresa);
                            empresa.setTipoDocumento(TipoDocumento);
                            empresa.setNroDcumento(NroDocumento);
                            empresa.setNombre(Nombre);
                            empresa.setPago_operacion(PagoOperacion);
                            empresa.setEstado(Estado);

                            //se guarda los datos en la tabla
                            negocio.guardarEmpresa(empresa);
                            mensaje = "Registro guardado correctamente";
                            limpiar();
                        } catch (Exception e2) {
                            mensaje = "Error en el registro , favor verificar";
                            limpiar();
                        }
                    }
                } catch (Exception e1) {
                    mensaje = "La empresa ya se encuentra registrado en la base de datos";
                    limpiar();
                }
            }//fin guardar

            //modificar
            if ("Modificar".equals(request.getParameter("action"))) {
                int NroDcocu = Integer.parseInt(NroDocumento);
                try {
                    //vereficamos que el registró no exista en la tabla 
                    empresa = negocio.buscarEmpresa(NroDocumento);
                    if (empresa.getNroDcumento().equals(NroDocumento)) {
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
            if ("limpiar".equals(request.getParameter("action"))) {
                limpiar();
            }//fin linpiar

            if ("Consultar".equals(request.getParameter("action"))) {
                int NroDcumento = Integer.parseInt(NroDocumento);
                try {
                    empresa = negocio.buscarEmpresa(NroDocumento);
                    if (empresa.getNroDcumento().equals(NroDocumento)) {
//si encuentra el dato cargamos los datos en el setAttribute
                        request.setAttribute("datos", empresa);

                    } else {
                        mensaje = "El artista: " + NroDcumento + "" + NroDocumento + " no se encuentra registrado ";
                        request.setAttribute("datos", null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } //cierra buscar
            request.setAttribute("mensaje", mensaje);
            request.getRequestDispatcher(modulo).forward(request, response);

        }
    }

    
    
}
