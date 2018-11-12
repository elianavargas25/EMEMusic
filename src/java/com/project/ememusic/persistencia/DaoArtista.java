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
            if (art.next()) {
                while (art.next()) {
                    artista.setIdArtista(art.getString("id_artistas"));
                    artista.setTipoDocumento(art.getString("id_tipo_documento"));
                    artista.setNroDocumento(art.getString("nro_documento"));
                    artista.setPrimerNombre(art.getString("primer_nombre"));
                    artista.setSegundoNombre(art.getString("segundo_nombre"));
                    artista.setPrimerApellido(art.getString("primer_apellido"));
                    artista.setSegundoApellido(art.getString("segundo_apellido"));
                    artista.setNombreArtistico(art.getString("nombre_artistico"));
                    artista.setEmpresa(art.getString("id_empresa"));
                    artista.setEstado(art.getString("estado"));

                    System.out.println("Busqueda exitosa...\n");
                }//cierra while
            } else {
                artista.setIdArtista("");
                artista.setTipoDocumento("");
                artista.setNroDocumento("");
                artista.setPrimerNombre("");
                artista.setSegundoNombre("");
                artista.setPrimerApellido("");
                artista.setSegundoApellido("");
                artista.setNombreArtistico("");
                artista.setEmpresa("");
                artista.setEstado("");
            }

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
    
    public Artistas buscarArtistas(Connection con, String Documento, String tdocu) {
        try {
            PreparedStatement ar = con.prepareStatement(SqlArtista.getArtista(Documento));
            ar.setString(1, Documento);
            ar.setString(2, tdocu);
            ResultSet art = ar.executeQuery();
            while (art.next()) {
                Artistas artista = new Artistas();
               artista.setIdArtista(art.getString("id_artistas"));
                    artista.setTipoDocumento(art.getString("id_tipo_documento"));
                    artista.setNroDocumento(art.getString("nro_documento"));
                    artista.setPrimerNombre(art.getString("primer_nombre"));
                    artista.setSegundoNombre(art.getString("segundo_nombre"));
                    artista.setPrimerApellido(art.getString("primer_apellido"));
                    artista.setSegundoApellido(art.getString("segundo_apellido"));
                    artista.setNombreArtistico(art.getString("nombre_artistico"));
                    artista.setEmpresa(art.getString("id_empresa"));
                    artista.setEstado(art.getString("estado"));
                System.out.println("Busqueda exitosa...\n");
                return artista;
            }//cierra while
        } catch (Exception e) {
            System.out.println("Error Artista no registrado...\n");
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
    }
    
    
    
    

    //insertar registro en la tabla
    //insertar registro en la tabla
    public Artistas guardarArtista(Connection con, Artistas artista) {//validar conexion
        String mensaje = "";
        try {
            PreparedStatement artist = con.prepareStatement(SqlArtista.insertarArtista());
            int index = 1;
            artist.setString(index++, artista.getTipoDocumento());
            artist.setString(index++, artista.getNroDocumento());
            artist.setString(index++, artista.getPrimerNombre());
            artist.setString(index++, artista.getSegundoNombre());
            artist.setString(index++, artista.getPrimerApellido());
            artist.setString(index++, artista.getSegundoApellido());
            artist.setString(index++, artista.getNombreArtistico());
            artist.setString(index++, artista.getEmpresa());
            artist.setString(index++, artista.getEstado());
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
    }//cierra guardar

    //insertar registro en la tabla
    
    
    
    public Artistas actualizarArtistas(Connection con, Artistas artista){
    String mensaje= "";
    
        try {
         PreparedStatement stm= con.prepareStatement(SqlArtista.actualizarArtista());
         
         stm.setString(1, artista.getPrimerNombre());
         stm.setString(2, artista.getSegundoNombre());
         stm.setString(3, artista.getPrimerApellido());
         stm.setString(4, artista.getSegundoApellido());
         stm.setString(5, artista.getNombreArtistico());
         stm.setString(6, artista.getEmpresa());
         stm.setString(7, artista.getEstado());
         stm.executeUpdate();
         
         System.out.println("Actualización de Artista exitosa...\n");
         if(stm.getUpdateCount()>0){
         mensaje="El Artista se actualizo correctamente...\n";
         
         }else{
         mensaje="Error al actualizar el Artista";
         }
         
        } catch (Exception e) {
        System.out.println("Error al actualizar Artista...\n");
        e.printStackTrace();
        }finally{
            try {
               con.close();
            } catch (Exception e) {
            }
            
        }//cierra finally
     return artista;
    }//cierra el metodo actualizar (no borrar)

}
