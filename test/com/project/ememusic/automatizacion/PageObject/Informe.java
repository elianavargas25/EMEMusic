package com.project.ememusic.automatizacion.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Estefanía
 */
public class Informe {

    WebDriver driver;
    By selectInforme = By.id("Filtro");
    By FechaDesde = By.id("dateFrom");
    By FechaHasta = By.id("dateTo");
    By Buscar = By.id("search");

    public Informe(WebDriver driver) {
        this.driver = driver;
    }

    public void SelecFiltro() {
        driver.findElement(selectInforme).sendKeys(Keys.DOWN);
        driver.findElement(selectInforme).sendKeys(Keys.DOWN);
        driver.findElement(selectInforme).sendKeys(Keys.RETURN);
        driver.findElement(selectInforme).click();
    }

    public void SetFechaD(String Fecha) {
        driver.findElement(FechaDesde).sendKeys(Fecha);
    }

    public void SetFechaH(String Fecha2) {
        driver.findElement(FechaDesde).sendKeys(Fecha2);
    }

    public void ClicBuscar() {
        driver.findElement(Buscar).click();
    }
    
    
    public void InformeAplication(String Fecha, String Fecha2){
        SetFechaD(Fecha);
        SetFechaH(Fecha2);
        SelecFiltro();
        ClicBuscar();
    
    
    }

}
