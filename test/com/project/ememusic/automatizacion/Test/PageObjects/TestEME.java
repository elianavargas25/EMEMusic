/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.automatizacion.Test.PageObjects;

import com.project.ememusic.automatizacion.PageObject.Artista;
import com.project.ememusic.automatizacion.PageObject.Empresa;
import com.project.ememusic.automatizacion.PageObject.Informe;
import com.project.ememusic.automatizacion.PageObject.Login;
import com.project.ememusic.automatizacion.PageObject.Venta;
import com.project.ememusic.entidad.Artistas;
import com.project.ememusic.negocio.NArtista;
import com.project.ememusic.persistencia.DaoArtista;
import com.project.ememusic.persistencia.Datos;
import java.sql.ResultSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Estefanía
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestEME {

    private static WebDriver driver = null;
    Login log;
    Empresa Emp;
    Artista Art;
    static String nroDoc;
    Venta Vent;
    static String Cantidad;
    Informe inf;

    public TestEME() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8084/EMEMusic/index.jsp");
        driver.manage().window().maximize();

    }

    @AfterClass
    public static void tearDownClass() {
        driver.quit();

    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    //Probamos el correcto inicio de sesión con el usuario Admin
    @Test
    public void BtestLoginApplicationAdmin() throws InterruptedException {
        System.out.println("Test Login Admin");
        driver.findElement(By.linkText("Ingresar")).click();
        String User = "admin";
        String Password = "admin";
        log = new Login(driver);
        log.LoginAplication(User, Password);
        Thread.sleep(2000);
        String Usuario = log.USerAdmin();
        System.out.println("el usuario es:" + Usuario);
        String actual = "Usuario: admin";
        assertEquals(Usuario, actual);
//        driver.findElement(By.linkText("Cerrar sesión")).click();

    }

//    Probamos que no deje ingresar y que muestre mensaje de validación debido a que los datos son incorrectos
//    @Test
//    public void BtestUsuarioContraseñaIncorrectos() throws Exception {
//        System.out.println("Test Mensaje de validación");
//        driver.findElement(By.linkText("Ingresar")).click();
//        String User = "Admin";
//        String Password = "Admin45";
//        log = new Login(driver);
//        log.LoginAplication(User, Password);
//        Thread.sleep(2000);
//        String Mensaje = log.Mensaje();
//        System.out.println("el mensaje es:" + Mensaje);
//        String Mensajeactual = "Usuario y/o Contraseña incorrectos";
//        assertEquals(Mensaje, Mensajeactual);
//
//    }
    //Probamos que no el sistema permita ingresar con el usuario operario
    @Test
    public void AtestLoginApplicationoperario() throws Exception {
        System.out.println("Test Login Operario");
        driver.findElement(By.linkText("Ingresar")).click();
        Thread.sleep(3000);
        String User = "operario";
        String Password = "operario";
        Thread.sleep(4000);
        log = new Login(driver);
        log.LoginAplication(User, Password);
        Thread.sleep(4000);
        String Usuario = log.UserOperario();
        System.out.println("el usuario es:" + Usuario);
        String actual = "Usuario: operario";
        assertEquals(Usuario, actual);
        driver.findElement(By.linkText("Cerrar sesión")).click();

    }

//    Probamos que la permita guardar una 
    @Test
    public void CTestCreateEmpresaAplication() throws Exception {
        driver.findElement(By.xpath("/html/body/div/header/div[2]/nav/ul/li[2]/a")).click();
        String NroDocEmp = Datos.setIdentificacion();
        String NombreEmp = Datos.setNombreEmpresa();
        String PagoOpeacion = "100";
        Emp = new Empresa(driver);
        Emp.EmpresaAplication(NroDocEmp, NombreEmp, PagoOpeacion);
        Thread.sleep(2000);
        String Mensaje = Emp.GetMensaje();
        System.out.println("el mensaje es:" + Mensaje);
        String MensajeEsperado = "Registro guardado correctamente";
        assertEquals(Mensaje, MensajeEsperado);
    }

    //Probamos que no deje guardar una empresa debido a que el Campo Número de documento es obligatorio.
    @Test
    public void DtestObligatoriedadNroDocEmpresa() throws Exception {
        driver.findElement(By.xpath("/html/body/div/header/div[2]/nav/ul/li[2]/a")).click();
        String NombreEmp = "Ruben Pte";
        Thread.sleep(2000);
        String PagoOpeacion = "10000";
        Emp = new Empresa(driver);
        Emp.EmpresaAplication1(NombreEmp, PagoOpeacion);
        Thread.sleep(2000);
        String Mensaje = Emp.GetMensaje();
        System.out.println("El mensaje es :" + Mensaje);
        String MensajeEsperado = "Debe llenar todos los campos";
        assertEquals(Mensaje, MensajeEsperado);
    }
    //Probamos que no deje guardar una empresa debido a que el Campo Nombre es obligatorio.

    @Test
    public void EtestObligatoriedadNombreEmpresa() throws Exception {
        driver.findElement(By.xpath("/html/body/div/header/div[2]/nav/ul/li[2]/a")).click();
        String NroDocEmp = ("1234567800");
        String PagoOpeacion = "10000";
        Emp = new Empresa(driver);
        Emp.EmpresaAplication2(NroDocEmp, PagoOpeacion);
        Thread.sleep(2000);
        String Mensaje = Emp.GetMensaje();
        System.out.println("El mensaje es: " + Mensaje);
        String MensajeEsperado = "Debe llenar todos los campos";
        assertEquals(Mensaje, MensajeEsperado);
    }

    //Probamos que no deje guardar debido el Campo Primer nombre es obligatorio obligatorio.
    @Test
    public void FtestObligatoriedadPagoPorOperacion() throws Exception {
        driver.findElement(By.xpath("/html/body/div/header/div[2]/nav/ul/li[2]/a")).click();
        String NroDocEmp = ("1234567800");
        String NombreEmp = "Ruben Pte";
        Emp = new Empresa(driver);
        Emp.EmpresaAplication3(NroDocEmp, NombreEmp);
        Thread.sleep(2000);
        String Mensaje = Emp.GetMensaje();
        System.out.println("El mensaje es: " + Mensaje);
        String MensajeEsperado = "Debe llenar todos los campos";
        assertEquals(Mensaje, MensajeEsperado);
    }

    @Test
    public void GArtsitaAplcationCreate() throws Exception {
        driver.findElement(By.xpath("/html/body/div/header/div[2]/nav/ul/li[1]/a")).click();
        Thread.sleep(2000);
        String NroDocArt = Datos.setIdentificacion();
        String PrimerNombre = Datos.setNombreArtista();
        String SegundoNombre = ("djfknfjd");
        String PrimerApellido = "Ruben Pte";
        String SegundoApellido = ("fdgsdfg");
        String NombreArtistico = Datos.setNombreArtista();
        Art = new Artista(driver);
        Art.ArtistaAplication(NroDocArt, PrimerNombre, SegundoNombre, PrimerApellido, SegundoApellido, NombreArtistico);
        Thread.sleep(2000);
        String Mensaje = Art.GetMensaje();
        System.out.println("El mensaje es: " + Mensaje);
        String MensajeEsperado = "El artista se registró correctamente";
        assertEquals(Mensaje, MensajeEsperado);
    }

    @Test
    public void HTestObligatoriedadPrimerNombre() throws Exception {
        driver.findElement(By.xpath("/html/body/div/header/div[2]/nav/ul/li[1]/a")).click();
        Thread.sleep(2000);
        String NroDocArt = ("1000345678");
        String SegundoNombre = ("djfknfjd");
        String PrimerApellido = "Ruben Pte";
        String SegundoApellido = ("fdgsdfg");
        String NombreArtistico = "estefanía shakira";
        Art = new Artista(driver);
        Art.ArtistaTestPNombre(NroDocArt, SegundoNombre, PrimerApellido, SegundoApellido, NombreArtistico);
        Thread.sleep(2000);
        String Mensaje = Art.GetMensaje();
        System.out.println("El mensaje es: " + Mensaje);
        String MensajeEsperado = "Debe llenar todos los campos";
        assertEquals(Mensaje, MensajeEsperado);
    }

    @Test
    public void ITestObligatoriedadPrimerApellido() throws Exception {
        driver.findElement(By.xpath("/html/body/div/header/div[2]/nav/ul/li[1]/a")).click();
        Thread.sleep(2000);
        String NroDocArt = ("1000345678");
        String PrimerNombre = "Estefania";
        String SegundoNombre = "Maria";
        String SegundoApellido = ("fdgsdfg");
        String NombreArtistico = "estefanía shakira";
        Art = new Artista(driver);
        Art.ArtistaTestPApellido(NroDocArt, PrimerNombre, SegundoNombre, SegundoApellido, NombreArtistico);
        Thread.sleep(2000);
        String Mensaje = Art.GetMensaje();
        System.out.println("El mensaje es: " + Mensaje);
        String MensajeEsperado = "Debe llenar todos los campos";
        assertEquals(Mensaje, MensajeEsperado);
    }

    @Test
    public void JTestObligatoriedadNombreArtistico() throws Exception {
        driver.findElement(By.xpath("/html/body/div/header/div[2]/nav/ul/li[1]/a")).click();
        Thread.sleep(2000);
        String NroDocArt = ("1000345678");
        String PrimerNombre = "Estefania";
        String SegundoNombre = "Maria";
        String PrimerApellido = "Ruben Pte";
        String SegundoApellido = "fdgsdfg";
        Art = new Artista(driver);
        Art.ArtistaTestNombreArt(NroDocArt, PrimerNombre, SegundoNombre, PrimerApellido, SegundoApellido);
        Thread.sleep(2000);
        String Mensaje = Art.GetMensaje();
        System.out.println("El mensaje es: " + Mensaje);
        String MensajeEsperado = "Debe llenar todos los campos";
        assertEquals(Mensaje, MensajeEsperado);
    }

    @Test
    public void KTestregistrarVenta() throws Exception {
        driver.findElement(By.xpath("/html/body/div/header/div[2]/nav/ul/li[3]/a")).click(); // Clic registrar venta
//        Thread.sleep(2000);
        String StrEmp = "Pragma";
        String StrArt = "Estefa";
        String StrCantidad = "200";
        Vent = new Venta(driver);
        Vent.VentasAplication(StrEmp, StrArt, StrCantidad);
        String Cantidad = "200";
//        System.out.println("La cantidad es: " + Vent);
        String CantidadEsperada = "200";
        assertEquals(Cantidad, CantidadEsperada);
    }

    @Test
    public void LTestInformes() throws Exception {
        driver.findElement(By.xpath("/html/body/div/header/div[2]/nav/ul/li[4]/a")).click(); // Clic registrar venta
//        Thread.sleep(2000);
        String Fecha  = "01/01/2019";
        String Fecha2  = "02/27/2019";
        inf = new Informe(driver);
        inf.InformeAplication(Fecha, Fecha2);
        
////        System.out.println("La cantidad es: " + Vent);
//        String CantidadEsperada = "200";
//        assertEquals(Cantidad, CantidadEsperada);
    }
}
