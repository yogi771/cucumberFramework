package utilities;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SwitchToMethods {// class for switch methods 

	public WebDriver driver;
	
	public SwitchToMethods(WebDriver driver) {
		this.driver = driver;
		}
	
	 //first methods will be on switch to frames
	
	public WebDriver switchTOframeElement(WebElement element) {
	return driver.switchTo().frame(element);
	}
	
	// Switch to a window by title
    public static void switchToWindowByTitle(WebDriver driver, String windowURL) {
    	 String currentHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();

        for (String handle : handles) {
            driver.switchTo().window(handle);
            if (driver.getCurrentUrl().equals(windowURL)) {
                return;
            }
        }}

	
    
}
