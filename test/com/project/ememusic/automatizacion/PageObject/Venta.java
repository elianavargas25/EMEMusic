
package com.project.ememusic.automatizacion.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Estefanía
 */
public class Venta {
    WebDriver driver;
    By NombreEmpresa = By.id("company");
    By NombreArtista = By.id("artista");
    By CantidadRepro= By.id("stageName");
    By Guardar =By.id("save");
    By Cantidad= By.id("stageName");
    
    public Venta(WebDriver driver) {
        this.driver = driver;
    }
    
        public String getCantidad() {
        return driver.findElement(Cantidad).getText();
    }
    
    public void SetEmpresa ( String StrEmp) {
    driver.findElement(NombreEmpresa).sendKeys(StrEmp);
    }
    
    public void SetArtista(String StrArt){
    driver.findElement(NombreArtista).sendKeys(StrArt);
    }
    
    public void SetCantidad(String StrCantidad){
    driver.findElement(CantidadRepro).sendKeys(StrCantidad);
    }
    
    public void ClicBoton(){
    driver.findElement(Guardar).click();
    }
    
    public void VentasAplication(String StrEmp, String StrArt,String StrCantidad){
        SetArtista(StrArt);
        SetCantidad(StrCantidad);
        SetEmpresa(StrEmp);
        ClicBoton();
        getCantidad();
    }
}
