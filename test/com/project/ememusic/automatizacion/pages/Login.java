package com.project.ememusic.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Estefanía
 */
public class Login {

    public static void clicIngresar(WebDriver driver) {
        driver.findElement(By.linkText("Ingresar")).click();
    }

    public static void LlenarLogin(WebDriver driver) {
        driver.findElement(By.name("Usuario")).sendKeys("admin");
        driver.findElement(By.name("Clave")).sendKeys("admin");
        driver.findElement(By.name("action")).click();
    }
}
