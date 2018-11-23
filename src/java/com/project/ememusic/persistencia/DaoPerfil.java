/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.project.ememusic.utilidades.Conexion;

/**
 *
 * @author eliana.vargas
 */
public class DaoPerfil {
    public ResultSet PERFIL() {
        Conexion db = new Conexion();
        PreparedStatement stTD;
        try {
            stTD = db.getConexion().prepareStatement("SELECT  ID_PERFIL,NOMBRE_PERFIL FROM PERFIL");
            ResultSet result = stTD.executeQuery();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(DaoPerfil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public int PERFIL( String PERFIL) {
        int PER = 0; 
        Conexion db = new Conexion();
        PreparedStatement stTD;
        try {
            stTD = db.getConexion().prepareStatement("SELECT ID_PERFIL FROM PERFIL where NOMBRE_PERFIL = '"+PERFIL+"'");
            ResultSet result = stTD.executeQuery();
            
            if (result.next()) {
                PER= result.getInt("ID_PERFIL");
            }
            return PER;
        } catch (SQLException ex) {
            Logger.getLogger(DaoPerfil.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
}
