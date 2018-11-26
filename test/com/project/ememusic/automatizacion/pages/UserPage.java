
package com.project.ememusic.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Usuario
 */
public class UserPage {
    WebDriver driver;
    By UserName = By.xpath("/html/body/div/header/nav/ul/h4");

    public UserPage(WebDriver driver) {
        this.driver = driver;
    }

    public String UserName() {
        return driver.findElement(UserName).getText();
    }
}
