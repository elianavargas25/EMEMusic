/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.negocio;

import com.project.ememusic.entidad.Empresa;
import com.project.ememusic.persistencia.DaoEmpresa;
import com.project.ememusic.utilidades.Conexion;
import java.sql.Connection;

/**
 *
 * @author eliana.vargas
 */
public class NEmpresa {

    DaoEmpresa dao;

    public NEmpresa() {
        dao = new DaoEmpresa();
    }
//buscar registro

    public Empresa buscarEmpresa( String NroDocumento, String TipoDoc) {
        return dao.buscarEmpresa( NroDocumento, TipoDoc);
    }//fin buscar
    
    public Empresa buscarEmpresas( String NroDocumento, String TipoDoc) {
        return dao.buscarEmpresas( NroDocumento, TipoDoc);
    }//fin buscar

    public Empresa guardarEmpresa(Empresa empresa) throws Exception {
        String TipoDocumento = empresa.getTipoDocumento();
        String NroDocumento = empresa.getNroDocumento();
        String Nombre = empresa.getNombre();
        String PagoOperacion = empresa.getPagoOperacion();
        String Estado = empresa.getEstado();
        String error = "";
        if ("".equals(TipoDocumento) || TipoDocumento == null) {
            error += "<br> Por favor ingrese el tipo de documento";
        }
        if ("".equals(NroDocumento) || NroDocumento == null) {
            error += "<br> Por favor ingrese número de dcumento";
        }
        if ("".equals(Nombre) || Nombre == null) {
            error += "<br>Por favor infrese el nombre";
        }
        if ("".equals(PagoOperacion) || PagoOperacion == null) {
            error += "<br> Por favor ingrese el valor del pago por operación";
        }
        if ("".equals(Estado) || Estado == null) {
            error += "<br> Por favor seleccione el estado activo";
        }
        if (!"".equals(error)) {
            throw new Exception(error);
        }
        empresa = dao.guardarEmpresa(empresa);//revisar
        return empresa;//revisar
    }//fin guardar

    //Actualizar
    public Empresa actualizarEmpresa(Empresa emp) throws Exception {
        String IdEmpresa = emp.getId_empresa();
        String TipoDocumento = emp.getTipoDocumento();
        String NroDocumento = emp.getNroDocumento();
        String Nombre = emp.getNombre();
        String PagoOperacion = emp.getPagoOperacion();
        String Estado = emp.getEstado();
        String error = "";
        if ("".equals(TipoDocumento) || TipoDocumento == null) {
            error += "<br> Por favor ingrese tipo de documento";
        }
        if ("".equals(NroDocumento) || NroDocumento == null) {
            error += "<br>Por favor ingrese el número de documento";
        }
        if ("".equals(Nombre) || Nombre == null) {
            error += "<br> Por favor ingrese el nombre de la empresa";
        }
        if ("".equals(PagoOperacion) || PagoOperacion == null) {
            error += "<br> Por favor ingrese el pago por operación";
        }
        if ("".equals(Estado) || Estado == null) {
            error += "<br> Por favor ingrese el estado";
        }
        if (!"".equals(error)) {
            throw new Exception(error);
        }
        emp = dao.actualizarEmpresa( emp);
        return emp;
    }// Fin actualizar


}

