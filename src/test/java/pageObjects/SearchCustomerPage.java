package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {
	public WebDriver ldriver;
	
	WaitHelper waithelper;
	

	public SearchCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		waithelper = new WaitHelper(ldriver);
	}
	
	@FindBy(how = How.ID, using = "SearchEmail")
	@CacheLookup
	WebElement txtEmail;

	@FindBy(how = How.ID, using = "SearchFirstName")
	@CacheLookup
	WebElement txtFirstName;
	
	@FindBy(how = How.ID, using = "SearchLastName")
	@CacheLookup
	WebElement txtLastName;
	
	@FindBy(how = How.ID, using = "search-customers")
	@CacheLookup
	WebElement btnSearch;
	
	@FindBy(how = How.ID, using = "//table[@id='customers-grid']/tbody/tr")
	@CacheLookup
	List<WebElement> tablerows;
	
	@FindBy(how = How.ID, using = "//table[@id='customers-grid']/tbody/tr/td")
	@CacheLookup
	List<WebElement> tableColumns;

	@FindBy(how = How.ID, using = "//table[@id='customers-grid']")
	@CacheLookup
	List<WebElement> table;
	
	@FindBy(how = How.ID, using = "//table[@role='grid']")
	@CacheLookup
	List<WebElement> tblSearchResult;
	
	public void setEmail(String email)
	{
		//waithelper.WaitFotElement(txtEmail, 30);
		txtEmail.clear();
		txtEmail.sendKeys(email);	
		
	}

	public void setFirstName(String fname)
	{
		txtFirstName.clear();
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastName.clear();
		txtLastName.sendKeys(lname);
	}
	
	public void clickSearch() {
		btnSearch.click();
		
	}
	
	public int getNoOfRows() {
		return(tablerows.size());
	}
	
	public int getNoOfColumns() {
		return(tableColumns.size());
	}
	
	public boolean searchCustomerByEmail(String email)
	{
		
		boolean flag =false;
		for(int i =1;i<=getNoOfRows();i++) {
			String emailId = ((WebElement) ((By) table).findElements((SearchContext) By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]"))).getText();
			
			System.out.println(emailId);
			if(emailId.equals(email))
			{
				flag = true;
			}
		}
		return flag;
	}
	
	public boolean searchCustomerByName(String name)
	{
		boolean flag =false;
		for(int i =1;i<=getNoOfRows();i++) {
			String Name = ((WebElement) ((By) table).findElements((SearchContext) By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]"))).getText();
			String names[] = Name.split(" ");
			
			if(names[0].equals("James") && names[1].equals("Pan"))
			{
				flag = true;
			}
		}
		return flag;
	}
	
	
}
