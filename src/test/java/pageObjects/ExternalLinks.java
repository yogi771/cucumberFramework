package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ExternalLinks {

	
	WebDriver ldriver;
	
	public ExternalLinks(WebDriver rdriver) {
		ldriver=rdriver;
		//ExternalLinks.initElements(rdriver, this);
	}
	
	@FindBy(linkText="Instagram")
	@CacheLookup
	WebElement externalLink;
	
	public void clickOnInstagrame() {
		
		externalLink.click();
	}
	
	
	
	
	
}
