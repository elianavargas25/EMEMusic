package com.project.ememusic.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Estefanía
 */
public class Empresa {

    public static void ClicEmpresa(WebDriver driver) {
        driver.findElement(By.linkText("Registro de Empresas")).click();

    }

    public static void LlenarCampos(WebDriver driver) {
        String Empresa =("Music SA");
        driver.findElement(By.name("cbotipodocumento")).sendKeys(Keys.DOWN);
        driver.findElement(By.name("cbotipodocumento")).sendKeys(Keys.DOWN);
        driver.findElement(By.name("cbotipodocumento")).sendKeys(Keys.RETURN);
        driver.findElement(By.name("cbotipodocumento")).click();
        driver.findElement(By.name("txtnrodocumento")).sendKeys("94584754");
        driver.findElement(By.name("txtnombre")).sendKeys(Empresa);
        driver.findElement(By.name("txtpagooperacion")).sendKeys("900");
        driver.findElement(By.name("optionStateS")).sendKeys(Keys.DOWN);
        driver.findElement(By.name("optionStateS")).sendKeys(Keys.RETURN);
        driver.findElement(By.name("optionStateS")).click();
        driver.findElement(By.name("action")).click();
    }

    public static void ValidarRegistro(WebDriver driver) {
        String Empresa =("Music SA");
        String Mensaje = "Registro guardado correctamente";
        String MensajeMostrado = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/center/h4")).getText();
           System.out.println("MensajeCapturado:" +MensajeMostrado);
            if (MensajeMostrado ==Mensaje){
                System.out.println("La empresa fue registrada :"+Empresa);
            }
    }
}
