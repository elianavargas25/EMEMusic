
package com.project.ememusic.persistencia;

import com.project.ememusic.entidad.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DaoUsuarios {
    // Validar el ingreso al sistema
//Llamamos a las clases que vamos a necesitar.
      Usuarios miusuario = new Usuarios(); //instancia de la clase Entidad (usuario).
    
   // Método para validar el ingreso al sistema.
     public Usuarios validarIngreso(Connection con, String usuario, String clave) {
        try {
            PreparedStatement stm= con.prepareStatement(SQLUsuarios.validarIngreso(usuario, clave));
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
           if(miusuario.getIdUsuario().equals("*")){
           System.out.println("Usuario y/o Clave incorrectos...");    
           }
        } catch (Exception e) {
            // Controlar errores 
            e.printStackTrace();
            System.out.println("Error al comprobar el ingreso al sistema...");
        }finally{
            try {
                con.close();
            } catch (Exception e) {
            }
        }
        return miusuario;
    }  //fin validar Ingreso :::::::::::::::::::::::::::::::: 
}
