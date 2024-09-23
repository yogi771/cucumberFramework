Feature: TC 01 greenkart 

Background: below are the steps for each scenario1
 	Given user Launch Chrome browser
  
  Scenario: test pagination
    Given user is on the home page of "https://rahulshettyacademy.com/seleniumPractise/#/offers" 
    When user search for "Rice" in the table using pagination
    Then user verify the price is 37
 