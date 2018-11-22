/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.persistencia;

import com.project.ememusic.entidad.Parametros;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mileidy
 */
public class DaoParametros {
    Parametros para = new Parametros();
    
      public List<Parametros> listarParametros(Connection con, Parametros parametros) {
        List<Parametros> result = new ArrayList<>();
        try {
            PreparedStatement lista = con.prepareStatement(SQLParametros.getLista());
            ResultSet respuesta = lista.executeQuery();
            while (respuesta.next()) {
                
                Parametros paramet = new Parametros();
                paramet.setIdParametro(respuesta.getString(1));
                paramet.setNombreParametro(respuesta.getString(2));
                paramet.setValor(respuesta.getString(3));
                result.add(paramet);
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
