/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.persistencia;

/**
 *
 * @author ELIANA
 */
public class Datos {
    //Método para el set de datos

    public static String setNombreArtista() {
        String[] nombres = {"Andrea", "Andres", "Carolina", "David", "Juan", "José", "Miguel", "Antonio", "maria", "teresa", "mariana", "pedro", "Felipe", "George", "Hugo", "Ivan", "Roberto",
            "Kelly", "Liliana", "Martha", "Nelson", "Octavio", "Pablo", "Ramon", "Rigo", "Sandra", "Tulio", "Yazmin", "Viviana", "Wendy", "Xiomara", "Yuliana", "Zoraida"};
        int numRandom = (int) Math.round(Math.random() * 3);
        return nombres[numRandom];
    }
    
    public static String setNombreEmpresa() {
        String[] nombres = {"Andrea", "Andres", "Carolina", "David", "Juan", "José", "Miguel", "Antonio", "maria", "teresa", "mariana", "pedro", "Felipe", "George", "Hugo", "Ivan", "Roberto",
            "Kelly", "Liliana", "Martha", "Nelson", "Octavio", "Pablo", "Ramon", "Rigo", "Sandra", "Tulio", "Yazmin", "Viviana", "Wendy", "Xiomara", "Yuliana", "Zoraida"};
        int numRandom = (int) Math.round(Math.random() * 3);
        return nombres[numRandom];
    }
    
    
}
