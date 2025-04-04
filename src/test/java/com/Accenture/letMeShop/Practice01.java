package com.Accenture.letMeShop;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Practice01 {

	 public static void main(String[] args) {
		
		 
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://demoqa.com/");
		 
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        
	        // Target the clickable card, not just <h5>
	        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//h5[text()='Elements']/ancestor::div[@class='card mt-4 top-card']")));

	        Actions action = new Actions(driver);
	        try {
	            action.moveToElement(element).click().build().perform();
	        } catch (Exception e) {
	            System.out.println("Exception caught: " + e);
	        }

	        // Optional: Verify navigation
	        System.out.println("Page title after click: " + driver.getTitle());

	      
		 
		 
		 
	}

}
