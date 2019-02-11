package com.project.ememusic.automatizacion.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Estefania
 */
public class Usuario {

    WebDriver driver;
    By Nombre = By.name("txtnombre");
    By clave = By.name("txtclave");
    By Select = By.xpath("//*[@id=\"cboDocument\"]");
    By Estado = By.xpath("//*[@id=\"Usuarios\"]/div/center/label[1]/input");
    By Guardar = By.id("save");

    public Usuario(WebDriver driver) {
        this.driver = driver;
    }

    public void SetNombre(String Nom) {
        driver.findElement(Nombre).sendKeys(Nom);
    }

    public void SetClave(String Cla) {
        driver.findElement(clave).sendKeys(Cla);
    }

    public void Select() {
        driver.findElement(Select).click();
    }

    public void Clicguardar() {
        driver.findElement(Guardar).click();
    }

    public void UsuarioAs(String Nom, String Cla) {
        SetNombre(Nom);
        SetClave(Cla);
        Select();
        Clicguardar();
    }
}
