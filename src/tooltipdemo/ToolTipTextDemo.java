package tooltipdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ToolTipTextDemo
{
	WebDriver driver;

	@Test
	public void testBrowser() {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		// System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://seleniumpractise.blogspot.com/2019/09/bootstrap-tooltip-in-selenium.html");

		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[text()='Hover over me']"))).perform();

		String text = driver.findElement(By.xpath("//div[@class='tooltip-inner']")).getText();

		System.out.println(text);
		Assert.assertTrue(text.contains("Hooray!"));

		driver.quit();
	}
}
