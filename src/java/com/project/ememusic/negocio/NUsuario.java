/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.negocio;

import com.project.ememusic.entidad.Usuarios;
import com.project.ememusic.persistencia.DaoUsuarios;
import com.project.ememusic.utilidades.Conexion;
import java.sql.Connection;

/**
 *
 * @author eliana.vargas
 */
public class NUsuario {

    DaoUsuarios dao = new DaoUsuarios();

    public Usuarios validarIngreso(String usuario, String clave) {
        return dao.validarIngreso(usuario, clave);
    }
    
    
    public NUsuario() {
        dao = new DaoUsuarios();
    }
//buscar registro

    public Usuarios guardarUsuario(Usuarios usuario) throws Exception {
        String nombre = usuario.getNombre();
        String clave = usuario.getClave();
        String perfil = usuario.getPerfil();
        String estado = usuario.getEstado();
        String error = "";
        if ("".equals(nombre) || nombre == null) {
            error += "<br> Por favor ingrese el Nombre de Usuario";
        }
        if ("".equals(clave) || clave == null) {
            error += "<br> Por favor ingrese la Clave";
        } 
        
        if ("".equals(perfil) || perfil == null) {
            error += "<br> Por favor ingrese el perfil de Usuario";
        }
        if ("".equals(estado) || estado == null) {
            error += "<br> Por favor ingrese el estado del Usuario";
        }
        
        if (!"".equals(error)) {
            throw new Exception(error);
        }
        usuario = dao.guardarUsuario(usuario);//revisar
        return usuario;//revisar
    }//fin guardar
    
    public Usuarios buscarUsuario(String nombre) {
        return dao.buscarUsuario( nombre);
    }//fin buscar
    
    
    
    

} //cierra la clase

