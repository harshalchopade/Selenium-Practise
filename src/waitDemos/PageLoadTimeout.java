package waitDemos;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PageLoadTimeout {

//pageLoadTimeout in Selenium

	/*
	 * This sets the time to wait for a page to load completely before throwing an
	 * error. If the timeout is negative, page loads can be indefinite.
	 * 
	 * Syntax:
	 * 
	 * pageLoadTimeout(long time,java.util.concurrent.TimeUnit unit);
	 * 
	 * This timeout is applicable only to driver.manage() and driver.navigate.to()
	 * methods.
	 * In the below above, if your page does not load within 15 seconds, TimeoutException will be thrown.
	 */

	@Test(priority = 1)
	public void handlePageLoadTimeout() {
		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.get("https://learn-automation.com/implicit-wait-in-selenium-webdriver/");
		driver.quit();
	}
}
