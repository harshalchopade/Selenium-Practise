package windowhandling;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class multipleWindowHandling {

	@Test(priority = 1)
	public void simpleAlertHandling() throws InterruptedException {
		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.com/2017/07/multiple-window-examples.html");
		String parent = driver.getWindowHandle();
		System.out.println("Parent Window id is "+parent);
		
		driver.findElement(By.xpath("//a[@href='http://www.google.com']")).click();
		driver.findElement(By.xpath("//a[@href='http://www.yahoo.com']")).click();

		
		Set<String> all_windows = driver.getWindowHandles();
		System.out.println("Windows count are "+ all_windows.size());
		
		List<String> tabs = new ArrayList<>(all_windows);
		driver.switchTo().window(tabs.get(2));
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.close();
		
		
		driver.switchTo().window(tabs.get(1));
		driver.findElement(By.xpath("(//input[@type='text'])[1]")).isDisplayed();
		driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("news");
		driver.close();
		
		driver.switchTo().window(tabs.get(0));
		System.out.println("Title of parent window is "+driver.getTitle());
		driver.quit();
	}
}
