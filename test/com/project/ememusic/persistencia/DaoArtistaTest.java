/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.persistencia;

import com.project.ememusic.entidad.Artistas;
import com.project.ememusic.negocio.NArtista;
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
        System.out.println("Prueba Buscar Artista");
        con = new Conexion().getCon();
        String Documento = "123456";
        String tdocu = "1";
        DaoArtista instance = new DaoArtista();
        Artistas result = instance.buscarArtistas(con, Documento, tdocu);
        Artistas expResult = result;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of guardarArtista method, of class DaoArtista.
     */
    @Test
    public void testGuardarArtista() {
        System.out.println("Prueba guardar Artista");
        Artistas artista = new Artistas();
        artista.setTipoDocumento("1");
        artista.setNroDocumento("789456123");
        artista.setPrimerNombre("Pepito");
        artista.setSegundoNombre("");
        artista.setPrimerApellido("Pérez");
        artista.setSegundoApellido("");
        artista.setNombreArtistico("Pepito flow");
        artista.setEmpresa("2");
        artista.setEstado("S");
        con = new Conexion().getCon();
        DaoArtista instance = new DaoArtista();
        Artistas expResult = artista;
        Artistas result = instance.guardarArtista(con, artista);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    //Probamos que no deje guardar debido el Campo Tipo Documento es obligatorio obligatorio.

    @Test
    public void testObligatoriedadTipoDocumento() throws Exception {
        System.out.println("Obligatoriedad campo tipo documento");
        Artistas a = new Artistas();
        a.setTipoDocumento("");
        a.setNroDocumento("1020550658");//Campo obligatorio
        a.setPrimerNombre("Juan");
        a.setSegundoNombre("");
        a.setPrimerApellido("Montes");
        a.setSegundoApellido("");
        a.setNombreArtistico("JMontes");
        a.setEmpresa("2");
        a.setEstado("S");
        NArtista instance = new NArtista();
        String expResult = "<br> Por favor ingrese el tipo de documento";//No debe guardar un nuevo artista.
        Artistas result = instance.guardarArtista(a);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
    //Probamos que no deje guardar debido el Campo Nro Documento es obligatorio obligatorio.

    @Test
    public void testObligatoriedadNroDocumento() throws Exception {
        System.out.println("Obligatoriedad campo Nro documento");
        Artistas a = new Artistas();
        a.setTipoDocumento("1");
        a.setNroDocumento("");//Campo obligatorio
        a.setPrimerNombre("Juan");
        a.setSegundoNombre("");
        a.setPrimerApellido("Montes");
        a.setSegundoApellido("");
        a.setNombreArtistico("JMontes");
        a.setEmpresa("2");
        a.setEstado("S");
        NArtista instance = new NArtista();
        String expResult = "<br> Por favor ingrese número de documento";//No debe guardar un nuevo artista.
        Artistas result = instance.guardarArtista(a);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
    //Probamos que no deje guardar debido el Campo Primer nombre es obligatorio obligatorio.

    @Test
    public void testObligatoriedadPrimerNombre() throws Exception {
        System.out.println("Obligatoriedad campo Primer nombre");
        Artistas a = new Artistas();
        a.setTipoDocumento("1");
        a.setNroDocumento("14225223");//Campo obligatorio
        a.setPrimerNombre("");
        a.setSegundoNombre("");
        a.setPrimerApellido("Montes");
        a.setSegundoApellido("");
        a.setNombreArtistico("JMontes");
        a.setEmpresa("2");
        a.setEstado("S");
        NArtista instance = new NArtista();
        String expResult = "<br>Por favor ingrese el primer nombre";//No debe guardar un nuevo artista.
        Artistas result = instance.guardarArtista(a);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    //Probamos que no deje guardar debido el Campo Primer nombre es obligatorio obligatorio.

    @Test
    public void testObligatoriedadPrimerApellido() throws Exception {
        System.out.println("Obligatoriedad campo Primer apellido");
        Artistas a = new Artistas();
        a.setTipoDocumento("1");
        a.setNroDocumento("14225223");//Campo obligatorio
        a.setPrimerNombre("Juan");
        a.setSegundoNombre("");
        a.setPrimerApellido("");
        a.setSegundoApellido("");
        a.setNombreArtistico("JMontes");
        a.setEmpresa("2");
        a.setEstado("S");
        NArtista instance = new NArtista();
        String expResult = "<br>Por favor ingrese el primer apellido";//No debe guardar un nuevo artista.
        Artistas result = instance.guardarArtista(a);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    //Probamos que no deje guardar debido el Campo Primer nombre es obligatorio obligatorio.

    @Test
    public void testObligatoriedadNombreArtistico() throws Exception {
        System.out.println("Obligatoriedad campo Nombre artístico");
        Artistas a = new Artistas();
        a.setTipoDocumento("1");
        a.setNroDocumento("14225223");//Campo obligatorio
        a.setPrimerNombre("Juan");
        a.setSegundoNombre("");
        a.setPrimerApellido("Montes");
        a.setSegundoApellido("");
        a.setNombreArtistico("");
        a.setEmpresa("2");
        a.setEstado("S");
        NArtista instance = new NArtista();
        String expResult = "<br> Por favor ingrese el nombre artistico";//No debe guardar un nuevo artista.
        Artistas result = instance.guardarArtista(a);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    
    //Probamos que no deje guardar debido el Campo Empresa es obligatorio obligatorio.

    @Test
    public void testObligatoriedadEmpresa() throws Exception {
        System.out.println("Obligatoriedad campo Empresa");
        Artistas a = new Artistas();
        a.setTipoDocumento("1");
        a.setNroDocumento("14225223");//Campo obligatorio
        a.setPrimerNombre("Juan");
        a.setSegundoNombre("");
        a.setPrimerApellido("Montes");
        a.setSegundoApellido("");
        a.setNombreArtistico("");
        a.setEmpresa("");
        a.setEstado("S");
        NArtista instance = new NArtista();
        String expResult = "<br> Por favor ingrese la empresa";//No debe guardar un nuevo artista.
        Artistas result = instance.guardarArtista(a);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
    }
    //Probamos que no deje guardar debido el Campo Estado es obligatorio obligatorio.

    @Test
    public void testObligatoriedadEstado() throws Exception {
        System.out.println("Obligatoriedad campo Estado");
        Artistas a = new Artistas();
        a.setTipoDocumento("1");
        a.setNroDocumento("14225223");//Campo obligatorio
        a.setPrimerNombre("Juan");
        a.setSegundoNombre("");
        a.setPrimerApellido("");
        a.setSegundoApellido("");
        a.setNombreArtistico("JMontes");
        a.setEmpresa("2");
         a.setEstado("");
        NArtista instance = new NArtista();
        String expResult = "<br> Por favor ingrese el estado";//No debe guardar un nuevo artista.
        Artistas result = instance.guardarArtista(a);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
    }
}
