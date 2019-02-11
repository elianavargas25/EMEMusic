package com.project.ememusic.automatizacion.Test.PageObjects;

import com.project.ememusic.automatizacion.PageObject.Empresa;
import com.project.ememusic.automatizacion.PageObject.Login;
import com.project.ememusic.automatizacion.PageObject.UserPage;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author estefanía
 */
public class EmpresaTest {

    private static WebDriver driver = null;
    Empresa Empre;
    Login log;
    UserPage user;

    //Account acco;
    //Deposit dep;
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

    /**
     * Test of loginApplication method, of class Login.
     */
    @org.junit.Test
    public void EmpresaTest() {
        driver.findElement(By.linkText("Ingresar")).click();
        driver.findElement(By.name("Usuario")).sendKeys("admin");
        driver.findElement(By.name("Clave")).sendKeys("admin");
        driver.findElement(By.name("action")).click();
        System.out.println("Test Empresa");
        driver.findElement(By.linkText("Registro de Empresas")).click();
        String Empresa = ("Music SA");
        String Mensaje = "Registro guardado correctamente";
        driver.findElement(By.name("cbotipodocumento")).sendKeys(Keys.DOWN);
        driver.findElement(By.name("cbotipodocumento")).sendKeys(Keys.DOWN);
        driver.findElement(By.name("cbotipodocumento")).sendKeys(Keys.RETURN);
        driver.findElement(By.name("cbotipodocumento")).click();
        driver.findElement(By.name("txtnrodocumento")).sendKeys("94584704");
        driver.findElement(By.name("txtnombre")).sendKeys(Empresa);
        driver.findElement(By.name("txtpagooperacion")).sendKeys("900");
        driver.findElement(By.name("optionStateS")).sendKeys(Keys.DOWN);
        //driver.findElement(By.name("optionStateS")).sendKeys(Keys.RETURN);
        driver.findElement(By.name("optionStateS")).click();
        driver.findElement(By.name("action")).click();
        String MensajeMostrado = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/center/h4")).getText();
        assertEquals(Mensaje, MensajeMostrado);
    }
}
