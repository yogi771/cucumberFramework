package stepDefinitations;



import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Steps extends BaseClass {

	

	@Given("user Launch Chrome browser")
	public void user_Launch_Chrome_browser() {
		
		logger =  Logger.getLogger("letMeShop"); //Added logger
		PropertyConfigurator.configure("Log4j.properties"); //Added logger
		driver = new ChromeDriver();
		logger.info("******** Launching URL********");
		lp = new LoginPage(driver);
    
	}

	@When("user opens URL {string}")
	public void user_opens_URL(String url) {
		
		logger.info("******** opening URL********");
		driver.get(url);
		driver.manage().window().maximize();
	}

	@When("user enters Email as {string} and Password as {string}")
	public void user_enters_Email_as_and_Password_as(String UEmail, String UPassword) {
		logger.info("******** credentials entered ********");
		lp.setEmail(UEmail);
		lp.setPassword(UPassword);
	}

	@When("click on Login")
	public void click_on_Login() {
		lp.clickLogin();
	}

	@Then("page Title should be {string}")
	public void page_Title_should_be(String title) {
		if (driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			logger.info("******** login fail ********");
			Assert.assertEquals(title, driver.getTitle());
		}
	}

	@When("user click on Log out Link")
	public void user_click_on_Log_out_Link() {
		logger.info("******** closing browser********");
		lp.clickLogout();
	}
	
	
	@Then("close browser")
	public void close_browser() {
		driver.quit();
	}

	//Customer features step definations
	
	@Then("User can view Dashboad")
	public void user_can_view_dashboad() {
		addCust = new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
	    
	}
	@When("User click on customers Menu")
	public void user_click_on_customers_menu() {
		addCust.clickOnCustomerMenu();
	   
	}
	@When("click on cusomers Menu Item")
	public void click_on_cusomers_menu_item() {
	    addCust.clickOnCustomerMenuItem();
	}
	@When("click on Add new button")
	public void click_on_add_new_button() throws InterruptedException  {
		addCust.clickOnAddNew();
		Thread.sleep(2000);
	    
	}
	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
	   
	}
	
	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
	
	String email= randomestString()+"@gmail.com";
	addCust.setEmail(email);
	addCust.setPassword("test123");
	addCust.setFirstName("Yogiraj");
	addCust.setLastName("Talwar");
	addCust.setGender("Male");
	addCust.setDob("05/08/2024");
	addCust.setCompanyName("BusyQA");
	addCust.setCutromerRole();
	addCust.setAdminContent("This is fot testing....");
	
	}
	@When("click on Save button")
	public void click_on_save_button() throws InterruptedException {
	   addCust.clickOnSave();
	   Thread.sleep(2000);
	}
	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
	    Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
	}
	
	//steps for searching a customer using email id
	
	@When("enter cusomer email")
	public void enter_cusomer_email() throws InterruptedException {
	//	driver.findElement(By.xpath("//div[@class='row search-row']")).click();
		Thread.sleep(3000);
	  searchCust = new SearchCustomerPage(driver);
	   searchCust.setEmail("james_pan@nopCommerce.com");
	   
	}
	@When("click on search button")
	public void click_on_search_button() throws InterruptedException {
	   searchCust.clickSearch();
	   Thread.sleep(3000);
	}
	@Then("user should found email in the search table")
	public void user_should_found_email_in_the_search_table() {
	boolean status =	searchCust.searchCustomerByEmail("james_pan@nopCommerce.com");
		
	Assert.assertEquals(status, true);
	}

	//steps for searchin a customer using Name
	
	@When("enter customer First name")
	public void enter_customer_first_name() {
		searchCust = new SearchCustomerPage(driver);
		searchCust.setFirstName("james");
		
		
	}
	@When("enter customer Last name")
	public void enter_customer_last_name() {
	   searchCust.setLastName("pan");
	}
	@Then("user should found name in the search table")
	public void user_should_found_first_name_in_the_search_table() {
	 boolean status = searchCust.searchCustomerByName("James Pan");
	  Assert.assertEquals(status, true);
	  
	}




}
