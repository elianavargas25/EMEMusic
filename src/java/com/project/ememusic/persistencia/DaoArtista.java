/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.persistencia;

import com.project.ememusic.entidad.Artistas;
import com.project.ememusic.utilidades.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mileidy
 */
public class DaoArtista {

    Connection conn = Conexion.getInstance();

    Artistas artista = new Artistas();

    public ResultSet idArtista() {
        PreparedStatement stTD;
        try {
            stTD = conn.prepareStatement("SELECT  ID_ARTISTAS,NOMBRE_ARTISTICO FROM ARTISTAS");
            ResultSet result = stTD.executeQuery();
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(DaoTipoDocumento.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Artistas buscarArtista(String artist, String empresa) {
        try {
            PreparedStatement ar = conn.prepareStatement(SqlArtista.getArtista(artist, empresa));
//            ar.setString(1, artist);
//            ar.setString(2, empresa); 
            ResultSet art = ar.executeQuery();
            if (!art.next()) {                            //if rs.next() returns false
                //then there are no rows.
                System.out.println("No records found");
                return null;
            } else {
                do {
                    artista.setIdArtista(art.getString("id_artistas"));
                    artista.setNombreArtistico(art.getString("nombre_artistico"));
                    artista.setEmpresa(art.getString("id_empresa"));
                    artista.setEmpresa(art.getString("nombre"));
                    System.out.println("Busqueda exitosa...\n");
                    return artista;
                    // Get data from the current row and use it
                } while (art.next());
            }
        } catch (Exception e) {
            System.out.println("Error Artista no registrado...\n");
            e.getMessage();
        } finally {
            try {
            } catch (Exception e) {
            }
        }//cierra finally
        return null;
    }

    public Artistas buscarArtistas(String Documento, String tdocu) {
        try {
            PreparedStatement ar = conn.prepareStatement(SqlArtista.getArtista(Documento));
            ar.setString(1, Documento);
            ar.setString(2, tdocu);
            ResultSet art = ar.executeQuery();

            if (!art.next()) {                            //if rs.next() returns false
                //then there are no rows.
                System.out.println("No records found");
                return null;
            } else {
                do {
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
                    // Get data from the current row and use it
                } while (art.next());
            }
        } catch (Exception e) {
            System.out.println("Error Artista no registrado...\n");
            e.getMessage();
        } finally {
            try {
            } catch (Exception e) {
            }
        }//cierra finally
        if (!artista.getNroDocumento().equals(Documento) || !artista.getTipoDocumento().equals(tdocu)) {
            System.out.println("El Artista no se encuentra registrado en la base de datos");
        }
        return null;
    }

    public boolean existsArtista(String id, String type) {

        // Consultar a base de datos por el metodo SQL existente
        // Se pregunta si el número de de filas recuperadas es mayor a 0
        return true;
    }

    //insertar registro en la tabla
    public Artistas guardarArtista(Artistas artista) {//validar conexion
        String mensaje = "";
        try {
            PreparedStatement artist = conn.prepareStatement(SqlArtista.insertarArtista());
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
            } catch (Exception e) {
            }
        }//cierra finally
        return artista;
    }//cierra guardar

    //insertar registro en la tabla
    public Artistas actualizarArtistas(Artistas artista) {
        String mensaje = "";

        try {
            PreparedStatement stm = conn.prepareStatement(SqlArtista.actualizarArtista());

            stm.setString(1, artista.getPrimerNombre());
            stm.setString(2, artista.getSegundoNombre());
            stm.setString(3, artista.getPrimerApellido());
            stm.setString(4, artista.getSegundoApellido());
            stm.setString(5, artista.getNombreArtistico());
            stm.setString(6, artista.getEmpresa());
            stm.setString(7, artista.getEstado());
            stm.executeUpdate();

            System.out.println("Actualización de Artista exitosa...\n");
            if (stm.getUpdateCount() > 0) {
                mensaje = "El Artista se actualizo correctamente...\n";

            } else {
                mensaje = "Error al actualizar el Artista";
            }

        } catch (Exception e) {
            System.out.println("Error al actualizar Artista...\n");
            e.printStackTrace();
        } finally {
            try {
            } catch (Exception e) {
            }

        }//cierra finally
        return artista;
    }//cierra el metodo actualizar (no borrar)

}
