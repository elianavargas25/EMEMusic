
package com.project.ememusic.persistencia;

import com.project.ememusic.utilidades.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eliana.vargas
 */
public class DaoEmpresa {
    public ResultSet idEmpresa() {
        Conexion db = new Conexion();
        PreparedStatement stTD;
        try {
            stTD = db.getConexion().prepareStatement("SELECT  ID_EMPRESA,NOMBRE FROM EMPRESA;");
            ResultSet result = stTD.executeQuery();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(DaoTipoDocumento.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
