package jsdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TypeValuesUsingJS {
	/*
	 * 'sendKeys()' will work only when the webelement is enabled and it is visible.
	 * e.g textbox is enabled and visible then only we can do sendkeys operation
	 * But if due to some condition that textbox is disabled then it will fail
	 * Incase of javascript it will not fail even its disabled bcz it works with DOM structure
	 * forcefully it can change the value in DOM.
	 * 
	 * IMP Note
	 * JS should not be used extensively lets consider
	 * 	we have dedicated textbox and it is disabled it may be appln issue
	 * if we use sendkeys it will fail and we get to know there is some issue with app or something went wrong
	 * But if we use JS it is disabled or not working it injects that value forcefully.
	 * But its not the actual way to test the app
	 * Whenever selenium sendkeys is now working use there only don use it unnessecary.
 	 * */
	@Test
	public void brokenLinksExample() throws InterruptedException {
		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Start application
		driver.get("https://www.google.com/webhp?client=firefox-b-d&safe=active");
		
		WebElement searchTextBox = driver.findElement(By.name("q"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//Type the value in searchbox using JS
		js.executeScript("arguments[0].value='Selenium'", searchTextBox);
		
		/*In the above syntax arguments[0] will be replaced by the 'searchTextBox' locator at runtime 
		and passing the values i.e test data as 'Selenium' in that field */
		
		//Alternate approach
		js.executeScript("arguments[0].value=arguments[1]", searchTextBox, "Selenium");
		
		/*In the above syntax arguments[0] will be replaced by the 'searchTextBox'
		 * and arguments[1] will be replaced by the values i.e test data as 'Selenium' in that field
		 and then it will pass in that field 
		 
		 Note
		 In this syntax both will be in the form argument i.e locator and test data
		 But in 1st approach only locator is argument but not test data
		 */
		
		Thread.sleep(2000);
		driver.quit();	
	}
}
