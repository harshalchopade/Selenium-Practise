package verifypagetitle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class VerifyUsingPageSource {

	public static void main(String[] args) {
		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://learn-automation.com/");

		// Actual Title
		String pageSource = driver.getPageSource();
		//System.out.println("Page Source is " + pageSource);

		Assert.assertTrue(pageSource.contains("Automation - Selenium WebDriver tutorial Step by Step"));
		System.out.println("Test Completed - Title Verified");

		driver.quit();
	}

}
