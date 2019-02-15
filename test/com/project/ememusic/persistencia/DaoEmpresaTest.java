/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.persistencia;

import com.project.ememusic.entidad.Empresa;
import com.project.ememusic.utilidades.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author max
 */
public class DaoEmpresaTest {

    Connection con = null;

    public DaoEmpresaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of buscarEmpresas method, of class DaoEmpresa.
     */
    @Test
    public void testBuscarEmpresas() {
        System.out.println("Prueba Buscar Empresa");
        con = new Conexion().getCon();
        String NroDocumento = "45225233";
        String TipoDocu = "1";
        DaoEmpresa instance = new DaoEmpresa();
        Empresa result = instance.buscarEmpresas(NroDocumento, TipoDocu);
        Empresa expResult = result;
        assertEquals(expResult, result);
    }

    /**
     * Test of guardarEmpresa method, of class DaoEmpresa.
     */
    static int index = 1;
    

    @Test
    public void testGuardarEmpresa() {
        System.out.println("Prueba guardar Empresa");
        con = new Conexion().getCon();
        Empresa emp = new Empresa();
        emp.setTipoDocumento("1");
        index = index + 1;
        emp.setNroDcumento("45225233" + index);
        String[] abecedario = {"Aaa", "Bbb", "Cccc", "Dddd", "Eeee", "Fffff", "Gggg", "Hhhh", "Iiii", "Jjjj",
            "Kkkk", "Llll", "Mmmm", "Nnnn", "Oooo", "Pppp", "Qqqq", "Rrrr", "Ssss", "Tttt", "Uuuu", "vvv", "Wwww", "Xxxx", "Yyyy", "Zzzz"};
        int numRandom = (int) Math.round(Math.random() * 26);
        emp.setNombre(abecedario[numRandom]);
        emp.setPago_operacion("300");
        emp.setEstado("S");
        DaoEmpresa instance = new DaoEmpresa();
        Empresa expResult = emp;
        Empresa result = instance.guardarEmpresa(emp);
        assertEquals(expResult, result);
    }

}
