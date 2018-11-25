/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.persistencia;

import com.project.ememusic.entidad.Artistas;
import com.project.ememusic.utilidades.Conexion;
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
            Connection con = null;

    
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
        con = new Conexion().getCon();
        String Documento = "123456";
        String tdocu = "1";
        DaoArtista instance = new DaoArtista();
        Artistas artista = new Artistas();
        Artistas result = instance.buscarArtista(con, Documento, tdocu);
        Artistas expResult = artista;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of guardarArtista method, of class DaoArtista.
     */
    @Test
    public void testGuardarArtista() {
        System.out.println("guardar Artista");
        Artistas artista = new Artistas();
        artista.setTipoDocumento("1");
        artista.setNroDocumento("789456123");
        artista.setPrimerNombre("Pepito");
        artista.setSegundoNombre("");
        artista.setPrimerApellido("Pérez");
        artista.setSegundoApellido("");
        artista.setNombreArtistico("Pepito flow");
        artista.setEstado("S");
        artista.setEmpresa("1");
        con = new Conexion().getCon();
        DaoArtista instance = new DaoArtista();
        Artistas expResult = artista;
        Artistas result = instance.guardarArtista(con, artista);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    
    
}
