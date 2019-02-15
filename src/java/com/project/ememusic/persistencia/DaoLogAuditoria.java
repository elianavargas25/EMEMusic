/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.persistencia;

import com.project.ememusic.entidad.LogAuditoria;
import com.project.ememusic.utilidades.Conexion;
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

    Connection conn = Conexion.getInstance();

    LogAuditoria auditoria = new LogAuditoria();

    public List<LogAuditoria> ListaAuditoria(LogAuditoria auditoria) {
        List<LogAuditoria> result = new ArrayList<>();
        try {
            PreparedStatement lista = conn.prepareStatement(SqlLogAuditoria.getLista());
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
            } catch (Exception e) {
            }//fin try/catch
        }//fin try/catch/finall
        return result;
    }

}
