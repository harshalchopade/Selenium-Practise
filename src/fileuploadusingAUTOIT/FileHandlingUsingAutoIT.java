package fileuploadusingAUTOIT;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileHandlingUsingAutoIT {
	/*
	 * 1-While automating web-application many times you will get window-based
	 * activity like- file upload, file download pop-up, window authentication for
	 * secure sites, etc. In this case, Selenium will fail and will not be able to
	 * handle desktop elements.
	 * 
	 * We can upload files in Selenium using different ways
	 * 
	 * 1- Using sendKeys method
	 * 
	 * 2- Using Robot class
	 * 
	 * 3- Using AutoIT
	 * 
	 * 4- Using WGET
	 * 
	 * Let me explain to you the easiest way which works most of the time using
	 * sendKeys
	 * 
	 * Syntax
	 * 
	 * driver.findElement(By.xpath("xpath of any element")).sendKeys("File Path");
	 * 
	 * Example
	 * 
	 * driver.findElement(By.xpath("//input[@type='file']")).sendKeys(
	 * "C:\\Downloads\\Mukesh.png");
	 * 
	 * or
	 * 
	 * driver.findElement(By.xpath("//input[@type='file']")).sendKeys(
	 * "C:/Downloads/Mukesh.png");
	 * 
	 * Explanation- You do not have to click on file uploader because if you click
	 * on the file upload button, it will start file uploader which you need to
	 * handle separately.
	 * 
	 * You can find the locator of the element where the file needs to be updated
	 * and then you can pass the file path directly, files can be excel, png or any
	 * type depends on your application.
	 * 
	 * Note- In case of sendKeys method does not work then you can go ahead with all
	 * other options.
	 */

	/*
	 * Scripts required
	 * 
	 * 1.Open AutoIT Script Editor
	 * 
	 * 2.ControlFocus - Sets input focus to a given control on a window.
	 * 
	 * 
	 * syntax - ControlFocus ("title", "text", controlID)
	 *
	 * title - The title/hWnd/class of the window to access text - The text of the
	 * window to access. (pass as empty) controlID - The control to interact with.
	 * (its combination of 'Class and Instance')
	 * 
	 * 3.ControlSetText Sets text of a control.
	 * 
	 * syntax- ControlSetText ("title", "text", controlID, "new text" [, flag = 0] )
	 * 
	 * 
	 * title - The title/hWnd/class of the window to access. text - The text of the
	 * window to access. controlID - The control to interact with. new text - The
	 * new text to be set into the control. flag - [optional] when different from 0
	 * (default) will force the target window to be redrawn.
	 * 
	 * 
	 * 4.ControlClick - Sends a mouse click command to a given control. syntax -
	 * ControlClick ( "title", "text", controlID [, button = "left" [, clicks = 1 [,
	 * x [, y]]]] )
	 * 
	 * Save the autoit file. Execute that file based on processor (32/64 bit) Use
	 * this file in selenium code
	 * 
	 * 
	 * 
	 * There are multiple ways to upload files in Selenium Webdriver
	 * 
	 * You can directly use the sendKeys(“File path”) method but sometimes this
	 * method does not work. If the file uploader does not include an input tag. We
	 * can use the Robot class to upload files in Selenium, which we will discuss
	 * today. You can also take the help of Sikuli or a Robot class.
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

		driver.findElement(By.id("firstName")).sendKeys("hello");

		// This will click on Upload button
		driver.findElement(By.xpath("//*[@type='file']")).click();

		// This will invoke AutoIT script here give the path of the script
		// and this will throw IO exception so u can use throw or try catch
		// In my case I am using throws

		Runtime.getRuntime().exec("./AutoITScripts/FileUpload.exe");

		// Once you will run this program AutoIt script will be invoked and respective
		// file will be attached

		driver.quit();

	}
}
