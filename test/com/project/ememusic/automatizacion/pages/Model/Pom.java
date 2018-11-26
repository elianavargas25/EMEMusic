package com.project.ememusic.automatizacion.pages.Model;

import com.project.ememusic.automatizacion.pages.Artista;
import com.project.ememusic.automatizacion.pages.Empresa;
import com.project.ememusic.automatizacion.pages.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Estefanía
 */
public class Pom {

    public static void main(String[] args) throws InterruptedException {
        String urlDriver = "lib\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", urlDriver);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:8084/EMEMusic/index.jsp");
        Login.clicIngresar(driver);
        Login.LlenarLogin(driver);
        Empresa.ClicEmpresa(driver);
        Empresa.LlenarCampos(driver);
        Empresa.ValidarRegistro(driver);
        Artista.ClicArtista(driver);
        Artista.LlenarArtista(driver);
        
    }
    
}
