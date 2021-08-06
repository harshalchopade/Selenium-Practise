package crossbrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * We are using '@Parameters' annotation of TestNG to pass the browser name from the XML file we generated for this class
 * We can pass multiple parameters to the test case.
 * */
public class CrossBrowserTest {

	WebDriver driver;

	@Test
	@Parameters({"browser"})
	public void testBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) 
		{
			System.setProperty("webdriver.gecko.driver",
					"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else
		{
			System.setProperty("webdriver.chrome.driver",
					"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get("http://www.learn-automation.com");
		driver.quit();
	}
}
