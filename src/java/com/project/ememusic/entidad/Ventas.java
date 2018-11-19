/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.entidad;

import java.util.Date;


/**
 *
 * @author Mileidy
 */
public class Ventas {
<<<<<<< HEAD
    String idArtista,idEmpresa;
    Double reproduccion, TotalGanado;
=======
    String idArtista,idEmpresa,reproduccion;
    
>>>>>>> 1edb7b83f99f5935fd8e4c04bd6d3ccd41dce3dd
    Date fecha;

    public String getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(String idArtista) {
        this.idArtista = idArtista;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getReproduccion() {
        return reproduccion;
    }

    public void setReproduccion(String reproduccion) {
        this.reproduccion = reproduccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getTotalGanado() {
        return TotalGanado;
    }

    public void setTotalGanado(Double TotalGanado) {
        this.TotalGanado = TotalGanado;
    }
   
}
