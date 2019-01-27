package com.project.ememusic.automatizacion.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Estefanía
 */
public class Login {
WebDriver driver;
By User= By.name("Usuario");
By Password= By.name("Clave");
By Button= By.name("action");

 public Login(WebDriver driver){
        this.driver = driver;
    }
 public void setUserName(String usuario){
 driver.findElement(User).sendKeys(usuario);
 }
 public void setPass(String contraseña){
 driver.findElement(Password).sendKeys(contraseña);
 }
 
  public void ClicLogin (){
 driver.findElement(Button).click();
 }
  public void LoginAplication(String usuario,String contraseña){
  this.setUserName(usuario);
  this.setPass(contraseña);
  this.ClicLogin(); 
  }
}