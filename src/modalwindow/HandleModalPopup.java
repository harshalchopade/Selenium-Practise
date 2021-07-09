package modalwindow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/*The Modal plugin is a dialog box/popup window that is displayed on top of the current page:
 *1.It is not a seperate window or alert we can directly perform any operation based on our req.
 *2.In some app you might get some frames then you have to  switch to frame first and then you can perform operations.	*/

public class HandleModalPopup {

	@Test(priority = 1)
	public void modalPopupHandling() throws InterruptedException {
		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		try {
			driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
			driver.findElement(By.xpath("//a[text()='Login']")).click();
			driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys("harshal");
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		driver.quit();

	}

	@Test(priority = 2)
	public void modalPopupHandlingWithFrame() throws InterruptedException {
		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/bus-tickets/");
		driver.findElement(By.xpath("//a[@class='D121_options_nav_a']/i[2]")).click();

		driver.findElement(By.xpath("//span[text()='Sign In/Sign Up']")).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='D121_iframe']")));

		driver.findElement(By.id("mobileNoInp")).sendKeys("966563");
		Thread.sleep(5000);

	}
}
