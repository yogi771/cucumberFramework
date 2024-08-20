package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WaitHelper;

public class AddCustomerPage {

	public WebDriver ldriver;
	WaitHelper waithelper;

	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		waithelper = new WaitHelper(ldriver);
	}
	
	By lnkCustomers_menu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By lnkCustomers_menuItem = By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
	By btnAddnew=By.xpath("//a[@href='/Admin/Customer/Create']");
	
	By txtEmail = By.xpath("//input[@id='Email']");
	By txtPassword = By.xpath("//input[@id='Password']");
	By txtFirstName = By.xpath("//input[@id='FirstName']");
	By txtLastName = By.xpath("//input[@id='LastName']");
	By rdMaleGender = By.xpath("//input[@id='Gender_Male']");
	By rdFemaleGender = By.xpath("//input[@id='Gender_Female']");
	
	By txtDob =By.xpath("//input[@id='DateOfBirth']");
	By txtCompanyName =By.xpath("//input[@id='Company']");
	By selectRole =By.xpath("//select[@id='SelectedCustomerRoleIds']");
	By lstitemAdmin = By.xpath("//li[contains(text(),'Guests')]");
	By txtAdminContent=By.xpath("//textarea[@id='AdminComment']");
	By btnSave = By.xpath("//button[@name=\"save\"]");
	
	

	public String getPageTitle()
	{
		return ldriver.getTitle();
	}
	
	public void clickOnCustomerMenu() {
		ldriver.findElement(lnkCustomers_menu).click();
	}
	
	public void clickOnCustomerMenuItem() {
		ldriver.findElement(lnkCustomers_menuItem).click();
	}
	
	public void clickOnAddNew() {
		ldriver.findElement(btnAddnew).click();
	}
	
	public void setEmail(String email) {
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	public void setFirstName(String firstName) {
		ldriver.findElement(txtFirstName).sendKeys(firstName);
	}
	public void setPassword(String password) {
		ldriver.findElement(txtPassword).sendKeys(password);
	}
	public void setLastName(String lastName) {
		ldriver.findElement(txtLastName).sendKeys(lastName);
	}
	public void setGender(String gender) {
		if(gender.equals("Male")) {
			ldriver.findElement(rdMaleGender).click();
		}
		else if(gender.equals("Female"))
		{
			ldriver.findElement(rdFemaleGender).click();
		}
		else {
			ldriver.findElement(rdMaleGender).click();
		}
	}
	
	public void setDob(String dob) {
		ldriver.findElement(txtDob).sendKeys(dob);
	}
	public void setCompanyName(String comName) throws InterruptedException {
		ldriver.findElement(txtCompanyName).sendKeys(comName);
		Thread.sleep(3000);
	}
	// below i am hardcodding the adminstrator role for the tc execution and not
	public void setCutromerRole() {
		
		WebDriverWait wait = new WebDriverWait(ldriver,Duration.ofSeconds(10));
        WebElement roleselect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("selectRole")));
		//WebElement role = ldriver.findElement(selectRole);
		//JavascriptExecutor js = (JavascriptExecutor)ldriver;
	//	js.executeScript("window.scrollBy(0,500)");
		//role.click();
        roleselect.clear();
		ldriver.findElement(lstitemAdmin).click();
	
	}
	public void setAdminContent(String content) {
		ldriver.findElement(txtAdminContent).sendKeys(content);
	}
	public void clickOnSave() {
		ldriver.findElement(btnSave).click();
	}
	
}












