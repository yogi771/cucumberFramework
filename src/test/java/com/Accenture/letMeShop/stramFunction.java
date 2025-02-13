package com.Accenture.letMeShop;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class stramFunction {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com");
		
		List<WebElement> list	=driver.findElements(By.id("id=u_0_2_R6"));
	
	Iterator<WebElement> it = list.iterator();
	while (it.hasNext()) {
	    System.out.println(it.next());
	}
	
Stream<WebElement> streamList =	list.stream();
		
	}
	}
	
	

