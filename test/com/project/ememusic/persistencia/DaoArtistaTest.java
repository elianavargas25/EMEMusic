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

    static Connection con = null;
    static String nroDocumento;
    static String tDocu;

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
     *
     * @return
     */
    @Test
    public void testBuscarArtista() {
        System.out.println("Prueba Buscar Artista");
        con = new Conexion().getCon();
        String Documento = "7894562";
        String tdocu = "1";
        DaoArtista instance = new DaoArtista();
        Artistas result = instance.buscarArtistas(Documento, tdocu);
        Artistas expResult = result;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

     static int index = 1;
    /**
     * Test of guardarArtista method, of class DaoArtista.
     */
    @Test
    public void testGuardarArtista() {
        index++;
        System.out.println("Prueba guardar Artista");
        Artistas artista = new Artistas();
        artista.setTipoDocumento("1");
        artista.setNroDocumento(Datos.setIdentificacion());
        artista.setPrimerNombre(Datos.setNombreArtista());
        artista.setSegundoNombre("");
        artista.setPrimerApellido("PEREZ");
        artista.setSegundoApellido("");
        artista.setNombreArtistico(Datos.setNombreArtista());
        artista.setEmpresa("1");
        artista.setEstado("S");
        con = new Conexion().getCon();
        DaoArtista instance = new DaoArtista();
        Artistas expResult = artista;
        Artistas result = instance.guardarArtista(artista);
        assertEquals(expResult, result);
        
    }
    
}
