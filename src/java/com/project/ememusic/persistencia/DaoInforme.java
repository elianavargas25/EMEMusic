/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.persistencia;

import com.project.ememusic.entidad.Informes;
import com.project.ememusic.entidad.Ventas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eliana.vargas
 */
public class DaoInforme {
    public List<Ventas> VentasporMes(Connection con, Ventas venta) {
        List<Ventas> result = new ArrayList<>();
        try {
            PreparedStatement lista = con.prepareStatement(SQLInformes.ListMes());
            ResultSet respuesta = lista.executeQuery();
            while (respuesta.next()) {
                Ventas ven = new Ventas();
                ven.setIdEmpresa(respuesta.getString(1));
                ven.setReproduccion(respuesta.getDouble(2));
                ven.setTotalGanado(respuesta.getDouble(3));
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
    
    public List<Ventas> VentasporArtista(Connection con, Ventas venta) {
        List<Ventas> result = new ArrayList<>();
        try {
            PreparedStatement lista = con.prepareStatement(SQLInformes.ListMes());
            ResultSet respuesta = lista.executeQuery();
            while (respuesta.next()) {
                Ventas ven = new Ventas();
                ven.setIdEmpresa(respuesta.getString(1));
                ven.setIdArtista(respuesta.getString(2));
                ven.setReproduccion(respuesta.getDouble(3));
                ven.setTotalGanado(respuesta.getDouble(4));
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
