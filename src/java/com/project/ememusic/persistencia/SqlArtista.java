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
public class SqlArtista {

//BUSCA REGISTRO EN LA TABLA
    public static String getArtista(String documento) {
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
                + "                FROM music.artistas art \n"
                + "                INNER JOIN music.TIPO_DOCUMENTO td ON art.ID_TIPO_DOCUMENTO = td.ID_TIPO_DOCUMENTO \n"
                + "                INNER JOIN music.EMPRESA emp ON emp.ID_EMPRESA = art.ID_EMPRESA\n"
                + "                WHERE art.NRO_DOCUMENTO =? and art.ID_TIPO_DOCUMENTO =?";
    }

    public static String getArtista(String artis, String empre) {
        return "SELECT art.ID_ARTISTAS, art.NOMBRE_ARTISTICO, emp.ID_EMPRESA, emp.NOMBRE FROM music.artistas art inner join \n"
                + "music.empresa emp on art.id_empresa=emp.id_empresa\n"
                + "where art.nombre_artistico like '%"+artis+"%' and emp.nombre like '%"+empre+"%' and art.estado='S' and emp.id_estado='S'";
    }
//INSERTAR (GUARDAR) UN REGISTRO EN LA TABLA

    public static String insertarArtista() {
        return "INSERT INTO music.artistas"
                + " ( `ID_TIPO_DOCUMENTO`, `NRO_DOCUMENTO`, `PRIMER_NOMBRE`, "
                + "`SEGUNDO_NOMBRE`, `PRIMER_APELLIDO`, `SEGUNDO_APELLIDO`, `NOMBRE_ARTISTICO`, `ID_EMPRESA`, `ESTADO`)"
                + "values (?,?,?,?,?,?,?,?,?)";
    }

    //Actualizar (GUARDAR) UN REGISTRO EN LA TABLA
    public static String actualizarArtista() {
        return "UPDATE music.artistas art SET `PRIMER_NOMBRE` = ?, `SEGUNDO_NOMBRE` = ?, "
                + "`PRIMER_APELLIDO`=?, `SEGUNDO_APELLIDO`=?, `NOMBRE_ARTISTICO`=?, `ID_EMPRESA`=?, `ESTADO`=? "
                + " WHERE `art`.`ID_ARTISTAS` = ?";

    }

}
