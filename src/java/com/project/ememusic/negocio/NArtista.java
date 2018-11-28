/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.negocio;

import com.project.ememusic.entidad.Artistas;;
import java.sql.Connection;
import com.project.ememusic.persistencia.DaoArtista;
import com.project.ememusic.utilidades.Conexion;

/**
 *
 * @author Mileidy
 */
public class NArtista {

    DaoArtista dao;
   

    public NArtista() {
        dao = new DaoArtista();
    }

    public Artistas buscarArtistas(String docu, String tdocu) {
        return dao.buscarArtistas( docu, tdocu);
    }//fin buscar

    public Artistas guardarArtista(Artistas artista) throws Exception {
        String TipoDocumento = artista.getTipoDocumento();
        String NroDocumento = artista.getNroDocumento();
        String PrimerNombre = artista.getPrimerNombre();
        String PrimerApellido = artista.getPrimerApellido();
        String NombreArtistico = artista.getNombreArtistico();
        String Empresa = artista.getEmpresa();
        String Estado = artista.getEstado();
        String error = "";
        if ("".equals(TipoDocumento) || TipoDocumento == null) {
            error += "<br> Por favor ingrese el tipo de documento";
        }
        if ("".equals(NroDocumento) || NroDocumento == null) {
            error += "<br> Por favor ingrese número de documento";
        }
        if ("".equals(PrimerNombre) || PrimerNombre == null) {
            error += "<br>Por favor ingrese el primer nombre";
        }
        if ("".equals(PrimerApellido) || PrimerApellido == null) {
            error += "<br> Por favor ingrese el primer apellido";
        }
        if ("".equals(NombreArtistico) || NombreArtistico == null) {
            error += "<br> Por favor ingrese el nombre artistico";
        }
        if ("".equals(Empresa) || Empresa == null) {
            error += "<br> Por favor ingrese la empresa";
        }
        if ("".equals(Estado) || Estado == null) {
            error += "<br> Por favor ingrese el estado";
        }
        if (!"".equals(error)) {
            throw new Exception(error);
        }
        artista = dao.guardarArtista(artista);//revisar
        return artista;//revisar
    }//fin guardar

    //Actualizar
    public Artistas actualizarArtistas(Artistas art) throws Exception {
        
        String PrimerNombre = art.getPrimerNombre();
        String SegundoNombre = art.getSegundoNombre();
        String PrimerApellido = art.getPrimerApellido();
        String NombreArtistico = art.getNombreArtistico();
        String Empresa = art.getEmpresa();
        String Estado = art.getEstado();
        String error = "";
        
        if ("".equals(PrimerNombre) || PrimerNombre == null) {
            error += "<br>Por favor infrese el primer nombre";
        }
        if ("".equals(PrimerApellido) || PrimerApellido == null) {
            error += "<br> Por favor ingrese el primer apellido";
        }
        if ("".equals(NombreArtistico) || NombreArtistico == null) {
            error += "<br> Por favor ingrese el nombre artistico";
        }
        if ("".equals(Empresa) || Empresa == null) {
            error += "<br> Por favor ingrese la empresa";
        }
        if ("".equals(Estado) || Estado == null) {
            error += "<br> Por favor ingrese el estado";
        }
        if (!"".equals(error)) {
            throw new Exception(error);
        }
        art = dao.actualizarArtistas( art);
        return art;
    }// Fin actualizar

}
