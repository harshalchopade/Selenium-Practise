package mouseandkeyboardactions;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class mouseHover {

	@Test(priority = 1)
	public void draggableExample() throws InterruptedException {
		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Start application
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-perform-mouse-hover-in-selenium.html");

		Thread.sleep(5000);
		WebElement button = driver.findElement(By.className("dropbtn"));
		Actions action = new Actions(driver);

		action.moveToElement(button).perform();

		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='dropdown-content']/a"));

		for (WebElement eachElement : elements) {
			String text = eachElement.getAttribute("innerHTML");

			boolean status = eachElement.isEnabled();

			System.out.println("Link name is " + text + " status is " + status);

			if (text.equalsIgnoreCase("Appium")) {
				eachElement.click();
				System.out.println(driver.getTitle());
				break;
			}
		}

		driver.quit();
	}
}
