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
    String idInformes, nombreInforme, rutaInforme;
    Date fechaInforme;

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

    public String getRutaInforme() {
        return rutaInforme;
    }

    public void setRutaInforme(String rutaInforme) {
        this.rutaInforme = rutaInforme;
    }

    public Date getFechaInforme() {
        return fechaInforme;
    }

    public void setFechaInforme(Date fechaInforme) {
        this.fechaInforme = fechaInforme;
    }
    
}
