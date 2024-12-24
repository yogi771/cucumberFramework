Feature: TC 01 switch window 

Background: below are the steps for each scenario1
 	Given user Launch Chrome browser
  
  Scenario: test switch window
    Given user is on the home page of "https://www.flipkart.com/" 
    When user click on Myntra, ClearTrip and Shopsy in Title of connect with us in footer
    Then user can see Myntra url gets launched in same tab
    Then user navigate back to the parent page
    
	 