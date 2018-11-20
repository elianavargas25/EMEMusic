package com.project.ememusic.persistencia;

import com.project.ememusic.entidad.Empresa;
import com.project.ememusic.entidad.TipoDocumento;
import com.project.ememusic.utilidades.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eliana.vargas
 */
public class DaoEmpresa {

    Empresa emp = new Empresa();

    public ResultSet idEmpresa() {
        Conexion db = new Conexion();
        PreparedStatement stTD;
        try {
            stTD = db.getConexion().prepareStatement("SELECT  ID_EMPRESA,NOMBRE FROM EMPRESA");
            ResultSet result = stTD.executeQuery();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(DaoTipoDocumento.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Empresa buscarEmpresa(Connection cxn, String NroDocumento, String TipoDocu) {
        try {
            PreparedStatement em = cxn.prepareStatement(SqlEmpresa.getEmpresa(NroDocumento));
            em.setString(1, NroDocumento);
            em.setString(2, TipoDocu);
            ResultSet ur = em.executeQuery();
            if (ur.next()) {
                while (ur.next()) {
                    emp.setId_empresa(ur.getString("ID_EMPRESA"));
                    emp.setTipoDocumento(ur.getString("DESCRIPCION"));
                    emp.setNroDcumento(ur.getString("NRO_DOCUMENTO"));
                    emp.setNombre(ur.getString("NOMBRE"));
                    emp.setPago_operacion(ur.getString("PAGO_OPERACION"));
                    emp.setEstado(ur.getString("ID_ESTADO"));
                    System.out.println("Busqueda exitosa...\n");
                }//cierra while
            } else {
                emp.setId_empresa("");
                emp.setTipoDocumento("");
                emp.setNroDcumento("");
                emp.setNombre("");
                emp.setPago_operacion("");
                emp.setEstado("");
            }
        } catch (Exception e) {
            System.out.println("Empresa no registrada...\n");
            e.getMessage();
        } finally {
            try {

                cxn.close();
            } catch (Exception e) {
            }
        }//cierra finally
        if (!emp.getNroDocumento().equals(NroDocumento) && emp.getTipoDocumento().equals(TipoDocu)) {
            System.out.println("La empresa no se encuentra regitrada en nuestra la base de datos");
        }
        return emp;
    }
    
     public Empresa buscarEmpresas(Connection cxn, String NroDocumento, String TipoDocu) {
        try {
            PreparedStatement em = cxn.prepareStatement(SqlEmpresa.getEmpresa(NroDocumento));
            em.setString(1, NroDocumento);
            em.setString(2, TipoDocu);
            ResultSet ur = em.executeQuery();
            
                while (ur.next()) {
                    emp.setId_empresa(ur.getString("ID_EMPRESA"));
                    emp.setTipoDocumento(ur.getString("ID_TIPO_DOCUMENTO"));
                    emp.setNroDcumento(ur.getString("NRO_DOCUMENTO"));
                    emp.setNombre(ur.getString("NOMBRE"));
                    emp.setPago_operacion(ur.getString("PAGO_OPERACION"));
                    emp.setEstado(ur.getString("ID_ESTADO"));
                    System.out.println("Busqueda exitosa...\n");
                }//cierra while
            
        } catch (Exception e) {
            System.out.println("Empresa no registrada...\n");
            e.getMessage();
        } finally {
            try {

                cxn.close();
            } catch (Exception e) {
            }
        }//cierra finally
        if (!emp.getNroDocumento().equals(NroDocumento) && !emp.getTipoDocumento().equals(TipoDocu)) {
            System.out.println("La empresa no se encuentra regitrada en nuestra la base de datos");
        }
        return emp;
    }
    
    //insertar registro en la tabla

    public Empresa guardarEmpresa(Connection cxn, Empresa emp) {
        String mensaje = "";
        try {
            PreparedStatement ur = cxn.prepareStatement(SqlEmpresa.insertarEmpresa());
            int index = 1;
            ur.setString(index++, emp.getTipoDocumento());
            ur.setString(index++, emp.getNroDocumento());
            ur.setString(index++, emp.getNombre());
            ur.setString(index++, emp.getPagoOperacion());
            ur.setString(index++, emp.getEstado());
            int result = ur.executeUpdate();
            System.out.println("Registro guardado exitosamente...\n");
            if (ur.getUpdateCount() > 0) {
                mensaje = "Registro guardado exitosamente";
            } else {
                mensaje = "Error al registrar la empresa";
            }
        } catch (Exception e) {
            System.out.println("Error al registrar la empresa");
            e.printStackTrace();
        } finally {
            try {
                cxn.close();
            } catch (Exception e) {
            }
        }//cierra finally
        return emp;
    }//cierra guardar

    public Empresa actualizarEmpresa(Connection cxn, Empresa inc) {
        String mensaje = "";
        try {
            PreparedStatement ur = cxn.prepareStatement(SqlEmpresa.actualizarEmpresa());
            int index = 1;
            ur.setString(index++, emp.getTipoDocumento());
            ur.setString(index++, emp.getNroDocumento());
            ur.setString(index++, emp.getNombre());
            ur.setString(index++, emp.getPagoOperacion());
            ur.setString(index++, emp.getEstado());

            System.out.println("Actualización de empresa exitosa...\n");
            if (ur.getUpdateCount() > 0) {
                mensaje = "La empresa se actualizó correctamente...\n";

            } else {
                mensaje = "Error al  actualizar la empresa";
            }

        } catch (Exception e) {
            System.out.println("Error al actualizar la empresa...\n");
            e.printStackTrace();
        } finally {
            try {
                cxn.close();
            } catch (Exception e) {
            }

        }//cierra finally
        return inc;
    }

}
