
Feature: TC 01 demoWebShop 

Background: below are the steps for each scenario
 	Given user Launch Chrome browser
  
  Scenario: navigate to NootBooks
    Given user is on the home page of "https://demowebshop.tricentis.com/"
    When user move cursor on computers dropdown
    And user moves cursor on nootbook and click 
    Then user is on nootbook page
    And user can see the size of nootbook

 
