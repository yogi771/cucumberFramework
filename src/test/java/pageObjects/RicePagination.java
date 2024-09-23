package pageObjects;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RicePagination {

	WebDriver ldriver;
	
	public RicePagination(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}	
	
	@FindBy(xpath="//table[@class='table table-bordered']/tbody/tr/td[1]")
	@CacheLookup
	List<WebElement> lstProductNames;
	
	@FindBy(xpath="//table[@class='table table-bordered']/tbody/tr/td[2]")
	@CacheLookup
	List<WebElement> lstPrice;
	
	@FindBy(xpath="//a[@aria-label='Next']")
	@CacheLookup
	WebElement btnnext;
	
	public String checkTable() {
		String str="";
		
//List<WebElement> list =		lstProductNames.stream().filter(element -> element.getText().equals("Rice")).collect(Collectors.toList());

for (WebElement element1 : lstProductNames) {
    str =str+  element1.getText();
    
}

//String str=((WebElement) list).getText();
return str;
	}
	
	
	
	
	
	
	
}
