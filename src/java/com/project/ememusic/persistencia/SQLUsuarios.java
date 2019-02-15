package com.project.ememusic.persistencia;

public class SQLUsuarios {
    // Validar el ingreso al sistema

    public static String validarIngreso(
            String usuario, String clave) {
        return "SELECT us.ID_USUARIO,\n"
                + "     us.NOMBRE_USUARIO,\n"
                + "     us.CLAVE,\n"
                + "     perf.NOMBRE_PERFIL,\n"
                + "     us.ACTIVO \n"
                + "    from usuario us inner join\n"
                + "   perfil perf on us.ID_TIPO_PERFIL= perf.ID_PERFIL\n"
                + "    where UPPER(us.NOMBRE_USUARIO) = UPPER(?) and "
                + "UPPER(us.CLAVE) = UPPER(?) and us.ACTIVO = 'S'";
    }// Regresamos al Daos.java
}
