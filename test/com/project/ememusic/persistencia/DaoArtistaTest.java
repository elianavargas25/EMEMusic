/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.persistencia;

import com.project.ememusic.entidad.Artistas;
import java.sql.Connection;
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
public class DaoArtistaTest {
    
    public DaoArtistaTest() {
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
     * Test of buscarArtista method, of class DaoArtista.
     */
    @Test
    public void testBuscarArtista() {
        System.out.println("buscarArtista");
        Connection con = null;
        String Documento = "123456";
        String tdocu = "1";
        DaoArtista instance = new DaoArtista();
        String expResult = "Busqueda exitosa";
        Artistas result = instance.buscarArtista(con, Documento, tdocu);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of guardarArtista method, of class DaoArtista.
     */
    @Test
    public void testGuardarArtista() {
        System.out.println("guardarArtista");
        Connection con = null;
        Artistas artista = null;
        DaoArtista instance = new DaoArtista();
        Artistas expResult = null;
        Artistas result = instance.guardarArtista(con, artista);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarArtista method, of class DaoArtista.
     */
    @Test
    public void testActualizarArtista() {
        System.out.println("actualizarArtista");
        Connection con = null;
        Artistas artista = null;
        DaoArtista instance = new DaoArtista();
        Artistas expResult = null;
        Artistas result = instance.actualizarArtista(con, artista);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
