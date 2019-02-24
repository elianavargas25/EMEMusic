
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.negocio;

import com.project.ememusic.entidad.Ventas;
;
import java.sql.Connection;
import com.project.ememusic.persistencia.DaoVenta;
import com.project.ememusic.utilidades.Conexion;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Mileidy
 */


public class NVenta {

    DaoVenta dao;

    public NVenta() {
        dao = new DaoVenta();
    }
//buscar registro

    public Ventas guardarVenta(Ventas venta) throws Exception {
        String IdArtista = venta.getIdArtista();
        String IdEmpresa = venta.getIdEmpresa();
        Double Reproduccion = venta.getReproduccion();
        String error = "";
        if ("".equals(IdArtista) || IdArtista == null) {
            error += "<br> Por favor ingrese el Nombre del Artista";
        }
        if ("".equals(IdEmpresa) || IdEmpresa == null) {
            error += "<br> Por favor ingrese la Empresa";
        }
        if ("".equals(Reproduccion) || Reproduccion == null) {
            error += "<br> Por favor ingrese la cantidad de reproducciones";
        }

        if (!"".equals(error)) {
            throw new Exception(error);
        }
        venta = dao.guardarVenta(venta);//revisar
        return venta;//revisar
    }//fin guardar
     public List<Ventas> listarVenta() {
        return dao.listarVentas();
    }//fin public list

    //Actualizar
}
