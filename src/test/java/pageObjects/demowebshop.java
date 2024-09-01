package pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ActionClass;
import utilities.WaitHelper;

public class demowebshop {

	 WebDriver ldriver;
	WaitHelper waithelper;
	Actions action;
	
	
	


	public demowebshop(WebDriver rdriver) {
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		waithelper = new WaitHelper(ldriver);
		action = new Actions(ldriver);
	}
	
	
	@FindBy(xpath = "//a[contains(text(),'Register')]" )
	@CacheLookup
	WebElement txtComputers;	
	
	@FindBy(xpath = "//a[contains(text(),'Notebooks')]")
	@CacheLookup
	WebElement txtNotebook;
	
	/*@FindBy()
	@CacheLookup
	WebDriver txtPageTitle;*/

	@FindBy(xpath = "//h2[@class='product-title']")
	@CacheLookup
	WebElement txtProductTitle;
	
	public void hoverOnComputers() {
		action.moveToElement(txtComputers).perform();
		//action.moveToElement(txtNotebook).click().build().perform();
		//txtComputers.click();
		
	}
	
	public void clickNoteBook() throws InterruptedException {
		Thread.sleep(3000);
		
		action.moveToElement(txtNotebook).click().build().perform();
		
	}
	
	public String getProductName() {
		return txtProductTitle.getText();
		
	}
	
	public String getPageTitle(WebDriver driver) {
	return	driver.getTitle();
	}
	
	
	
}
