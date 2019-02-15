/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.negocio;

import com.project.ememusic.entidad.Artistas;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eliana.vargas
 */
public class NArtistaTest {
    
    public NArtistaTest() {
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
     * Test of buscarArtistas method, of class NArtista.
     */
    @Test
    public void testBuscarArtistas() {
        System.out.println("buscarArtistas");
        String docu = "";
        String tdocu = "";
        NArtista instance = new NArtista();
        Artistas expResult = null;
        Artistas result = instance.buscarArtistas(docu, tdocu);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarArtista method, of class NArtista.
     */
    @Test
    public void testGuardarArtista() throws Exception {
        System.out.println("guardarArtista");
        Artistas artista = null;
        NArtista instance = new NArtista();
        Artistas expResult = null;
        Artistas result = instance.guardarArtista(artista);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarArtistas method, of class NArtista.
     */
    @Test
    public void testActualizarArtistas() throws Exception {
        System.out.println("actualizarArtistas");
        Artistas art = null;
        NArtista instance = new NArtista();
        Artistas expResult = null;
        Artistas result = instance.actualizarArtistas(art);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
