package windowhandling;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetWindowSize {
	public static void main(String[] args) {

		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		Dimension d = new Dimension(100, 200);
		driver.manage().window().setSize(d);
		driver.get("https://the-internet.herokuapp.com/upload");
	}
}
