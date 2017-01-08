package com.duodecadits.uitest;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.duodecadits.uitest.pages.BasePage;
import com.duodecadits.uitest.pages.FormPage;

public class FormPageSteps {
  WebDriver driver;
  FormPage formpage;
  
  @When("^I open Docler test formpage$")
  public void I_open_Docler_test_formpage() throws Throwable {
    formpage = new FormPage(driver);
    formpage.navigateTo();
  }

  @Then("^title on formpage is correct$")
  public void title_on_formpage_is_correct() throws Throwable {
    formpage.verifyTitle();
  }
  
  @Then("^company logo on formpage is displayed$")
  public void company_logo_on_formpage_is_displayed() throws Throwable {
    formpage.verifyLogo();
  }
  
  @When("^I click on Form button on formpage$")
  public void I_click_on_Form_button_on_formpage() throws Throwable {
    formpage.clickFormButton();
  }
  
  @When("^I click on Home button on formpage$")
  public void I_click_on_Home_button_on_formpage() throws Throwable {
    formpage.clickHomeButton();
  }
  
  @Then("^I am on homepage$")
  public void I_am_on_homepage() throws Throwable {
    formpage.verifyHomePage();
  }
  
  @Then("^I am on formpage$")
  public void I_am_on_formpage() throws Throwable {
    formpage.verifyFormIsDisplayed();
  }
  
  @And("^I submit form with \"([^\"]*)\"$")
  public void I_submit_form_with(String value) throws Throwable {
    formpage.submitForm(value);
  }
  
  @Then("^result is \"([^\"]*)\"$")
  public void result_is(String result) throws Throwable {
    formpage.verifyFormResult(result);
  }
  
  @Then("^Home button is active$")
  public void Home_button_is_active() throws Throwable {
    formpage.verifyHomeIsActive();
  }
  
  @Then("^Form button is active$")
  public void Form_button_is_active() throws Throwable {
    formpage.verifyFormIsActive();
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