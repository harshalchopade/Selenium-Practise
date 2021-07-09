package removechromewarning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.Test;

public class RemoveChromeWarningInSelenium 

{
	WebDriver driver;

	@Test
	public void testBrowser() 
	{
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		//System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.chrome.logfile","./Chromelog.txt");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.learn-automation.com");
		driver.quit();
	}
}
