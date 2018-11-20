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
        return "SELECT \n"
                + "	ve.nombre as nacional_es_el_mejor,\n"
                + "	sum(ve.REPRODUCCION) as cantReprod,\n"
                + "	sum(ve.REPRODUCCION * ve.PAGO_OPERACION) as Ventastotal\n"
                + "	FROM (select emp.nombre, \n"
                + "	ven.REPRODUCCION , emp.pago_operacion, ven.FECHA_REGISTRO\n"
                + "	from music.ventas ven \n"
                + "	inner join music.artistas art on art.ID_ARTISTAS = ven.ID_ARTISTAS\n"
                + "	inner join music.empresa emp on emp.ID_EMPRESA = art.ID_EMPRESA) ve\n"
                + "	where ve.fecha_registro between ? and ?\n"
                + "    GROUP BY ve.nombre";
    }

    public static String ListArtis() {
        return "SSELECT \n"
                + "	ve.NOMBRE_ARTISTICO as nombreArtista,\n"
                + "	ve.nombre as nombreEmpresa,\n"
                + "	sum(ve.REPRODUCCION) as cantReprod,\n"
                + "	sum(ve.REPRODUCCION * ve.PAGO_OPERACION) as Ventastotal\n"
                + "	FROM (select emp.nombre, art.NOMBRE_ARTISTICO,\n"
                + "	ven.REPRODUCCION , emp.pago_operacion, ven.FECHA_REGISTRO\n"
                + "	from music.ventas ven \n"
                + "	inner join music.artistas art on art.ID_ARTISTAS = ven.ID_ARTISTAS\n"
                + "	inner join music.empresa emp on emp.ID_EMPRESA = art.ID_EMPRESA) ve\n"
                + "	where ve.fecha_registro between '2018-11-18' and '2018-11-19'\n"
                + "	GROUP BY ve.NOMBRE_ARTISTICO";
    }

}
