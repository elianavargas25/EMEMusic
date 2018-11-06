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

    Connection c;
    DaoUsuarios dao = new DaoUsuarios();

    public Usuarios validarIngreso(String usuario, String clave) {
        c = new Conexion().getCon();
        return dao.validarIngreso(c, usuario, clave);
    }

} //cierra la clase

