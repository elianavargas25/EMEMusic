/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.entidad;

import java.util.Date;

/**
 *
 * @author max
 */
public class Informes {
    String idInformes,nombreInforme, rutaInformes;
    Date fechaIngreso;

    public String getIdInformes() {
        return idInformes;
    }

    public void setIdInformes(String idInformes) {
        this.idInformes = idInformes;
    }

    public String getNombreInforme() {
        return nombreInforme;
    }

    public void setNombreInforme(String nombreInforme) {
        this.nombreInforme = nombreInforme;
    }

    public String getRutaInformes() {
        return rutaInformes;
    }

    public void setRutaInformes(String rutaInformes) {
        this.rutaInformes = rutaInformes;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
}
