package com.project.ememusic.automatizacion.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Estefanía
 */
public class Empresa {
    WebDriver driver;
    By selector = By.name("cbotipodocumento");
    By NroDoc= By.name("txtnrodocumento");
    By Nombre= By.name("txtnombre");
    By Pago= By.name("txtpagooperacion");
    By Estado = By.name("optionStateS");
    By guardar = By.id("save");
    
    public Empresa (WebDriver driver){
        this.driver = driver;
    }
    
    public void setSelector (String Selec){
    driver.findElement(selector).sendKeys(Selec);
    }
    
    public void setNroDo (String Documento){
    driver.findElement(NroDoc).sendKeys(Documento);
    }
   
    public void setNombre (String Nomb){
    driver.findElement(Nombre).sendKeys(Nomb);
    }
    
    public void setPago(String OperacionP){
    driver.findElement(Pago).sendKeys(OperacionP);
    }
   
    public void setEstado (String State){
    driver.findElement(Estado).sendKeys(State);
    }
    
    public void ClicGuardarEmp(){
    driver.findElement(guardar).click();
 }
    public void EmpresaAplication(String selector, String NroDoc, String Nombre, String Pago,String Estado, String guardar){
    this.setSelector(selector);
    this.setNroDo(NroDoc);
    this.setNombre(Nombre);
    this.setPago(Pago);
    this.setEstado(Estado);
    this.ClicGuardarEmp();
    }
}