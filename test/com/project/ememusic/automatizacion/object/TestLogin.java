
package com.project.ememusic.automatizacion.object;

import com.project.ememusic.automatizacion.pages.Artista;
import com.project.ememusic.automatizacion.pages.Login;
import com.project.ememusic.automatizacion.pages.UserPage;
import com.project.ememusic.entidad.Empresa;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Estefanía
 */
public class TestLogin {
    private static WebDriver driver = null;
    Login log;
    UserPage user;
    //Account acco;
    //Deposit dep;

    

    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "lib\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
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
    public  void testLoginApplication() {
        System.out.println("Prueba Login aplicación");
        driver.findElement(By.linkText("Ingresar")).click();
        String strUser  = "admin";
        String strPass= "admin";
        log = new Login(driver);
        log.loginApplication(strUser, strPass);
        user = new UserPage(driver);
        System.out.println("El usuario es " + user.UserName());
        String User = user.UserName();
        String actual = "Usuario: admin";
        assertEquals(User, actual);
        
        
}

}