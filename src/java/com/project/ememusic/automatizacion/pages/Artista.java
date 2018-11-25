
package com.project.ememusic.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Estefanía
 */
public class Artista {
      WebDriver driver;
    By Artista = By.linkText("Registro de Artistas");
    By TipoDoArt = By.id("cboDocument");
    By NroDoArt= By.id("nroDocument");
    By PrimerNom= By.id("firstName");
    By SegundoNom= By.id ("secondName");
    By PrimerAp= By.id("firstLastname");
    By SegundoAp= By.id("secondLastname");
    By NombreArt= By.id("stageName");
    By Empresa= By.id("company ");
    By Estado= By.xpath("//*[@id=\"Artista\"]/div[1]/label[1]");
    By Button1= By.id("save");
    By Button2= By.id("search");
    By Button3= By.id("exit");
    
    public Artista (WebDriver driver){
        this.driver = driver;
    }
    
    public void ClicArtista (){
        driver.findElement(Artista).click();
    }
    
    public void SelectTipoArt(String strTipoArt){
         driver.findElement(TipoDoArt).sendKeys(strTipoArt);
    }
    
    public void setNroDoAr(String strNroArt){
            driver.findElement(NroDoArt).sendKeys(strNroArt);
    }
    
     public void setPrimerNomb(String strPNom1){
            driver.findElement(PrimerNom).sendKeys(strPNom1);
    }
     
     
     public void setSegundoNomb (String strNombre2){
            driver.findElement(SegundoNom).sendKeys(strNombre2);
    }
    
         public void setPrimerAp (String strApellido1 ){
            driver.findElement(PrimerAp).sendKeys(strApellido1);
    }
         
    
         public void setSegundoAp (String strApellido2 ){
            driver.findElement(SegundoAp).sendKeys(strApellido2);
    }
         
            public void setNombreArtistico (String strArtistico ){
            driver.findElement(NombreArt).sendKeys(strArtistico);
    }     
    
            public void setEmpresa (String strSelEmpresa ){
            driver.findElement(Empresa).sendKeys(strSelEmpresa);
    }             
            
            public void setEstado (String strEstado ){
            driver.findElement(Estado).sendKeys(strEstado);
    }  
     public void ClicBotonGuardar(){
            driver.findElement(Button1).click();
    }
    
      
       public void ClicBotonBuscar(){
            driver.findElement(Button2).click();
    }
     
     public void ClicBotonCancelar(){
            driver.findElement(Button3).click();
    }
     
  
    public void AttistaApplication(String TipoDoArt , String NroDoArt, String PrimerNom, String SegundoNom, String PrimerAp, String SegundoAp, String NombreArt,String Empresa,String Estado){

        this.ClicArtista();
       this.SelectTipoArt(TipoDoArt);
       this.setNroDoAr(NroDoArt);
      this.setPrimerNomb(PrimerNom);
      this.setSegundoNomb(SegundoNom);
      this.setPrimerAp(PrimerAp);
      this.setSegundoAp(SegundoAp);
      this.setNombreArtistico(NombreArt);
      this.setEstado(Estado);
      this.ClicBotonGuardar();
      this.ClicBotonBuscar();
      this.ClicBotonCancelar();
    }
}

