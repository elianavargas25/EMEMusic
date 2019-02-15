/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.persistencia;

import com.project.ememusic.utilidades.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;

/**
 *
 * @author eliana.vargas
 */
public class DaoTipoDocumento {

    Connection con = Conexion.getInstance();

    public ResultSet tipoDoc() {
        PreparedStatement stTD;
        try {
            stTD = con.prepareStatement("SELECT  ID_TIPO_DOCUMENTO,DESCRIPCION FROM MUSIC.TIPO_DOCUMENTO");
            ResultSet result = stTD.executeQuery();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(DaoTipoDocumento.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int IdtipoDoc(String tipodocumento) {
        int tdocu = 0;
        PreparedStatement stTD;
        try {
            stTD = con.prepareStatement("SELECT ID_TIPO_DOCUMENTO FROM TIPO_DOCUMENTO where DESCRIPCION = '" + tipodocumento + "'");
            ResultSet result = stTD.executeQuery();

            if (result.next()) {
                tdocu = result.getInt("ID_TIPO_DOCUMENTO");
            }
            return tdocu;
        } catch (SQLException ex) {
            Logger.getLogger(DaoTipoDocumento.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
}
