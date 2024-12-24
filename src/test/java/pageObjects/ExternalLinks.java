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
	
	@FindBy(linkText="Myntra")
	@CacheLookup
	WebElement myntraLink;
	
	public WebElement clickOnMyntra() {
	return	myntraLink;
	}
	
	@FindBy(linkText="Cleartrip")
	@CacheLookup
	WebElement clearTripLink;
	
	public WebElement clickOnClearTrip() {
	return	clearTripLink;
	}
	
	@FindBy(linkText="Shopsy")
	@CacheLookup
	WebElement ShopsyLink;
	
	public WebElement clickOnShopsy() {
	return	ShopsyLink;
	}
	
	
	
}
