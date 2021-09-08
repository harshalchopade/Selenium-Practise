package jsdemo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/*
 * To execute JavaScript in our webdriver script we do not have to write 
 * the separate code we have one predefined interface available.
 * JavascriptExecutor is an Interface which is available in package org.openqa.selenium.JavascriptExecutor;
 * Inside this Interface we have some predefined method called executeScript()- 
 * so whatever script you will pass as a String  It will be executed by JavascriptExecutor.
 * */

public class JSDemo {

	@Test
	public void brokenLinksExample() throws InterruptedException {
		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Start application
		driver.get("https://www.google.com/webhp?client=firefox-b-d&safe=active");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('Welcome')");
		Thread.sleep(5000);
		driver.quit();

	}
}
