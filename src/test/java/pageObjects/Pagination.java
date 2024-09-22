package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pagination {
	public WebDriver ldriver;

	public Pagination(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		}	
	
	@FindBy(xpath="//a[text()='Sitemap']")
	@CacheLookup

	WebElement footerOne;
	
	
	
	public  void clickFooterOne() {
		Actions action = new Actions(ldriver);
		action.scrollByAmount(0, 800);
		footerOne.click();
		
	}
	
	public boolean checkTitle() {
	String title =	ldriver.getTitle();
	
	return (title.equalsIgnoreCase("Demo Web Shop. Sitemap"));
	}
	
	
	public void moveBack() {
		ldriver.navigate().back();
	}
	
	
	
}
