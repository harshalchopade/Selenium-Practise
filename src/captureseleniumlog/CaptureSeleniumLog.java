package captureseleniumlog;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CaptureSeleniumLog

{
	WebDriver driver;

	@Test
	public void testBrowser() {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.logfile","./Chromelog.txt");
		driver = new ChromeDriver();
		
		/*
		 * System.setProperty("webdriver.gecko.driver",
		 * "D:\\Software Setup\\Selenium - Java\\geckodriver_win32\\geckodriver.exe");
		 * System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"./FFLog.txt"
		 * ); driver = new FirefoxDriver();
		 */
		
		driver.manage().window().maximize();
		driver.get("http://www.learn-automation.com");
		driver.quit();
	}
}
