package highlightelements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import library.Utility;

public class HighlightElements {
	/*
	 * For Selenium, we have to write small code, which simply highlight element
	 * based on our parameter values. let’s get started and see Highlight element
	 * Selenium using CSS values.
	 */

	@Test
	public void highlightElementExample() throws InterruptedException {

		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		// Start browser
		WebDriver driver = new ChromeDriver();

		// Maximize browser
		driver.manage().window().maximize();

		// Pass application URL
		driver.get("http://seleniumpractise.blogspot.com/2016/");

		WebElement uname = driver.findElement(By.id("username"));

		// Highlight the element
		Utility.highLightElement(driver, uname);

		/*
		 * // call the executeScript method js.
		 * executeScript("arguments[0].setAttribute('style,'border: solid 2px red'');",
		 * username);
		 */
		
		driver.quit();
	}
}
