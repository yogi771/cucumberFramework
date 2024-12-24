package stepDefinitations;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;


import pageObjects.AddCustomerPage;
import pageObjects.ExternalLinks;
import pageObjects.LoginPage;
import pageObjects.Pagination;
import pageObjects.RicePagination;
import pageObjects.SearchCustomerPage;
import pageObjects.demowebshop;
import utilities.ActionClass;

public class BaseClass {
	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage addCust;
	public SearchCustomerPage searchCust;
	public demowebshop demowebs;
	public Pagination pagination;
	public RicePagination RicePagi;
	public ExternalLinks externalLinks;
	
	public Properties configPorp;
	
	//created ffor generating unique email id
	public static String randomestString() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		
		return (generatedString1);
	}
	
	
}
