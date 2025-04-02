package com.Accenture.letMeShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Login_Test {

	
	public void loginWithUser() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		WebElement Login = driver.findElement(By.linkText("Log in"));
		Login.click();
		WebElement Email = driver.findElement(By.id("Email"));
		Email.sendKeys("5670415636@gmail.com");

		WebElement Password = driver.findElement(By.id("Password"));
		Password.sendKeys("JawaYogi");

		WebElement LoginButton = driver.findElement(By.xpath("//input[@value ='Log in']"));
		LoginButton.click();

	}
}
//test for the version control  
