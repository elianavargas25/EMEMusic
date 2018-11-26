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
        String NroDocumento = "99825563";
        String TipoDocu = "2";
        DaoEmpresa instance = new DaoEmpresa();
        Empresa result = instance.buscarEmpresas(con, NroDocumento, TipoDocu);
        Empresa expResult = result;
        assertEquals(expResult, result);
    }

    /**
     * Test of guardarEmpresa method, of class DaoEmpresa.
     */
    @Test
    public void testGuardarEmpresa() {
        System.out.println("Prueba guardar Empresa");
        con = new Conexion().getCon();
        Empresa emp = null;
        DaoEmpresa instance = new DaoEmpresa();
        Empresa expResult = null;
        Empresa result = instance.guardarEmpresa(con, emp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarEmpresa method, of class DaoEmpresa.
     */
    @Test
    public void testActualizarEmpresa() {
        System.out.println("actualizarEmpresa");
        Connection cxn = null;
        Empresa inc = null;
        DaoEmpresa instance = new DaoEmpresa();
        Empresa expResult = null;
        Empresa result = instance.actualizarEmpresa(cxn, inc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
