package windowsauthentication;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandleWindowsAuthentication {

	/*
	 * Why we are getting Authentication window
	 * 
	 * Each company having some proxy setting for the specific application so while
	 * running script using Selenium you will get this authentication window which
	 * asks for Username and password so until we don’t handle this you cannot
	 * navigate to parent window.
	 * 
	 * Example- I have found this URL where actually u can see this pop-up.
	 * 
	 * https://www.engprod-charter.net/
	 * 
	 * How to Handle Authentication using Selenium
	 * 
	 * I think its time to handle this Authentication so now there are two ways for
	 * this.
	 * 
	 * First approach- Handle Windows Authentication popup using Selenium Webdriver
	 * 
	 * You can provide credentials in URL itself it means we will add username and
	 * password in URL so while running script it will bypass the same.
	 * 
	 * Syntax
	 * 
	 * http://username:password@url
	 * 
	 * Example :
	 * 
	 * http://mukeshotwani:password1234@www.xyz.com
	 * 
	 * 
	 * Second approach: Handle Windows Authentication popup using Selenium Webdriver
	 * 
	 * We can use AutoIT again to handle this authentication window for this Please
	 * check whether you have AutoIT installed or not. If not then please download
	 * from here
	 * 
	 * 1) Open the Url ENGPROD on which the authentication is required and open the
	 * AutoIt Window Info tool to get the name of the class and the text of the
	 * authentication window.
	 * 
	 * Handle Windows Authentication popup using Selenium Webdriver
	 * 
	 * 2) drag the ‘Finder Toolbox to the object in which you are interested and it
	 * displays you the information.
	 * 
	 * Handle Windows Authentication popup using Selenium Webdriver 3) If you
	 * download the full version of Scite4AutoIt3 and look for the Au3Recorder in
	 * the Tools menu.
	 * 
	 * Open the Script Editor window, save the blank file with ‘.au3′ extension and
	 * then go to Tools > AU3Recorder or Alt + F6 on AutoIt Script Editor.
	 * 
	 * A window will open for recording. Let us record the steps to send the
	 * username & password to the authentication window, for that please activate
	 * the Recorder by Tools >AU3Recorder or Alt + F6 on AutoIt Script Editor.
	 * 
	 * Handle Windows Authentication using Selenium Webdriver 4) Top left signal
	 * says that the recording is on. Now type the username and password and do not
	 * use the mouse to click on any field, simply use keyboard’s tab button to do
	 * the thing.
	 * 
	 * Handle Windows Authentication using Selenium Webdriver
	 * 
	 * 5) Once you did with your recording, your code will look like this.
	 * 
	 * Handle Windows Authentication using Selenium Webdriver 6) Now save the above
	 * script, if in case you have not saved the name earlier, please save it in
	 * .au3 format.
	 * 
	 * The next step is to convert it into the .exe format. For that, you need to do
	 * a right click on the .au3 file and select “Compile Script“.
	 * 
	 * Handle Windows Authentication using Selenium Webdriver Note: Make sure that
	 * you select ‘Compile Script’ as per your machine configuration. Select normal
	 * version if you are on 32 bits, and select x64 or x86 if you are on 64 bits.
	 * 7) Once you did with the compiling, it will create the ‘.exe’ file with the
	 * same name under the same folder and that ‘.exe’ the file will be called in
	 * the Selenium Test Script by using the following script:
	 */

	@Test
	public void uploadfile() throws InterruptedException, IOException {

		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		// Start browser
		WebDriver driver = new ChromeDriver();

		// Maximize browser
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// This will open respective URL
		driver.get("https://demoqa.com/automation-practice-form");
		
		//Approach - 1
		driver.get("http://mukeshotwani:password1234@www.xyz.com");

		//Approach - 2
		Runtime.getRuntime().exec("./AutoITScripts/AuthWindow.exe");
	
		driver.quit();
	}
}
