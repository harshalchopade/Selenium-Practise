package mouseandkeyboardactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsIntro {

	public static void main(String[] args) {
		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Start application
		driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html");
		
		Actions action = new Actions(driver);
		action.contextClick(null);

	}

}
