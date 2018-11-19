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

    String idArtista,idEmpresa,reproduccion;
    Double  TotalGanado;
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
