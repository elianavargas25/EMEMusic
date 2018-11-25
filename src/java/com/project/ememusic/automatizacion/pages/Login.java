package com.project.ememusic.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Estefanía
 */
public class Login {

    WebDriver driver;
    By Login = By.linkText("Ingresar");
    By usuario = By.name("Usuario");
    By password = By.name("Clave");
    By Boton = By.id("login");

    public  Login(WebDriver driver) {
        this.driver = driver;
    }

    public  void ClicIngreso() {
        driver.findElement(Login).click();
    }

    public void setUser(String strUser) {
        driver.findElement(usuario).sendKeys(strUser);
    }

    public void setPass(String strPass) {
        driver.findElement(password).sendKeys(strPass);
    }

    public void ClicBoton() {
        driver.findElement(Boton).click();
    }

    public  void loginApplication(String usuario, String password) {

        this.setUser(usuario);
        this.setPass(password);
        this.ClicBoton();
    }
}
