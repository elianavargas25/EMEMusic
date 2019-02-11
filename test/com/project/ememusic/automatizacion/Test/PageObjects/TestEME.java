/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.automatizacion.Test.PageObjects;

import com.project.ememusic.automatizacion.PageObject.Empresa;
import com.project.ememusic.automatizacion.PageObject.Login;
import com.project.ememusic.entidad.Artistas;
import com.project.ememusic.negocio.NArtista;
import com.project.ememusic.persistencia.DaoArtista;
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
    public void CtestLoginApplicationAdmin() throws InterruptedException {
        System.out.println("Test Login Admin");
       // driver.findElement(By.linkText("Ingresar")).click();
        String User = "admin";
        String Password = "admin";
        log = new Login(driver);
        log.LoginAplication(User, Password);
        Thread.sleep(2000);
        String Usuario = log.USerAdmin();
        System.out.println("el usuario es:" + Usuario);
        String actual = "Usuario: admin";
        assertEquals(Usuario, actual);
       // driver.findElement(By.linkText("Cerrar sesión")).click();

    }

    //Probamos que no deje ingresar y que muestre mensaje de validación debido a que los datos son incorrectos
    @Test
    public void BtestUsuarioContraseñaIncorrectos() throws Exception {
        System.out.println("Test Mensaje de validación");
        driver.findElement(By.linkText("Ingresar")).click();
        String User = "Admin";
        String Password = "Admin45";
        log = new Login(driver);
        log.LoginAplication(User, Password);
        Thread.sleep(2000);
        String Mensaje = log.Mensaje();
        System.out.println("el mensaje es:" + Mensaje);
        String Mensajeactual = "Usuario y/o Contraseña incorrectos";
        assertEquals(Mensaje, Mensajeactual);

    }

    //Probamos que no el sistema permita ingresar con el usuario operario
    @Test
    public void AtestLoginApplicationoperario() throws Exception {
        System.out.println("Test Login Operario");
        driver.findElement(By.linkText("Ingresar")).click();
        String User = "operario";
        String Password = "operario";
        log = new Login(driver);
        log.LoginAplication(User, Password);
        Thread.sleep(2000);
        String Usuario = log.UserOperario();
        System.out.println("el usuario es:" + Usuario);
        String actual = "Usuario: operario";
        assertEquals(Usuario, actual);
        driver.findElement(By.linkText("Cerrar sesión")).click();

    }

    //Probamos que la permita guardar una 
    @Test
    public void DTestCreateEmpresaAplication() throws Exception {
        driver.findElement(By.linkText("Registro de Empresas")).click();
        String NroDocEmp = ("12345678910");
        String NombreEmp = "Ruben Pte";
        String PagoOpeacion = "1000000000000";
        Emp = new Empresa(driver);
        Emp.EmpresaAplication(NroDocEmp, NombreEmp, PagoOpeacion);
        String Msj= Emp.SetMensaje();
        System.out.println("el mensaje es:" + Msj);
        String MensajeEsperado = "Registro guardado correctamente";
        assertEquals(Msj, MensajeEsperado);
    }

    //Probamos que no deje guardar debido el Campo Primer nombre es obligatorio obligatorio.
    @Test
    public void testObligatoriedadPrimerApellido() throws Exception {

    }

    //Probamos que no deje guardar debido el Campo Primer nombre es obligatorio obligatorio.
}
