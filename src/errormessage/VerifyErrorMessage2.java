package errormessage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class VerifyErrorMessage2 {

	public void errorMessageVerification() throws InterruptedException {
		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.netmeds.com/customer/account/login");
		driver.findElement(By.xpath("//button[text()='USE PASSWORD']")).click();

		Thread.sleep(3000);

		String actual_error = driver.findElement(By.xpath("//div[@class='error-msg ng-star-inserted']")).getAttribute("innerHTML");
		System.out.println("Actual error message is - "+actual_error);
		
		String expected_error = "Please enter your Mobile Number!";

		// Type1
		Assert.assertEquals(actual_error, expected_error);

		// Type2
		Assert.assertTrue(actual_error.contains("Please enter your Mobile Number!"));

		System.out.println("Test Completed");
		driver.quit();
	}
}
