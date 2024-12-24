package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionClass {

	public WebDriver driver;
	Actions action = new Actions(driver);
	
	public ActionClass(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void toElement(WebElement element) {
		action.moveToElement(element).click().perform();
	}
	//add more action class methods
	
	public void scrollUPElement(WebElement element) {
		action.scrollToElement(element).perform();
	}
	
	public void scrollDownToFooter() {
		action.scrollByAmount(0, 900).perform();
	}
}
