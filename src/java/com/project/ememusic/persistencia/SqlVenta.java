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

    
//INSERTAR (GUARDAR) UN REGISTRO EN LA TABLA

    public static String insertarVenta() {
        return "INSERT INTO music.ventas"
                 +"(`ID_ARTISTAS`, `REPRODUCCION`, `FECHA_REGISTRO`)"
                + " values (?,?,?)" ;
    }
    public static String listVenta() {
        return "SELECT emp.NOMBRE as empresa, \n"
                + "art.NOMBRE_ARTISTICO as artista,\n"
                + "ven.REPRODUCCION as reproduccion,\n"
                + "ven.FECHA_REGISTRO as fecha\n"
                + "FROM music.ventas ven INNER JOIN music.artistas art on art.ID_ARTISTAS = ven.ID_ARTISTAS "
                + "INNER JOIN music.empresa emp on emp.ID_EMPRESA = art.ID_EMPRESA";
    }
    

}
