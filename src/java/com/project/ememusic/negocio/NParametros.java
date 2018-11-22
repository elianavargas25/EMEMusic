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

    
    public List<Parametros> listarParametros(Parametros Parametros) {
        Connection con;
        con = new Conexion().getCon();
        return dao.listarParametros(con, Parametros);
    }//fin public lista
    
}
