/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.persistencia;

import com.project.ememusic.entidad.InfoInformes;
import com.project.ememusic.entidad.Informes;
import com.project.ememusic.entidad.Ventas;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eliana.vargas
 */
public class DaoInforme {
    public List<InfoInformes> VentasporMes(Connection con, Date fechaDesde, Date fechaHasta) {
        List<InfoInformes> result = new ArrayList<>();
        try {
            PreparedStatement lista = con.prepareStatement(SQLInformes.ListMes());
            lista.setDate(1, fechaDesde);
            lista.setDate(2, fechaHasta);
            ResultSet respuesta = lista.executeQuery();
            while (respuesta.next()) {
                InfoInformes ven = new InfoInformes();
                ven.getEmpresa().setNombre(respuesta.getString("nombreEmpresa"));
                ven.getVenta().setReproduccion(respuesta.getDouble("cantReprod"));
                ven.getVenta().setTotalGanado(respuesta.getDouble("Ventastotal"));
                result.add(ven);
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
    
    public List<InfoInformes> VentasporArtista(Connection con, Date fechaDesde, Date fechaHasta) {
        List<InfoInformes> result = new ArrayList<>();
        try {
            PreparedStatement lista = con.prepareStatement(SQLInformes.ListArtis());
            lista.setDate(1, fechaDesde);
            lista.setDate(2, fechaHasta);
            ResultSet respuesta = lista.executeQuery();
            while (respuesta.next()) {
                InfoInformes ven = new InfoInformes();
                ven.getArtista().setNombreArtistico(respuesta.getString("nombreArtista"));
                ven.getEmpresa().setNombre(respuesta.getString("nombreEmpresa"));
                ven.getVenta().setReproduccion(respuesta.getDouble("cantReprod"));
                ven.getVenta().setTotalGanado(respuesta.getDouble("Ventastotal"));
                result.add(ven);
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
}
