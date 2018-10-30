/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.entidad;

import java.util.Date;

/**
 *
 * @author eliana.vargas
 */
public class ControlArchivo {
    String idControlArchivo, nombreArchivo, cantidadLeidos,cantidadErrores;
    Date fechaCargue;

    public String getIdControlArchivo() {
        return idControlArchivo;
    }

    public void setIdControlArchivo(String idControlArchivo) {
        this.idControlArchivo = idControlArchivo;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getCantidadLeidos() {
        return cantidadLeidos;
    }

    public void setCantidadLeidos(String cantidadLeidos) {
        this.cantidadLeidos = cantidadLeidos;
    }

    public String getCantidadErrores() {
        return cantidadErrores;
    }

    public void setCantidadErrores(String cantidadErrores) {
        this.cantidadErrores = cantidadErrores;
    }

    public Date getFechaCargue() {
        return fechaCargue;
    }

    public void setFechaCargue(Date fechaCargue) {
        this.fechaCargue = fechaCargue;
    }

   
    
}
