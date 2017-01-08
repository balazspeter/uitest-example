package com.duodecadits.uitest.pages;

import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormPage extends BasePage {
  private final By inputSelector = By.id("hello-input");
  private final By submitSelector = By.id("hello-submit");
  WebDriverWait wait = new WebDriverWait(driver, 3);
  
  public FormPage(WebDriver driver) {
    super(driver);
  }
  
  public FormPage navigateTo() {
    super.navigateTo();
    driver.navigate().to("http://uitest.duodecadits.com/form.html");
    return new FormPage(driver);
  }
  
  public FormPage verifyFormIsDisplayed() {    
    wait.until(ExpectedConditions.visibilityOfElementLocated(inputSelector));
    wait.until(ExpectedConditions.visibilityOfElementLocated(submitSelector));    
    return new FormPage(driver);
  }
  
  public FormPage verifyHomePage() {
    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='ui-test']//h1"), "Welcome to the Docler Holding QA Department"));
    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='ui-test']//p"), "This site is dedicated to perform some exercises and demonstrate automated web testing."));
    return new FormPage(driver);
  }
  
  public FormPage submitForm(String value) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(inputSelector));
    driver.findElement(inputSelector).sendKeys(value);
    driver.findElement(submitSelector).submit();
    return new FormPage(driver);
  }
  
  public FormPage verifyFormResult(String result) {
    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h1[@id='hello-text']"), result));
    return new FormPage(driver);
  }
  
  public FormPage verifyHomeIsActive() {
    super.verifyHomeIsActive();
    return new FormPage(driver);
  }
  
  public FormPage verifyFormIsActive() {
    super.verifyFormIsActive();
    return new FormPage(driver);
  }
}