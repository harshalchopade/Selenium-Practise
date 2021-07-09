package capturescreenshot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import library.Utility;

public class CaptureScreenshotOnFailure {

	/* Description */

	/*
	 * Today we will see something different How to capture a screenshot for failed
	 * test cases in Selenium Webdriver.
	 * 
	 * Here I will be using two new topics which will help us to achieve the same.
	 * 1-We will use ITestResult Interface which will provide us the test case
	 * execution status and test case name. Please refer official doc for
	 * ITestResult
	 * 
	 * 2- @AfterMethod is another annotation of TestNG that will execute after every
	 * test execution whether test case pass or fail @AfterMethod will always
	 * execute. Please refer official doc for @AfterMethod
	 */
	WebDriver driver;
	
	@Test
	public void captureScreenshotOnFailure() {
		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com");
	
		driver.findElement(By.id("txtUsern")).sendKeys("Admin");
		driver.quit();
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreenshots(driver, result.getName());
		}
		
	}

}
