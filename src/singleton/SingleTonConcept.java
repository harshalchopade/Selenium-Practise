package singleton;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingleTonConcept {
	public static WebDriver driver = null;
	public static Logger log;
	
	public static void initialize()
	{
		if(driver == null)
		{
			if(ConstantList.browser.equalsIgnoreCase("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver",
						"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(ConstantList.browser.equalsIgnoreCase("FF"))
			{
				
			}
			
			log = Logger.getLogger(SingleTonConcept.class);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(ConstantList.url);
		}
	}
	
	public static void tearDown()
	{
		log.info("Quiting Browser");
		driver.quit();	
		driver = null;	
	}
	
	public static void close()
	{
		driver.close();
		log.info("Closing browser");
		driver = null;
	}
}
