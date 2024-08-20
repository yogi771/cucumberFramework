Feature: Login

Scenario: Successful Login with Valid Credentials
	Given user Launch Chrome browser
	When user opens URL "https://admin-demo.nopcommerce.com/login"
	And user enters Email as "admin@yourstore.com" and Password as "admin"
	And click on Login
	Then page Title should be "Dashboard / nopCommerce administration"
	When user click on Log out Link
	Then page Title should be "Your store. Login"
	And close browser
	

Scenario Outline: Login Data Driven	
	Given user Launch Chrome browser
	When user opens URL "https://admin-demo.nopcommerce.com/login"
	And user enters Email as "<email>" and Password as "<password>"
	And click on Login
	Then page Title should be "Dashboard / nopCommerce administration"
	When user click on Log out Link
	Then page Title should be "Your store. Login"
	And close browser
	
	Examples:
			| email | password |
			| admin@yourstore.com | admin |
			| adnub@yourstore.com | admin123 |