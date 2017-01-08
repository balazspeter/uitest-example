package com.duodecadits.uitest.pages;

import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
  private final By hometextSelector = By.className("ui-test");
  
  public HomePage(WebDriver driver) {
    super(driver);
  }
  
  public HomePage navigateTo() {
    super.navigateTo();
    driver.navigate().to("http://uitest.duodecadits.com");
    return new HomePage(driver);
  }
}