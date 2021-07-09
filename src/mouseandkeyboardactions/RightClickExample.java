package mouseandkeyboardactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class RightClickExample {

	/*
	 * Right Click in Selenium Webdriver
	 * 
	 * As we discussed earlier for right-click on a particular link or any
	 * web-element Selenium Webdriver has contextClick() methods available in
	 * Actions class. There are two flavors of this 1-contextClick()- which will
	 * right Click on a page 2-contextClick(WebElement) – which will right click on
	 * a particular web-element.
	 */
	
	@Test(priority = 1)
	public void simpleAlertHandling() throws InterruptedException {
		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Start application
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

		Actions action = new Actions(driver);

		action.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).perform();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[text()='Copy']")).click();

		Thread.sleep(3000);

		System.out.println(driver.switchTo().alert().getText());

		driver.switchTo().alert().accept();

		driver.quit();
	}
}
