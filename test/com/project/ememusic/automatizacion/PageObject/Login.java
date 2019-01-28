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
By Button= By.name("Login");

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
  public void LoginAplication(String User ,String Password){
  this.setUserName(User);
  this.setPass(Password);
  this.ClicLogin();
  }
}