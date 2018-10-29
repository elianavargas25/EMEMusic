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
    
    public Parametros buscarUsuario(Connection con, String idParametro) {

        try {
            PreparedStatement par = con.prepareStatement(SQLParametros.getParametro(idParametro));
            par.setString(1, idParametro);
            
            ResultSet ur = par.executeQuery();
            while (ur.next()) {
                Parametros paramet = new Parametros();
                paramet.setIdParametro(ur.getString("idParametro"));
                paramet.setNombreParametro(ur.getString("nombreParametro"));
                paramet.setValor(ur.getString("valor"));
                System.out.println("Busqueda exitosa...\n");
                return paramet;
            } 
        } catch (Exception e) {
            System.out.println("Error parámetro no registrado...\n");
            e.getMessage();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
            }
        }//cierra finally
        if (!para.getIdParametro().equals(idParametro)) {
            System.out.println("El Parámetro no se encuentra registrado en la base de datos");
        }
        return para;
    }
    
     public Parametros actualizarParametro(Connection con, Parametros para) {
        String mensaje = "";

        try {
            PreparedStatement ur = con.prepareStatement(SQLParametros.actualizarParametro());

            ur.setString(1, para.getNombreParametro());
            ur.setString(2, para.getValor());
            ur.executeUpdate();
            
            System.out.println("Actualización de parámetro exitosa...\n");
            if (ur.getUpdateCount() > 0) {
                mensaje = "El parámetro se actualizo correctamente...\n";

            } else {
                mensaje = "Error al actualizar parámetro";
            }

        } catch (Exception e) {
            System.out.println("Error al actualizar parámetro...\n");
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
            }

        }//cierra finally
        return para;
    }
     
      public List<Parametros> listarParametros(Connection con, String idParametro) {
        List<Parametros> result = new ArrayList<>();
        try {
            PreparedStatement lista = con.prepareStatement(SQLParametros.getLista());
            lista.setString(1, idParametro);
           
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
