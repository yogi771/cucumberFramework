Feature: TC 02 demoWebShop 

Background: below are the steps for each scenario
 	Given user Launch Chrome browser
  
  Scenario: test pagination
    Given user is on the home page of "https://demowebshop.tricentis.com/"
    When user navigate to footer 
    And user moves cursor sitemap in information and click
    Then user is on sitemap page
    And user can try pagination