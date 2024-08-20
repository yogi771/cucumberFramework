package com.Accenture.letMeShop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Register_Test {

	
	public void RegisterUser() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");

		WebElement Register = driver.findElement(By.linkText("Register"));
		Register.click();

		WebElement ButtonMale = driver.findElement(By.id("gender-male"));
		ButtonMale.click();

		WebElement FirstName = driver.findElement(By.name("FirstName"));
		FirstName.sendKeys("Yogiraj");

		WebElement LastName = driver.findElement(By.id("LastName"));
		LastName.sendKeys("Jawale");

		WebElement Email = driver.findElement(By.id("Email"));
		Email.sendKeys("5670415636@gmail.com");

		WebElement Password = driver.findElement(By.id("Password"));
		Password.sendKeys("JawaYogi");

		WebElement ConfirmPassword = driver.findElement(By.id("ConfirmPassword"));
		ConfirmPassword.sendKeys("JawaYogi");

		WebElement RegisterButton = driver.findElement(By.id("register-button"));
		RegisterButton.click();

	}

}
