package downloadfile;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandleFileDownloadUsingAutoIT {
	
	/*
	 * Commands to download file
	 * Inetget - Downloads a file from the internet using HTTP, HTTPS or FTP protocol
	 * */

	@Test
	public void downloadfile() throws InterruptedException, IOException {

		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		// Start browser
		WebDriver driver = new ChromeDriver();

		// Maximize browser
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Runtime.getRuntime().exec("./AutoITScripts/FileDownload.exe");

		driver.quit();
	}
}
