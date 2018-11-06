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
public class SQLParametros {
    
    public static String getParametro(){
    
    return "SELECT COMPLETAR "
                + "FROM PARAMETROS";
    }
    //busca un registro en la tabla
    public static String getParametro(String IdParametro){    
    return "SELECT COMPLETAR "
           + "FROM PARAMETROS "
           + "WHERE IDPARAMETRO='"+IdParametro+"' ";
    }
    
    
    //actualizar un registro en la tabla
    
    public static String actualizarParametro(){
    
    return "UPDATE PARAMETROS";//completar
         
                
    }
    
    public static String  getLista() {
        return "SELECT\n";//completar 
                }
    
}
