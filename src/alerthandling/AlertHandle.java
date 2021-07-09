package alerthandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertHandle {
	/*
	 * An Alert in Selenium is a small message box which appears on screen to give
	 * the user some information or notification. It notifies the user with some
	 * specific information or error, asks for permission to perform certain tasks
	 * and it also provides warning messages as well.
	 */

	
	/*Alert interface provides the below few methods which are widely used in Selenium Webdriver.

	1) void dismiss() // To click on the 'Cancel' button of the alert.

	driver.switchTo().alert().dismiss();

	2) void accept() // To click on the 'OK' button of the alert.

	driver.switchTo().alert().accept();

	3) String getText() // To capture the alert message.

	driver.switchTo().alert().getText();			

	4) void sendKeys(String stringToSend) // To send some data to alert box.

	driver.switchTo().alert().sendKeys("Text"); */
	
	//=====================================================================================//
			
	//Simple Alert

	/*
	 * The simple alert class in Selenium displays some information or warning on the screen.
	 */

	WebDriver driver;

	@Test(priority = 1)
	public void simpleAlertHandling() throws InterruptedException {
		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D://Software Setup//Selenium - Java//chromedriver_win32//chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ksrtc.in/oprs-web/");

		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();

		String alert_text = driver.switchTo().alert().getText();
		System.out.println("Alert text is " + alert_text);

		Thread.sleep(5000);
		driver.switchTo().alert().accept();

		String expected_alert_msg = "Please select start place.";

		Assert.assertEquals(alert_text, expected_alert_msg);

		driver.quit();
	}
	
	//Prompt Alert.

	/*This Prompt Alert asks some input from the user and Selenium webdriver can enter the text using sendkeys(" input….").*/ 
	
	@Test(priority = 2)
	public void promptAlertHandling() throws InterruptedException {
		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");

		driver.findElement(By.id("promtButton")).click();

		String alert_text = driver.switchTo().alert().getText();
		System.out.println("Alert text is " + alert_text);

		Thread.sleep(5000);
		driver.switchTo().alert().sendKeys("Harshal");
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		driver.quit();
		
	}
	
	//Confirmation Alert.
    /*This confirmation alert asks permission to do some type of operation.*/ 
	
	@Test(priority = 3)
	public void confirmationAlertHandling() throws InterruptedException {
		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");

		WebElement button = driver.findElement(By.id("confirmButton"));
		button.click();

		String alert_text = driver.switchTo().alert().getText();
		System.out.println("Alert text is " + alert_text);

		driver.switchTo().alert().accept();
		
		button.click();
		driver.switchTo().alert().dismiss();

		driver.quit();
	}	
}
