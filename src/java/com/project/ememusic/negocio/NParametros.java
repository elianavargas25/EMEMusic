/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.negocio;

import com.project.ememusic.entidad.Parametros;
import com.project.ememusic.persistencia.DaoParametros;
import com.project.ememusic.utilidades.Conexion;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Mileidy
 */
public class NParametros {
    
    DaoParametros dao;
    Connection con;
    
    public NParametros() {
        dao = new DaoParametros();

    }
    //buscar registro 

    public Parametros buscarParametros(String idParametro) {
        con = new Conexion().getCon();
        return dao.buscarUsuario(con, idParametro);
    }//fin buscar
    
    public Parametros actualizarParametro(Parametros usu) throws Exception {

        String nombreParametro = usu.getNombreParametro();
        String valor = usu.getValor();
        
        String error = "";

        con = new Conexion().getCon();

        if ("".equals(nombreParametro) || nombreParametro == null) {
            error += "<br> Por favor ingrese el nombre del parámetro ";
        }

        if ("".equals(valor) || valor == null) {
            error += "<br> Por favor ingrese el valor del parámetro";
        }
        if (!"".equals(error)) {
            throw new Exception(error);
        }
        usu = dao.actualizarParametro(con, usu);
        return usu;
    }// Fin actualizar 
    
    public List<Parametros> listarParametros(String idParametro) {
        Connection con;
        con = new Conexion().getCon();
        return dao.listarParametros(con, idParametro);
    }//fin public lista
    
}
