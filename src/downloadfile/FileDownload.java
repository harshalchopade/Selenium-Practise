package downloadfile;

import java.io.File;
import java.util.UUID;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileDownload {
	WebDriver driver;
	File folder;
	
	@BeforeMethod
	public void setUp()
	{
		folder = new File(UUID.randomUUID().toString());
		folder.mkdir();
		
		ChromeOptions options = new ChromeOptions();
		
		HashedMap<String, Object> pref = new HashedMap<String, Object>();
		pref.put("profile.default_content_settings.popups", 0);
		pref.put("download.default_directory", folder.getAbsolutePath());
		options.setExperimentalOption("pref", pref);
		
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		
		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		// Start browser
		driver = new ChromeDriver();

		// Maximize browser
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/upload-download");
			
	}

	@Test
	public void testDownload()
	{
		driver.findElement(By.partialLinkText("Download")).click();
		File list[] = folder.listFiles();
		
		Assert.assertTrue(list.length>0);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		for(File file : folder.listFiles())
		{
			file.delete();
		}
		folder.delete();
	}
}
