package testNGlistenersdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(testNGlistenersdemo.TestNGListeners.class)
public class ClassLevel {
	
	@Test(priority = 1)
	public void listenerDemo() throws InterruptedException {
		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ksrtc.in/oprs-web/");
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
