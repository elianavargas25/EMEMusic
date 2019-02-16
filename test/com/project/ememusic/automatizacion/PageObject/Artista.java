package com.project.ememusic.automatizacion.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Estefanía
 */
public class Artista {

        WebDriver driver;
    By Link = By.xpath("/html/body/div/header/div[2]/nav/ul/li[1]/a");
    By selectipo = By.name("cbotipodocumento");
    By NroDocArt = By.id("nroDocument");
    By PrimerNombre = By.id("firstName");
    By SegundoNombre = By.id("secondName");
    By PrimerApellido = By.id("firstLastname");
    By SegundoApellido = By.id("secondLastname");
    By NombreArtistico = By.id("stageName");
    By SelectEmpresa = By.name("cboempresa");
    By EstadoArt = By.name("optionStateS");
    By Guardar = By.id("save");
    By mensaje = By.xpath("/html/body/div/div[2]/div[2]/div[2]/center/h3");

    public Artista(WebDriver driver) {
        this.driver = driver;
    }

    public String GetMensaje() {
        return driver.findElement(mensaje).getText();
    }

    public void setSelectipo() {
        driver.findElement(selectipo).sendKeys(Keys.DOWN);
        driver.findElement(selectipo).sendKeys(Keys.RETURN);
        driver.findElement(selectipo).click();
    }

    public void Link() {
        driver.findElement(Link).click();
    }

    public void setNroDocArt(String NroArt) {
        driver.findElement(NroDocArt).sendKeys(NroArt);
    }

    public void setPrimerNombre(String PNombre) {
        driver.findElement(PrimerNombre).sendKeys(PNombre);
    }

    public void setSegundoNombre(String SNombre) {
        driver.findElement(SegundoNombre).sendKeys(SNombre);
    }

    public void setPrimerApellido(String PApellido) {
        driver.findElement(PrimerApellido).sendKeys(PApellido);
    }

    public void setSegundoApellido(String SApellido) {
        driver.findElement(SegundoApellido).sendKeys(SApellido);
    }

    public void setNombreArtistico(String NArtistico) {
        driver.findElement(NombreArtistico).sendKeys(NArtistico);
    }

    public void setSelectEmpresa() {
        driver.findElement(SelectEmpresa).sendKeys(Keys.DOWN);
        driver.findElement(SelectEmpresa).sendKeys(Keys.RETURN);
        driver.findElement(SelectEmpresa).click();
    }

    public void setEstadoArt() {
        driver.findElement(EstadoArt).click();
    }

    public void ClicGuardarArt() {
        driver.findElement(Guardar).click();
    }

    public void ArtistaAplication(String NroDocArt, String PrimerNombre, String SegundoNombre, String PrimerApellido, String SegundoApellido, String NombreArtistico) {

        this.setNroDocArt(NroDocArt);
        this.setPrimerNombre(PrimerNombre);
        this.setSegundoNombre(SegundoNombre);
        this.setPrimerApellido(PrimerApellido);
        this.setSegundoApellido(SegundoApellido);
        this.setNombreArtistico(NombreArtistico);
        this.setEstadoArt();
        this.ClicGuardarArt();

    }

}
