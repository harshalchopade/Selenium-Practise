package waitDemos;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import library.Utility;

public class ImplicitWait {
	/*
	 * Sometimes an application will not able to load elements due to the below issues.
	 * 
	 * Network issue 
	 * Application issues 
	 * Browser stopping 
	 * JavaScript call.And so on.
	 * 
	 * By default, Selenium will not wait for an element once the page load
	 * completes. It checks for an element on the page then it performs some
	 * operation based on your script but if the element is not present then it
	 * throws NoSuchElement Exception.
	 * 
	 * 
	 * This is one of the interview questions that what is the default timeout in Selenium is.
       Answer- The default timeout is ZERO.
	 * 
	 * Note- Implicit wait in selenium webdriver will be applicable throughout your script and
	 * will works on all elements in the script once your specified implicit wait. It is also known as Global wait.
	 * 
	 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 * In this statement, the WebDriver will wait for 0 seconds before proceeding to the next action.
	 */

	@Test
	public void implicitWaitDemo() {

		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btLogin")).click();
		driver.quit();

	}
}
