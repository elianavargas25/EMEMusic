package com.project.ememusic.automatizacion.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Estefanía
 */
public class Empresa {

    WebDriver driver;
    By selectipo = By.id("cboDocument");
    By NroDocEmp = By.name("txtnrodocumento");
    By NombreEmp = By.name("txtnombre");
    By PagoOpeacion = By.name("txtpagooperacion");
    By Estado = By.xpath("//*[@id=\"Empresa\"]/div[2]/label[1]/input");
    By Guardar = By.id("save");
    By MensajeValidacion = By.xpath("/html/body/div/div[2]/div[2]/div[2]/center/h3");

    public Empresa(WebDriver driver) {
        this.driver = driver;
    }

    public String GetMensaje() {
        return driver.findElement(MensajeValidacion).getText();
    }

    public void SetTipodo() {
        driver.findElement(selectipo).sendKeys(Keys.DOWN);
        driver.findElement(selectipo).sendKeys(Keys.DOWN);
        driver.findElement(selectipo).sendKeys(Keys.RETURN);
        driver.findElement(selectipo).click();
    }

    public void SetNroDo(String Nro) {
        driver.findElement(NroDocEmp).sendKeys(Nro);
    }

    public void SetPago(String Pago) {
        driver.findElement(PagoOpeacion).sendKeys(Pago);
    }

    public void SetNombre(String NombreEmpr) {
        driver.findElement(NombreEmp).sendKeys(NombreEmpr);
    }

    public void SetEstado() {
        driver.findElement(Estado).click();
    }

    public void ClicGuardar() {
        driver.findElement(Guardar).click();
    }

    public void EmpresaAplication(String NroDocEmp, String NombreEmp, String PagoOperacion) {
        SetTipodo();
        SetNroDo(NroDocEmp);
        SetPago(PagoOperacion);
        SetNombre(NombreEmp);
        SetEstado();
        ClicGuardar();

    }

    public void EmpresaAplication1(String NombreEmp, String PagoOperacion) {
        SetTipodo();
        SetPago(PagoOperacion);
        SetNombre(NombreEmp);
        SetEstado();
        ClicGuardar();

    }

    public void EmpresaAplication2(String NroDocEmp, String PagoOperacion) {
        SetTipodo();
        SetPago(PagoOperacion);
        SetNroDo(NroDocEmp);
        SetEstado();
        ClicGuardar();

    }

    public void EmpresaAplication3(String NroDocEmp, String NombreEmp) {
        SetTipodo();
        SetNombre(NombreEmp);
        SetNroDo(NroDocEmp);
        SetEstado();
        ClicGuardar();

    }
}
