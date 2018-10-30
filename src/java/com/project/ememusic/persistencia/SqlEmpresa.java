/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.persistencia;

/**
 *
 * @author Estefanía
 */
public class SqlEmpresa {
 public static String getEmpresa() {
        return "SELECT ID_EMPRESA,ID_TIPO_DOCUMENTO,NRO_DOCUMENTO,"
               + "NOMBRE,PAGO_OPERACION,ID_ESTADO";
    }
    //BUSCA REGISTRO EN LA TABLA
     public static String getEmpresa(String Id_empresa) {
        return "SELECT\n"
                + "   emp.id_empresa,\n"
                + "   emp.id_tipo_documento,\n"
                + "   emp.nro_documento,\n"
                + "   emp.nombre,\n"
                + "   emp.pago_operacion,\n"
                + "   emp.id_estado,\n"
                + "   FROM\n"
                + "   empresa emp\n"
                + "WHERE emp.id_empresa =?";
    }
//INSERTAR (GUARDAR) UN REGISTRO EN LA TABLA
    public static String insertarEmpresa() {
        return "INSERT INTO EMPRESA "
                + "VALUES(?,?,?,?,?,?)";
    }

    //ACTUALIZAR UN REGISTRO EN LA TABLA
    public static String actualizarEmpresa() {
        return "UPDATE EMPRESA emp SET"
              + "   emp.id_emoresa,\n"
                + "   emp.id_tipo_documento,\n"
                + "   emp.nro_documento,\n"
                + "   emp.nombre,\n"
                + "   emp.pago_operacion,\n"
                + "   emp.id_estado,\n"
                + "   FROM\n"
                + "   empresa emp\n"
                + "WHERE emp.id_empresa =?";    }
    
    
}
