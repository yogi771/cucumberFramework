package stepDefinitations;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;


import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class BaseClass {
	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage addCust;
	public SearchCustomerPage searchCust;
	
	
	public Properties configPorp;
	
	//created ffor generating unique email id
	public static String randomestString() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		
		return (generatedString1);
	}
	
	
}
