package jsdemo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScrollUsingJS {

	/*
	 * Selenium handle scrolling page automatically but if want to scroll page using
	 * Selenium then yes we can do easily using JavaScript.
	 * 
	 * We have method scroll(horizontal, vertical) i.e. scroll(0,400)
	 * 
	 * Note- scroll method is not a method of Webdriver, this is a method of
	 * JavaScript.
	 */

	@Test
	public void scrollPageExample() throws InterruptedException {
		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Start application
		driver.get("https://www.google.com/webhp?client=firefox-b-d&safe=active");

		//JavascriptExecutor js = (JavascriptExecutor) driver;

		// Open Application
		driver.get("http://jqueryui.com");

		// Wait for 5 second
		Thread.sleep(5000);

		// This will scroll page 400 pixel vertical
		((JavascriptExecutor) driver).executeScript("scroll(0,400)");
		
		driver.quit();
	}
}
