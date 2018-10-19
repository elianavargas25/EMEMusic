/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author eliana.vargas
 */
public class Conexion {

 //Configuracion de los datos de la BD
    private final String usuario = "root";
    private final String pass = "";
    private final String host = "127.0.0.1";
    private final String puerto= "3306";
    private final String nombre_BD = "music";
 
    private Connection con = null;
 
    public Connection getCon() {
        getConexionMYSQL();
        return con;
    }
 
    public void setCon(Connection con) {
        this.con = con;
    }
 
    public Conexion() {
    }
 
    //Metodo que se devuelve la conexion o null si hubo un error
    public Connection getConexionMYSQL() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String servidor = "jdbc:mysql://" + host + ":"+ puerto + "/" + nombre_BD;
            con = DriverManager.getConnection(servidor, usuario, pass);
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return con;
        }
    }
 
    public void cerrarBd() throws SQLException {
 
        this.con.close();
    }
 
    public static void main(String param[]) {
        Conexion c = new Conexion();
        try {
            ResultSet r = c.getCon().prepareStatement("Select * from perfil").executeQuery();
            if (r.next()) {
                System.out.println("id: " + " " + r.getString(1) + " nombre_perfil: "
                        + r.getString(2));
                while (r.next()) {
                    System.out.println("id: " + " " + r.getString(1) + " nombre_perfil: "
                        + r.getString(2));
 
                }
            } else {
                System.out.println("no hay datos");
            }
        } catch (Exception e) {
            System.out.println("Excepcion " + e.getMessage());
        } finally {
            try {
                c.cerrarBd();
            } catch (SQLException ex) {
 
            }
        }
 
    }
 
}
 
    

