package com.project.ememusic.persistencia;

import com.project.ememusic.entidad.Usuarios;
import com.project.ememusic.persistencia.SQLUsuarioCrear;
import com.project.ememusic.utilidades.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoUsuarios {

    // Validar el ingreso al sistema
//Llamamos a las clases que vamos a necesitar

    Connection con = Conexion.getInstance();
    Usuarios miusuario = new Usuarios(); //instancia de la clase Entidad (usuario).

    // Método para validar el ingreso al sistema.
    public Usuarios validarIngreso(String usuario, String clave) {
        try {
            PreparedStatement stm = con.prepareStatement(SQLUsuarios.validarIngreso(usuario, clave));
            stm.setString(1, usuario);
            stm.setString(2, clave);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                //SELECT codigo,nombre,clave,perfil,estado  
                miusuario.setIdUsuario(rs.getString(1));
                miusuario.setNombre(rs.getString(2));
                miusuario.setClave(rs.getString(3));
                miusuario.setPerfil(rs.getString(4));
                miusuario.setEstado(rs.getString(5));
                System.out.println("Usuario logueado correctamente...");
            } //cierra el while          
            if (!miusuario.getNombre().equals(usuario) || !miusuario.getClave().equals(clave)) {
                System.out.println("Usuario y/o Clave incorrectos...");
            }
        } catch (Exception e) {
            // Controlar errores 
            e.printStackTrace();
            System.out.println("Error al comprobar el ingreso al sistema...");
        } finally {
            try {
                con.close();
            } catch (Exception e) {
            }
        }
        return miusuario;
    }  //fin validar Ingreso :::::::::::::::::::::::::::::::: 

    public Usuarios guardarUsuario(Usuarios miusuario) {//validar conexion
        String mensaje = "";
        try {
            PreparedStatement us = con.prepareStatement(SQLUsuarioCrear.insertarUsuario());
            int index = 1;
            us.setString(index++, miusuario.getNombre());
            us.setString(index++, miusuario.getClave());
            us.setString(index++, miusuario.getPerfil());
            us.setString(index++, miusuario.getEstado());

            int result = us.executeUpdate();
            System.out.println("El registro de Usuario fue exitoso...\n");
            if (us.getUpdateCount() > 0) {
                mensaje = "El Usuario se registró correctamente";
            } else {
                mensaje = "Error al registrar Usuario";
            }
        } catch (Exception e) {
            System.out.println("Error al registrar Usuario");
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
            }
        }//cierra finally
        return miusuario;
    }//cierra guardar

    public Usuarios buscarUsuario(String Nombre) {//validar conexion
        try {
            PreparedStatement ar = con.prepareStatement(SQLUsuarioCrear.getUsuario(Nombre));
            ar.setString(1, Nombre);
            ResultSet art = ar.executeQuery();
            while (art.next()) {
                miusuario.setIdUsuario(art.getString("id_usuario"));
                miusuario.setNombre(art.getString("nombre_usuario"));
                miusuario.setClave(art.getString("clave"));
                miusuario.setPerfil(art.getString("id_perfil"));
                miusuario.setEstado(art.getString("activo"));

                System.out.println("Busqueda exitosa...\n");
            }//cierra while

        } catch (Exception e) {
            System.out.println("Error Usuario no registrado...\n");
            e.getMessage();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
            }
        }//cierra finally
        if (!miusuario.getNombre().equals(Nombre)) {
            System.out.println("El Usuario no se encuentra registrado en la base de datos");
        }
        return miusuario;

    }//finaliza buscar

}
