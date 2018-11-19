/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.negocio;

import com.project.ememusic.entidad.Informes;
import com.project.ememusic.entidad.Ventas;
import com.project.ememusic.persistencia.DaoInforme;
import com.project.ememusic.utilidades.Conexion;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author max
 */
public class NInformes {
    
    DaoInforme dao;
    public List<Ventas> listarIncidente(Ventas venta) {
        Connection con;
        con = new Conexion().getConexion();
        return dao.VentasporMes(con, venta);
    }//fin public lista
}
