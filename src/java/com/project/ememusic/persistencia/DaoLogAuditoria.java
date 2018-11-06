/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.persistencia;

import com.project.ememusic.entidad.LogAuditoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author eliana.vargas
 */
public class DaoLogAuditoria {

    LogAuditoria auditoria = new LogAuditoria();

    public List<LogAuditoria> ListaAuditoria(Connection con, LogAuditoria auditoria) {
        List<LogAuditoria> result = new ArrayList<>();
        try {
            PreparedStatement lista = con.prepareStatement(SqlLogAuditoria.getLista());
            ResultSet respuesta = lista.executeQuery();
            while (respuesta.next()) {
                int index = 1;
                LogAuditoria audi = new LogAuditoria();
                audi.setIdAuditoria(respuesta.getString(index++));
                audi.setIdUsuario(respuesta.getString(index++));
                audi.setTipoAccion(respuesta.getString(index++));
                audi.setFecha(respuesta.getDate(index++));
                audi.setNombreTabla(respuesta.getString(index++));
                audi.setNumeroPK(respuesta.getString(index++));
                audi.setDescripcion(respuesta.getString(index++));
                result.add(audi);
            }//fin while
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();//cierra la conexion de la bd
            } catch (Exception e) {
            }//fin try/catch
        }//fin try/catch/finall
        return result;
    }
    
    //insertar registro en la tabla
    public LogAuditoria guardarArtista(Connection con, LogAuditoria auditoria) {//validar conexion
        String mensaje = "";
        try {
            PreparedStatement audito = con.prepareStatement(SqlLogAuditoria.insertAuditoria());
            int index = 1;
            audito.setString(index++, auditoria.getIdUsuario());
            audito.setString(index++, auditoria.getTipoAccion());
            audito.setTimestamp(2, new java.sql.Timestamp(new Date().getTime()));
            audito.setString(index++, auditoria.getNombreTabla());
            audito.setString(index++, auditoria.getNumeroPK());
            audito.setString(index++, auditoria.getDescripcion());
            int result = audito.executeUpdate();
            System.out.println("Registro de auditoria exitoso...\n");
            if (audito.getUpdateCount() > 0) {
                mensaje = "La auditoria se registró correctamente";
            } else {
                mensaje = "Error al registrar auditoria";
            }
        } catch (Exception e) {
            System.out.println("Error al registrar auditoria");
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
            }
        }//cierra finally
        return auditoria;
    }//cierra guardar

}
