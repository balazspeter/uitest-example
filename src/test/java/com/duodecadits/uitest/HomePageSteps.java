package com.duodecadits.uitest;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.given;

import com.duodecadits.uitest.pages.BasePage;
import com.duodecadits.uitest.pages.HomePage;

public class HomePageSteps {
  WebDriver driver;
  HomePage homepage;
  Response response;
  
  @When("^I open Docler test homepage$")
  public void I_open_Docler_test_homepage() throws Throwable {
    homepage = new HomePage(driver);
    homepage.navigateTo();
  }

  @Then("^title on homepage is correct$")
  public void title_on_homepage_is_correct() throws Throwable {
    homepage.verifyTitle();
  }
  
  @Then("^company logo on homepage is displayed$")
  public void company_logo_on_homepage_is_displayed() throws Throwable {
    homepage.verifyLogo();
  }
  
  @When("^I open Docler test errorpage$")
  public void I_open_Docler_test_errorpage() throws Throwable {
    driver.navigate().to("http://uitest.duodecadits.com/error");
    response = given().get("http://uitest.duodecadits.com/error").then().extract().response();
  }
  
  @Then("^response code is 404$")
  public void response_code_is_404() throws Throwable {
    assertEquals(response.getStatusCode(), 404);
  }
  
  @Before
  public void startup() {
    System.setProperty("webdriver.gecko.driver","c:\\geckodriver.exe");
    driver = new FirefoxDriver();
  }
  
  @After
  public void tearDown() {
    driver.quit();
  }
}