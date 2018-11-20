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
public class InfoInformes {
    Empresa empresa;
    Artistas artista;
    Ventas venta;
    Date fechaDesde, fechaHasta;

    public Empresa getEmpresa() {
        if(empresa == null){
            empresa = new Empresa();
        }
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Artistas getArtista() {
        if(artista == null){
            artista = new Artistas();
        }
        return artista;
    }

    public void setArtista(Artistas artista) {
        this.artista = artista;
    }

    public Ventas getVenta() {
        if(venta == null){
            venta = new Ventas();
        }
        return venta;
    }

    public void setVenta(Ventas venta) {
        this.venta = venta;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }
    
}
