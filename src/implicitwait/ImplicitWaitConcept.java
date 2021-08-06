package implicitwait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaitConcept {
	//Implicit wait is a global wait applicable for all the webelements
	//Declared after driver inititalization
	//It's a dynamic wait.
	//It will be executed on the server level i.e at driver executable 
	//local code >remote Server > language binding > driver exe > Browser
	//undocumented and undefined behaviour
	//runs on remote side/executebale exe (app side) of selenium webdriver based on the impltn of driver exe
	//only for findelement and findelements
	//cannot be customized
	
	
	public static void main(String[] args) {
	// Code for launching the Chrome browser
			System.setProperty("webdriver.chrome.driver",
					"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			// Start application
			driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}
}
