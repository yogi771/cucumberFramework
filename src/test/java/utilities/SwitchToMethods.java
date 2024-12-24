package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SwitchToMethods {// class for switch methods 

	public WebDriver driver;
	
	public SwitchToMethods(WebDriver driver) {
		this.driver = driver;
		}
	
	 //first methods will be on switch to frames
	
	public WebDriver switchTOframeElement(WebElement element) {
	return switchTO().frame(element);
	}
	
	
}
