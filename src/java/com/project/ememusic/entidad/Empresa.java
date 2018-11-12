/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.entidad;

/**
 *
 * @author Estefania
 */
public class Empresa {

    String IdEmpresa,TipoDocumento,NroDocumento,Nombre,PagoOperacion,Estado;

    public String getId_empresa() {
        return IdEmpresa;
    }

    public void setId_empresa(String IdEmpresa) {
        this.IdEmpresa = IdEmpresa;
    }

    public String getTipoDocumento() {
        return TipoDocumento;
    }

    public void setTipoDocumento(String TipoDocumento) {
        this.TipoDocumento = TipoDocumento;
    }

    public String getNroDocumento() {
        return NroDocumento;
    }

    public void setNroDcumento(String NroDocumento) {
        this.NroDocumento = NroDocumento;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPagoOperacion() {
        return PagoOperacion;
    }

    public void setPago_operacion(String PagoOperacion) {
        this.PagoOperacion = PagoOperacion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
}
