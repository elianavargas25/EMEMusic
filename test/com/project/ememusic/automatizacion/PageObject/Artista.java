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
    By selectipo = By.name("cbotipodocumento");
    By NroDocArt = By.name("txtnumdocumento");
    By PrimerNombre = By.name("txtprimernombre");
    By SegundoNombre = By.name("txtsegundonombre");
    By PrimerApellido = By.name("txtprimerapellido");
    By SegundoApellido = By.name("txtsegundopellido");
    By NombreArtistico = By.name("txtnombreartistico");
    By SelectEmpresa = By.name("cboempresa");
    By EstadoArt = By.name("optionStateS");
    By Guardar = By.id("save");

    public Artista(WebDriver driver) {
        this.driver = driver;
    }

    public void setSelectipo(String SelectArt) {
        driver.findElement(selectipo).sendKeys(SelectArt);
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

    public void setSelectEmpresa(String SEmpresa) {
        driver.findElement(SelectEmpresa).sendKeys(SEmpresa);
    }

    public void setEstadoArt(String EstArt) {
        driver.findElement(EstadoArt).sendKeys(EstArt);
    }

    public void ClicGuardarArt() {
        driver.findElement(Guardar).click();
    }

    public void ArtistaAplication(String selectipo, String NroDocArt, String PrimerNombre, String SegundoNombre, String PrimerApellido, String SegundoApellido, String NombreArtistico, String SelectEmpresa, String EstadoArt, String Guardar) {
    this.setSelectipo(selectipo);
    this.setNroDocArt(NroDocArt);
    this.setPrimerNombre(PrimerNombre);
    this.setSegundoNombre(SegundoNombre);
    this.setPrimerApellido(PrimerApellido);
    this.setSegundoApellido(SegundoApellido);
    this.setNombreArtistico(NombreArtistico);
    this.setSelectEmpresa(SelectEmpresa);
    this.setEstadoArt(EstadoArt);
    this.ClicGuardarArt();
    
    }
    
}
