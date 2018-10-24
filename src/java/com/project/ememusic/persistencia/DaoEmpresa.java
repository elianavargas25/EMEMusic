package com.project.ememusic.persistencia;

import com.project.ememusic.entidad.Empresa;
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
            stTD = db.getConexion().prepareStatement("SELECT  ID_EMPRESA,NOMBRE FROM EMPRESA;");
            ResultSet result = stTD.executeQuery();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(DaoTipoDocumento.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    

    public Empresa buscarEmpresa(Connection cxn, String Id_Empresa) {

        try {
            PreparedStatement em = cxn.prepareStatement(SqlEmpresa.getEmpresa(Id_Empresa));
            ResultSet ur = em.executeQuery();

            while (ur.next()) {
                emp.setId_empresa(ur.getString(1));
                emp.setTipoDocumento(ur.getString(2));
                emp.setNroDcumento(ur.getString(3));
                emp.setNombre(ur.getString(4));
                emp.setPago_operacion(ur.getString(5));
                emp.setEstado(ur.getString(6));
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

        if (!emp.getId_empresa().equals(Id_Empresa)) {
            System.out.println("La empresa no se encuentra regitrada en nuestra la base de datos");
        }
        return emp;
    }

    //insertar registro en la tabla
    public Empresa guardarEmpresa(Connection cxn, Empresa emp) {
        String mensaje = "";
        try {
            PreparedStatement ur = cxn.prepareStatement(SqlEmpresa.insertarEmpresa());
            
            ur.setString(2, emp.getTipoDocumento());
            ur.setString(3, emp.getNroDcumento());
            ur.setString(4, emp.getNombre());
            ur.setString(5, emp.getPagoOperacion());
            ur.setString(6, emp.getEstado());
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
            ur.setString(1, emp.getId_empresa());
            ur.setString(2, emp.getTipoDocumento());
            ur.setString(3, emp.getNroDcumento());
            ur.setString(4, emp.getNombre());
            ur.setString(5, emp.getPagoOperacion());
            ur.setString(6, emp.getEstado());

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
