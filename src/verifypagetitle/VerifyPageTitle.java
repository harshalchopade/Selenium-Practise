package verifypagetitle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class VerifyPageTitle {

	public static void main(String[] args) {
		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://learn-automation.com/");
		
		//Actual Title
		String actualTitle = driver.getTitle();
		System.out.println("Title is "+actualTitle);
		
		/*
		 * String expectedTitle =
		 * "Automation - Selenium WebDriver tutorial Step by Step";
		 * 
		 * Assert.assertEquals(actualTitle, expectedTitle);
		 */
		
		Assert.assertTrue(actualTitle.contains("Automation"));
		System.out.println("Test Completed - Title Verified");
		
		driver.quit();
	}
}