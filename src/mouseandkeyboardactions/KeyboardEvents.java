package mouseandkeyboardactions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class KeyboardEvents {
	
	/* Using actions class also we can send the text in the webelement.
	 * 'Keys' is the enum which we need to use to perform keyboard events
	 * */
	
	@Test(priority = 1)
	public void keyboardKeysExample() throws InterruptedException {
		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.manage().window().maximize();
		
		// Start application1
		driver.get("http://seleniumpractise.blogspot.com/2016/12/basic-form-creation.html");
		
		driver.findElement(By.id("username")).sendKeys("Harshal");;

		Actions action = new Actions(driver);
		
		action.sendKeys(Keys.TAB)
		.pause(Duration.ofSeconds(2))
		.sendKeys("Chopade")
		.build().perform();
		
		driver.quit();
	}
	
	@Test(priority = 2)
	public void keyboardKeysExample2() throws InterruptedException {
		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.manage().window().maximize();
		
		// Start application1
		driver.get("https://the-internet.herokuapp.com/key_presses?");
		
		Thread.sleep(5000);
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).perform();
		
		if(driver.findElement(By.id("result")).getText().contains("TAB"))
		{
			System.out.println("Key is pressed");
		}
		
		driver.quit();
	}
}
