package mouseandkeyboardactions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Draggable {

	@Test(priority = 1)
	public void draggableExample() throws InterruptedException {
		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.manage().window().maximize();
		// Start application
		driver.get("https://jqueryui.com/draggable/");

		Actions action = new Actions(driver);
		
		driver.switchTo().frame(0);

		WebElement src = driver.findElement(By.id("draggable"));

		action.dragAndDropBy(src, 300, 100).pause(Duration.ofSeconds(5)).build().perform();;

		driver.quit();

	}
}
