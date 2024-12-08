Feature: Customers

 	Background: below are the steps for each scenario
 	Given user Launch Chrome browser
	When user opens URL "https://admin-demo.nopcommerce.com/login"
	And user enters Email as "admin@yourstore.com" and Password as "admin"
	And click on Login
	Then User can view Dashboad
	
@sanity
Scenario: Add new Customer
	
	When User click on customers Menu
	And click on cusomers Menu Item	
	And click on Add new button
	Then User can view Add new customer page
	When User enter customer info
	And click on Save button
	Then User can view confirmation message "The new customer has been added successfully."
	And close browser
	
	
@regression
Scenario: Search Customer by EmailID
	
	When User click on customers Menu
	And click on cusomers Menu Item
	And enter cusomer email
	When click on search button
	Then user should found email in the search table
	And close browser
	

@regression
Scenario: Search Customer by Name
	
	When User click on customers Menu
	And click on cusomers Menu Item
	And enter customer First name
	And enter customer Last name
	When click on search button
	Then user should found name in the search table
	And close browser	
	
	
		
		