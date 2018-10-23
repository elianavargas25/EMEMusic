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

    public static String getArtista() {
        return "SELECT\n"
                + "art.ID_TIPO_DOCUMENTO \n"
                + "FROM\n"
                + "artista art\n"
                + "INNER JOIN TIPO_DOCUMENTO td ON"
                + "art.ID_TIPO_DOCUMENTO = td.ID_TIPO_DOCUMENTO \n"
                + "WHERE art.NRO_DOCUMENTO =? and td.ID_TIPO_DOCUMENTO=?";
    }
//BUSCA REGISTRO EN LA TABLA

    public static String getArtista(String documento) {
        return "SELECT\n"
                + "art.ID_ARTISTA,\n"
                + "tu.ID_TIPO_DOCUMENTO,\n"
                + "td.ID_TIPO_DOCUMENTO,\n"
                + "TD.NOMBRE_TIPO_DOCUMENTO,\n"
                + "art.NRO_DOCUMENTO,\n"
                + "art.PRIMER_NOMBRE,\n"
                + "art.SEGUNDO_NOMBRE,\n"
                + "art.PRIMER_APELLIDO,\n"
                + "art.SEGUNDO_APELLIDO,\n"
                + "art.NOMBRE_ARTISTICO,\n"
                + "art.ID_EMPRESA,\n"
                + "art.ESTADO,\n"
                + "FROM\n"
                + "INNER JOIN TIPO_DOCUMENTO td ON us.ID_TIPO_DOCUMENTO = td.ID_TIPO_DOCUMENTO \n"
                + "INNER JOIN EMPRESA em ON art.EMPRESA = em.ID"
                + "WHERE art.NRO_DOCUMENTO =? and td.ID_TIPO_DOCUMENTO =?";
    }
//INSERTAR (GUARDAR) UN REGISTRO EN LA TABLA

    public static String insertarArtista() {
        return "INSERT INTO ARTISTAS"
                + "VALUES(?,?,?,?,?,?,?,?,?,?)";
    }

}
