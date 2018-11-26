
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
     // driver.quit();
    }

    /**
     * Test of loginApplication method, of class Login.
     */
    @org.junit.Test
    public  void testLoginApplication() {
        String User =("Usuario: admin");
        driver.findElement(By.linkText("Ingresar")).click();
        driver.findElement(By.name("Usuario")).sendKeys("admin");
        driver.findElement(By.name("Clave")).sendKeys("admin");
        driver.findElement(By.name("action")).click();
        String UserCap= driver.findElement(By.xpath("/html/body/div/header/nav/ul/h4")).getText();
        assertEquals(User, UserCap);
        
        
}

   @org.junit.Test
    public void Artista (){
   
    }
    
    
    
}

