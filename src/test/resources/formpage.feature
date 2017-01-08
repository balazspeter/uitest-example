Feature: Check elements and functionalities on form page
  In order to verify test requirements for test page
  As an automation tester
  I should cover every requirement with automated test

  Scenario: Form page title and logo testing
    When I open Docler test formpage
    Then title on formpage is correct
    And company logo on formpage is displayed
    
  Scenario: Verify clicking on Home/Form button redirects to homepage/formpage
    When I open Docler test formpage
    And I click on Home button on formpage
    Then I am on homepage
    And Home button is active
    When I click on Form button on formpage
    Then I am on formpage
    And Form button is active
    
  Scenario Outline: Testing submitting the form
    When I open Docler test formpage
    And I submit form with "<value>"
    Then result is "<result>"
    
  Examples:
    | value   | result         |
    | John    | Hello John!    |
    | Sophia  | Hello Sophia!  |
    | Charlie | Hello Charlie! |
    | Emily   | Hello Emily!   |