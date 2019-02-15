package com.project.ememusic.persistencia;

public class SQLUsuarioCrear {
    // Validar el ingreso al sistema
public static String getUsuario(String Nombre) {
        return "SELECT us.ID_USUARIO, us.NOMBRE_USUARIO, us.CLAVE, per.ID_PERFIL, us.ACTIVO FROM usuario us INNER JOIN PERFIL per ON per.ID_PERFIL = us.ID_TIPO_PERFIL WHERE us.NOMBRE_USUARIO =?";
    }
    
    
    
   public static String insertarUsuario() {
        return "INSERT INTO usuario"
                 + "(`NOMBRE_USUARIO`, `CLAVE`, `ID_TIPO_PERFIL`, `ACTIVO`)" 
                + " values (?,?,?,?)" ;//cambiar
    }
}
