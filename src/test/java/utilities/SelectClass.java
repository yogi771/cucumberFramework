package utilities;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectClass {
 //this class includes the select class methods for use
	public WebDriver driver;
	public SelectClass(WebDriver driver) {
		this.driver= driver;
	}
	
	//list of methods from select class
	
	// Select by visible text
    public static void selectByVisibleText(WebElement dropdownElement, String visibleText) {
        try {
            Select select = new Select(dropdownElement);
            select.selectByVisibleText(visibleText);
        } catch (Exception e) {
            throw new RuntimeException("Error selecting '" + visibleText + "' from dropdown: " + e.getMessage());
        }
    }

    // Select by value
    public static void selectByValue(WebElement dropdownElement, String value) {
        try {
            Select select = new Select(dropdownElement);
            select.selectByValue(value);
        } catch (Exception e) {
            throw new RuntimeException("Error selecting value '" + value + "' from dropdown: " + e.getMessage());
        }
    }

    // Select by index
    public static void selectByIndex(WebElement dropdownElement, int index) {
        try {
            Select select = new Select(dropdownElement);
            select.selectByIndex(index);
        } catch (Exception e) {
            throw new RuntimeException("Error selecting index '" + index + "' from dropdown: " + e.getMessage());
        }
    }

    // Get all options
    public static List<WebElement> getAllOptions(WebElement dropdownElement) {
        Select select = new Select(dropdownElement);
        return select.getOptions();
    }

    // Check if an option exists
    public static boolean isOptionPresent(WebElement dropdownElement, String optionText) {
        List<WebElement> options = getAllOptions(dropdownElement);
        return options.stream().anyMatch(option -> option.getText().equals(optionText));
    }
}



