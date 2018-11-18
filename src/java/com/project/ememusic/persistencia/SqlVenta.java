/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.persistencia;

/**
 *
 * @author Mileidy
 */
public class SqlVenta {
    
//BUSCA REGISTRO EN LA TABLA

    public static String getVenta(String documento) {
        return "SELECT\n"
                + "                art.ID_ARTISTAS,\n"
                + "                td.ID_TIPO_DOCUMENTO,\n"
                + "                TD.DESCRIPCION,\n"
                + "                art.NRO_DOCUMENTO,\n"
                + "                art.PRIMER_NOMBRE,\n"
                + "                art.SEGUNDO_NOMBRE,\n"
                + "                art.PRIMER_APELLIDO,\n"
                + "                art.SEGUNDO_APELLIDO,\n"
                + "                art.NOMBRE_ARTISTICO,\n"
                + "                emp.ID_EMPRESA,\n"
                + "                art.ESTADO\n"
                + "                FROM artistas art \n"
                + "                INNER JOIN TIPO_DOCUMENTO td ON art.ID_TIPO_DOCUMENTO = td.ID_TIPO_DOCUMENTO \n"
                + "                INNER JOIN EMPRESA emp ON emp.ID_EMPRESA = art.ID_EMPRESA\n"
                + "                WHERE art.NRO_DOCUMENTO =? and art.ID_TIPO_DOCUMENTO =?";
    }
//INSERTAR (GUARDAR) UN REGISTRO EN LA TABLA

    public static String insertarVenta() {
        return "INSERT INTO `ventas`"
                 +" `ID_EMPRESA`, `ID_ARTISTAS`, `REPRODUCCION`, `FECHA_REGISTRO`"
                + "values (?,?,?,?)" ;
    }
    

}
