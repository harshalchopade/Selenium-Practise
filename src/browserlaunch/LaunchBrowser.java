package browserlaunch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LaunchBrowser {

	/* To attach the java source doc in the project for info related to
	 * selenium methods
	 * Download the selenium language-specific client drivers.(Java)  
	 * After downloading extract the zip folder in that you will find
	 * 'client-combined-version no-sources.jar' file attach it in the project
	 * */
	
	public static void main(String[] args) throws InterruptedException 
	{
		
		  //Code for launching the Chrome browser
		  System.setProperty("webdriver.chrome.driver","D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://demoqa.com/select-menu"); 
		  String pageTitle = driver.getTitle(); 
		  System.out.println(pageTitle);
		  System.out.println(driver.getCurrentUrl()); 
		  Select select = new Select(driver.findElement(By.id("oldSelectMenu")));
		  select.selectByVisibleText("Yellow"); 
		  driver.quit();
		 
		
		//Code for launching the Firefox browser
		/*We either user double backward slash while giving the path 
		 *or we can use single forward slash while mentioning the path* */
		System.setProperty("webdriver.gecko.driver", "D:/Software Setup/Selenium - Java/geckodriver-v0.29.0-win64/geckodriver.exe");
		WebDriver ffdriver = new FirefoxDriver();
		ffdriver.manage().window().maximize();
		ffdriver.get("https://demoqa.com/select-menu");
		String ffpageTitle = ffdriver.getTitle();
		System.out.println(ffpageTitle);
		System.out.println(ffdriver.getCurrentUrl());
		Select ffselect = new Select(ffdriver.findElement(By.id("oldSelectMenu")));
		ffselect.selectByVisibleText("Yellow");
		ffdriver.quit();
		
		/*Shortcut Keys for Debug
		 * 
		 * Ctrl + F11 –> to run the program
		 * F5/Fn + F5 –> step into/ go into the method
		 * F6/Fn + F6 –> stepover/ execute the current statement and points the next statement
		 * Fn + Alt + F5 –> Update the maven project.
		 * Ctrl + Shift + O –> Import the statement automatically.
		 * Ctrl + / –> to comment and uncomment single line of code
		 * Ctrl + Shift + / –> to comment block of code consisting of 3 or more lines of code
		 * Ctrl + Shift + \ –> to uncomment block of code, which is already commented
		 * Ctrl + Shift + F - format the doc.
		 * Alt + <–  - to go back to backward in the code
		 * Alt + –>  - to go back to previous
		 * Ctrl + Shift + / - to collapse the code
		 * Ctrl + Shift + * - to expand the code
		 * */	
	}
}
