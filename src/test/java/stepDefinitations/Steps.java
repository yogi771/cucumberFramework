package stepDefinitations;





import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.Pagination;
import pageObjects.RicePagination;
import pageObjects.SearchCustomerPage;
import pageObjects.demowebshop;


public class Steps extends BaseClass {

	@Before
	public void setUp() {
		

		driver = new ChromeDriver();
		
	}
	

	@Given("user Launch Chrome browser")
	public void user_Launch_Chrome_browser() {
		
	
		lp = new LoginPage(driver);
    
	}

	@When("user opens URL {string}")
	public void user_opens_URL(String url) {
		
		
		driver.get(url);
		driver.manage().window().maximize();
	}

	@When("user enters Email as {string} and Password as {string}")
	public void user_enters_Email_as_and_Password_as(String UEmail, String UPassword) {
	
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
			
			Assert.assertEquals(title, driver.getTitle());
		}
	}

	@When("user click on Log out Link")
	public void user_click_on_Log_out_Link() {
		
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

	// steps for new website demoWebShop for execution
	
	@Given("user is on the home page of {string}")
	public void user_is_on_the_home_page(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}

	@When("user move cursor on computers dropdown")
	public void user_move_cursor_on_computers_dropdown() {
		demowebs = new demowebshop(driver);
		demowebs.hoverOnComputers();
	}

	@When("user moves cursor on nootbook and click")
	public void user_moves_cursor_on_nootbook_and_click() {
	   //demowebs.clickNoteBook();
	}

	@Then("user is on nootbook page")
	public void user_is_on_nootbook_page() {
		demowebs.getPageTitle(driver);
	}

	@Then("user can see the size of nootbook")
	public void user_can_see_the_size_of_nootbook() {
	  String productName = demowebs.getProductName();
	  System.out.println(productName);
	   
	}

	// code for the demoWebShopPagination 
	
	@When("user navigate to footer")
	public void user_navigate_to_footer() {
		pagination = new Pagination(driver);
		
	}

	@When("user moves cursor sitemap in information and click")
	public void user_moves_cursor_sitemap_in_information_and_click() {
		pagination.clickFooterOne();
	}

	@Then("user is on sitemap page")
	public void user_is_on_sitemap_page() {
	    pagination.checkTitle();
	}

	@Then("user can try pagination")
	public void user_can_try_pagination() {
	   pagination.moveBack();
	}

	// code for teseing pagination on rahul shetty website 

	
	@When("user search for {string}  in the table using pagination")
	public void user_search_for_in_the_table_using_pagination(String string) {
		RicePagi = new RicePagination(driver); 
	System.out.println(RicePagi.checkTable());
	}

	@Then("user verify the price is {int}")
	public void user_verify_the_price_is(Integer int1) {
	    
	}
	
	// code for the external url from the parent application using handle id
	
	
	@When("user click on Instagram in Title of connect with us in footer")
	public void user_click_on_instagram_in_title_of_connect_with_us_in_footer() {
	   
	}

	@Then("user can see Instagram url gets launched in same tab")
	public void user_can_see_instagram_url_gets_launched_in_same_tab() {
	   
	}

	@Then("user navigate back to the parent page")
	public void user_navigate_back_to_the_parent_page() {
	    
	}
	
	
}
