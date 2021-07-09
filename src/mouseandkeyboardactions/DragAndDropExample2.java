package mouseandkeyboardactions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DragAndDropExample2 {

	/*
	 * Method name and Usage 
	 * 
	 * moveToElement(WebElement)-- Mouse Hover
	 * contextClick()-- Right click on page
	 * contextClick(WebElement)-- Right click on specific Element
	 * sendKeys(KEYS.TAB)--For keyboard events
	 * clickAndHold(WebElement)--Click on element and hold until next operation
	 * release() Release the current control
	 */

	@Test(priority = 1)
	public void draggableExample2() throws InterruptedException {
		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.manage().window().maximize();
		// Start application
		driver.get("https://jqueryui.com/droppable/");

		Actions action = new Actions(driver);

		driver.switchTo().frame(0);

		WebElement src = driver.findElement(By.id("draggable"));

		WebElement dest = driver.findElement(By.id("droppable"));

		action.clickAndHold(src).pause(Duration.ofSeconds(5)).moveToElement(dest).pause(Duration.ofSeconds(5)).release()
				.build().perform();

		Thread.sleep(7000);

		driver.quit();
	}
}
