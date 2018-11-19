/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.persistencia;

/**
 *
 * @author max
 */
public class SQLInformes {

    public static String ListMes() {
        return "SELECT  emp.NOMBRE,\n"
                + "sum( REPRODUCCION) as cantReprod,\n"
                + "sum(REPRODUCCION * PAGO_OPERACION) as Ventastotal\n"
                + "FROM (select distinct emp.nombre from music.ventas ve \n"
                + "inner join music.empresa emp on emp.id_empresa = ve.id_empresa)\n"
                + "where ve.fecha_registro between '2018-11-18' and '2018-11-20'";
    }
}
