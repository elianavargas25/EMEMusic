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
    

}
