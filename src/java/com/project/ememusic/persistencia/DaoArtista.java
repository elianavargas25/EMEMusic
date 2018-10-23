/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.persistencia;

import com.project.ememusic.entidad.Artistas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Mileidy
 */
public class DaoArtista {

    Artistas artista = new Artistas();

    public Artistas buscarArtista(Connection con, String Documento, String tdocu) {//validar conexion

        try {
            PreparedStatement ar = con.prepareStatement(SqlArtista.getArtista(Documento));
            ar.setString(1, Documento);
            ar.setString(2, tdocu);
            ResultSet art = ar.executeQuery();
                while (art.next()) {
                    artista.setTipoDocumento(art.getString("TipoDocumento"));
                    artista.setNroDocumento(art.getString("NroDocumento"));
                    artista.setPrimerNombre(art.getString("PrimerNombre"));
                    artista.setSegundoNombre(art.getString("SegundoNombre"));
                    artista.setPrimerApellido(art.getString("PrimerApellido"));
                    artista.setSegundoApellido(art.getString("SegundoApellido"));
                    artista.setNombreArtistico(art.getString("NombreArtistico"));
                    artista.setEmpresa(art.getString("Empresa"));
                    artista.setEstado(art.getString("Estado"));

                    System.out.println("Busqueda exitosa...\n");
                }//cierra while
            
        } catch (Exception e) {
            System.out.println("Error artista no registrado...\n");
            e.getMessage();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
            }
        }//cierra finally
        if (!artista.getNroDocumento().equals(Documento) || !artista.getTipoDocumento().equals(tdocu)) {
            System.out.println("El Artista no se encuentra registrado en la base de datos");
        }
        return artista;

    }//finaliza buscar

    //insertar registro en la tabla
    //insertar registro en la tabla
    public Artistas guardarArtista(Connection cnx, Artistas artista) {//validar conexion
        String mensaje = "";
        try {
            PreparedStatement artist = cnx.prepareStatement(SqlArtista.insertarArtista());
            
            artist.setString(2, artista.getTipoDocumento());
            artist.setString(3, artista.getNroDocumento());
            artist.setString(4, artista.getPrimerNombre());
            artist.setString(5, artista.getSegundoNombre());
            artist.setString(6, artista.getPrimerApellido());
            artist.setString(7, artista.getSegundoApellido());
            artist.setString(8, artista.getNombreArtistico());
            artist.setString(9, artista.getEmpresa());
            artist.setString(10, artista.getEstado());
            int result = artist.executeUpdate();
            System.out.println("Registro de Artista exitoso...\n");
            if (artist.getUpdateCount() > 0) {
                mensaje = "El Artista se registró correctamente";
            } else {
                mensaje = "Error al registrar Artista";
            }
        } catch (Exception e) {
            System.out.println("Error al registrar Artista");
            e.printStackTrace();
        } finally {
            try {
                cnx.close();
            } catch (Exception e) {
            }
        }//cierra finally
        return artista;
    }//cierra guardar

     //insertar registro en la tabla
      public Artistas actualizarArtista(Connection con, Artistas artista) {
        String mensaje = "";
        try {
            PreparedStatement artist = con.prepareStatement(SqlArtista.insertarArtista());
            int consecutivo = 0;
            ResultSet resultado = null;
            PreparedStatement instruccion = null;
            String sql = "SELECT " + "SEQ_ID_USUARIO " + ".NEXTVAL value FROM DUAL";
//validar
            instruccion = con.prepareStatement(sql);
            resultado = instruccion.executeQuery();
            if (resultado.next()) {
                consecutivo = resultado.getInt("value");
            }
            artist.setInt(1, consecutivo);
            artist.setString(2, artista.getTipoDocumento());
            artist.setString(3, artista.getNroDocumento());
            artist.setString(4, artista.getPrimerNombre());
            artist.setString(5, artista.getSegundoNombre());
            artist.setString(6, artista.getPrimerApellido());
            artist.setString(7, artista.getSegundoApellido());
            artist.setString(8, artista.getNombreArtistico());
            artist.setString(9, artista.getEmpresa());
            artist.setString(10, artista.getEstado());
            int result = artist.executeUpdate();
            System.out.println("Registro de Artista exitoso...\n");
            if (artist.getUpdateCount() > 0) {
                mensaje = "El Artista se registró correctamente";
            } else {
                mensaje = "Error al registrar Artista";
            }
        } catch (Exception e) {
            System.out.println("Error al registrar Artista");
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
            }
        }//cierra finally
        return artista;
    }//cierra actualizar
      
      

   
}
