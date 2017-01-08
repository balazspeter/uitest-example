Feature: Check elements and functionalities on home page
  In order to verify test requirements for test page
  As an automation tester
  I should cover every requirement with automated test

  Scenario: Home page title and logo testing
    When I open Docler test homepage
    Then title on homepage is correct
    And company logo on homepage is displayed
    
  Scenario: Verify response code on errorpage
    When I open Docler test errorpage
    Then response code is 404