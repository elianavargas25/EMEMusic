
package com.project.ememusic.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Estefanía
 */
public class Empresa {
    WebDriver driver;
    By Empresa = By.linkText("Registro de Empresas");
    By TipoDo = By.name("cbotipodocumento");
    By NroDo= By.name("txtnrodocumento");
    By Nombre= By.name("txtnombre");
    By Pago= By.name("txtpagooperacion");
    By Estado= By.name("optionStateS");
    By Button1= By.id("save");
    By Button2= By.id("edit");
    By Button3= By.id("search");
    By Button4= By.id("exit");
    
    public Empresa (WebDriver driver){
        this.driver = driver;
    }
    
    public void ClicEmpresa (){
        driver.findElement(Empresa).click();
    }
    
    public void SelectTipoDoEmp(String strTipoEmp){
         driver.findElement(TipoDo).sendKeys(strTipoEmp);
    }
    
    public void setNroDoEmp(String strNroEmp){
            driver.findElement(NroDo).sendKeys(strNroEmp);
    }
    
     public void setNombreEmp(String strNombreEmp){
            driver.findElement(Nombre).sendKeys(strNombreEmp);
    }
     
     
     public void setPagoOperacionEmp(String strPagoEmp){
            driver.findElement(Pago).sendKeys(strPagoEmp);
    }
    
         public void setEstadoEmp(String strEstadoEmp){
            driver.findElement(Estado).sendKeys(strEstadoEmp);
    }
    
     public void ClicBotonGuardar(){
            driver.findElement(Button1).click();
    }
       public void ClicBotonModificar(){
            driver.findElement(Button2).click();
    }
      
       public void ClicBotonBuscar(){
            driver.findElement(Button3).click();
    }
     
     public void ClicBotonCancelar(){
            driver.findElement(Button4).click();
    }
     
  
    public void EmpresaApplication(String TipoDo , String NroDo, String Nombre, String Pago, String Estado){

        this.ClicEmpresa();
        this.SelectTipoDoEmp(TipoDo);
        this.setNroDoEmp(NroDo);
        this.setNombreEmp(Nombre);
        this.setPagoOperacionEmp(Pago);
        this.setEstadoEmp(Estado);
        this.ClicBotonBuscar();
        this.ClicBotonGuardar();
        this.ClicBotonModificar();
        this.ClicBotonCancelar();
        
    }
}
