package mouseandkeyboardactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DoubleClickExample {
	@Test(priority = 1)
	public void simpleAlertHandling() throws InterruptedException {
		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://api.jquery.com/dblclick/");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
		
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(By.xpath("//span[text()='Double click the block']//parent::body/div")))
		.perform();
		Thread.sleep(5000);
		driver.quit();
	}

}
