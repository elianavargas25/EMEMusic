package com.project.ememusic.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Estefanía
 */
public class Artista {

    public static void ClicArtista(WebDriver driver) {
        driver.findElement(By.linkText("Registro de Artistas")).click();

    }

    public static void LlenarArtista(WebDriver driver) {
        String Artista = ("Maia");
        driver.findElement(By.name("cbotipodocumento")).sendKeys(Keys.DOWN);
        driver.findElement(By.name("cbotipodocumento")).sendKeys(Keys.RETURN);
        driver.findElement(By.name("cbotipodocumento")).click();
        driver.findElement(By.name("txtnumdocumento")).sendKeys("972367");
        driver.findElement(By.name("txtprimernombre")).sendKeys("Monica");
        driver.findElement(By.name("txtsegundonombre")).sendKeys("María");
        driver.findElement(By.name("txtprimerapellido")).sendKeys("Velasquez");
        driver.findElement(By.name("txtsegundopellido")).sendKeys("Velasquez");
        driver.findElement(By.name("txtnombreartistico")).sendKeys("Maia");
        driver.findElement(By.name("cboempresa")).sendKeys(Keys.DOWN);
        driver.findElement(By.name("cboempresa")).sendKeys(Keys.RETURN);
        driver.findElement(By.name("cboempresa")).click();
        driver.findElement(By.name("optionStateS")).sendKeys(Keys.DOWN);
        driver.findElement(By.name("optionStateS")).sendKeys(Keys.RETURN);
        driver.findElement(By.name("optionStateS")).click();
        driver.findElement(By.name("action")).click();
        
    }
}
