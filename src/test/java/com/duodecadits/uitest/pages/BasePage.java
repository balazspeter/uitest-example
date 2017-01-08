package com.duodecadits.uitest.pages;

import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
  protected WebDriver driver;
  private final By companylogoSelector = By.id("dh_logo");
  private final By uitestingbuttonSelector = By.id("site");
  private final By homebuttonSelector = By.id("home");
  private final By formbuttonSelector = By.id("form");
  private final By errorbuttonSelector = By.id("error");
  WebDriverWait wait;
  
  public BasePage(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, 3);
  }
  
  public BasePage navigateTo() {
    return new BasePage(driver);
  }
  
  public BasePage verifyTitle() {
    assertEquals("UI Testing Site", driver.getTitle());
    return new BasePage(driver);
  }
  
  public BasePage verifyLogo() {
    WebElement companylogo = driver.findElement(companylogoSelector);
    assertTrue(companylogo.isDisplayed());
    return new BasePage(driver);
  }
  
  public BasePage clickFormButton() {
    WebElement formbutton = driver.findElement(formbuttonSelector);
    formbutton.click();
    return new BasePage(driver);
  }
  
  public BasePage clickHomeButton() {
    WebElement homebutton = driver.findElement(homebuttonSelector);
    homebutton.click();
    return new BasePage(driver);
  }
  
  public BasePage clickErrorButton() {
    WebElement errorbutton = driver.findElement(errorbuttonSelector);
    errorbutton.click();
    return new BasePage(driver);
  }
  
  public BasePage verifyHomeIsActive() {
    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//li[@class='active']/a[@id='home']"), "Home"));
    return new BasePage(driver);
  }
  
  public BasePage verifyFormIsActive() {
    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//li[@class='active']/a[@id='form']"), "Form"));
    return new BasePage(driver);
  }
}