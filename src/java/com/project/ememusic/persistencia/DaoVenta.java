/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.persistencia;

import com.project.ememusic.entidad.Ventas;
import com.project.ememusic.utilidades.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Mileidy
 */
public class DaoVenta {

    Connection con = Conexion.getInstance();
    Ventas venta = new Ventas();

    //insertar registro en la tabla
    public Ventas guardarVenta(Ventas venta) {//validar conexion
        String mensaje = "";
        try {
            PreparedStatement ven = con.prepareStatement(SqlVenta.insertarVenta());
            int index = 1;
            ven.setString(index++, venta.getIdArtista());
            ven.setDouble(index++, venta.getReproduccion());
            ven.setDate(index++, new java.sql.Date(new java.util.Date().getTime()));
            int result = ven.executeUpdate();
            System.out.println("El registro de ventas fue exitoso...\n");
            if (ven.getUpdateCount() > 0) {
                mensaje = "El informe de ventas se registró correctamente";
            } else {
                mensaje = "Error al registrar ventas";
            }
        } catch (Exception e) {
            System.out.println("Error al registrar ventas");
            e.printStackTrace();
        } finally {
            try {
            } catch (Exception e) {
            }
        }//cierra finally
        return venta;
    }//cierra guardar

}
