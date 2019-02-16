package com.project.ememusic.automatizacion.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Estefanía
 */
public class Login {

    WebDriver driver;
    By User = By.id("Username");
    By Password = By.id("Password");
    By Button = By.id("login");
    By UserAdmin = By.xpath("/html/body/div/header/div[4]/div/h4");
    By UserOperario = By.xpath("/html/body/div/header/div[4]/div/h4");
    By Mensaje = By.xpath("/html/body/form/h1[1]");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public String UserOperario() {
        return driver.findElement(UserOperario).getText();
    }

    public String USerAdmin() {
        return driver.findElement(UserAdmin).getText();
    }

    public String Mensaje() {
        return driver.findElement(Mensaje).getText();
    }

    public void setUserName(String usuario) {
        driver.findElement(User).sendKeys(usuario);
    }

    public void setPass(String contraseña) {
        driver.findElement(Password).sendKeys(contraseña);
    }

    public void ClicLogin() {
        driver.findElement(Button).click();
    }

    public void LoginAplication(String User, String Password) {
        this.setUserName(User);
        this.setPass(Password);
        this.ClicLogin();
        this.UserOperario();
        this.USerAdmin();

    }
}
