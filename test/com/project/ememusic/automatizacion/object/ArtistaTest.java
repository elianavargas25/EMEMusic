/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.ememusic.automatizacion.object;

import com.project.ememusic.automatizacion.PageObject.Artista;
import com.project.ememusic.automatizacion.PageObject.Login;
import com.project.ememusic.automatizacion.PageObject.UserPage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Estefanía
 */
public class ArtistaTest {

    private static WebDriver driver = null;
    Login log;
    UserPage user;
    Artista Art;

    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "lib\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass

    public static void tearDownClass() {

    }

    @Before
    public void setUp() {
        driver.get("http://localhost:8084/EMEMusic/index.jsp");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void ArtistaGuardar() throws InterruptedException {
        driver.findElement(By.linkText("Ingresar")).click();
        driver.findElement(By.name("Usuario")).sendKeys("admin");
        driver.findElement(By.name("Clave")).sendKeys("admin");
        driver.findElement(By.name("action")).click();
        System.out.println("Test Artistas");
        driver.findElement(By.linkText("Registro de Artistas")).click();
        String Artista = ("Ricardo Arjona");
        String Mensaje = "Registro guardado correctamente";
        driver.findElement(By.name("cbotipodocumento")).sendKeys(Keys.DOWN);
        driver.findElement(By.name("cbotipodocumento")).sendKeys(Keys.RETURN);
        driver.findElement(By.name("cbotipodocumento")).click();
        driver.findElement(By.name("txtnumdocumento")).sendKeys("972367");
        driver.findElement(By.name("txtprimernombre")).sendKeys("Ricardo");
        driver.findElement(By.name("txtsegundonombre")).sendKeys("Dario");
        driver.findElement(By.name("txtprimerapellido")).sendKeys("Arjona");
        driver.findElement(By.name("txtsegundopellido")).sendKeys("Velasquez");
        driver.findElement(By.name("txtnombreartistico")).sendKeys(Artista);
        driver.findElement(By.name("cboempresa")).sendKeys(Keys.DOWN);
        driver.findElement(By.name("cboempresa")).sendKeys(Keys.RETURN);
        driver.findElement(By.name("cboempresa")).click();
        driver.findElement(By.name("optionStateS")).sendKeys(Keys.DOWN);
        driver.findElement(By.name("optionStateS")).sendKeys(Keys.RETURN);
        driver.findElement(By.name("optionStateS")).click();
        driver.findElement(By.name("action")).click();
        String MensajeMostrado = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/center/h4")).getText();
        assertEquals(Mensaje, MensajeMostrado);

    }
    
     @Test
    public void ArtistaBuscar () {
    
    
    
    }
}
