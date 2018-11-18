/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.negocio;

import com.project.ememusic.entidad.Ventas;;
import java.sql.Connection;
import com.project.ememusic.persistencia.DaoVenta;
import com.project.ememusic.utilidades.Conexion;

/**
 *
 * @author Mileidy
 */
public class NVenta {

    DaoVenta dao;
    Connection con;//validar

    public NVenta() {
        dao = new DaoVenta();
    }
//buscar registro

    
   

    public Ventas guardarVenta(Ventas venta) throws Exception {
        String IdArtista = venta.getIdArtista();
        String IdEmpresa = venta.getIdEmpresa();
        String IdVenta = venta.getIdVentas();
        String Reproduccion = venta.getReproduccion();
        String error = "";
        if ("".equals(IdArtista) || IdArtista == null) {
            error += "<br> Por favor ingrese el Nombre del Artista";
        }
        if ("".equals(IdEmpresa) || IdEmpresa == null) {
            error += "<br> Por favor ingrese la Empresa";
        }
        if ("".equals(IdVenta) || IdVenta == null) {
            error += "<br>Por favor ingrese la venta";
        }
        if ("".equals(Reproduccion) || Reproduccion == null) {
            error += "<br> Por favor ingrese la cantidad de reproducciones";
        }
        
        if (!"".equals(error)) {
            throw new Exception(error);
        }
        con = new Conexion().getCon();//validar
        venta = dao.guardarVenta(con,venta);//revisar
        return venta;//revisar
    }//fin guardar

    //Actualizar
   

}
