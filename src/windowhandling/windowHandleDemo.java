package windowhandling;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/*How to handle Selenium Pop-up window using Webdriver
In automation, when we have multiple windows in any web application, 
the activity may need to switch control among several windows from one to other in order to 
complete the operation. After completion of the operation, it has to return to the main window 
i.e. parent window in Selenium. We will see this further in the article with an example.

In Selenium web driver there are methods through which we can handle multiple windows.
Driver.getWindowHandles();

To handle all opened windows by web driver, we can use "Driver.getWindowHandles()" and 
then we can switch window from one window to another in a web application.
 Its return type is Iterator<String>.

Driver.getWindowHandle();

When the site opens, we need to handle the main window by driver.getWindowHandle(). 
This will handle the current window that uniquely identifies it within this driver instance. Its return type is String.
*/

public class windowHandleDemo {

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
		
		Set<String> all_windows = driver.getWindowHandles();
		int count = all_windows.size();
		
		for(String child:all_windows)
		{
			if(!parent.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				driver.findElement(By.name("q")).sendKeys("Selenium Webdriver");;
				driver.close();
			}
		}
		
		driver.switchTo().window(parent);
		System.out.println("Parent Window title is "+driver.getTitle());
		driver.quit();
		
	}
}
