package debugging;

import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ExecuteSeleniumScriptsOnAlreadyOpenedBrowser 

/*When we already have chrome browser running and we want to run test cases
 * on the exisitng browser.
 * 
 * Why it is reqd?
 * 1.If we are running test cases it having 100 steps on 98th its failing so if we dont use this approach 
 * then we fix the test case and run the whole test case again.
 * 
 * 2.We need to try the new methods on function or locator on the active session don't want to try
 * start new session. etc
 * 
 * https://www.youtube.com/watch?v=Rrkj4tdXngY
 * */
{ 
    @Test
	public void testDebuggin()
	{
    	// Code for launching the Chrome browser
    			System.setProperty("webdriver.chrome.driver",
    					"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.setExperimentalOption("debuggerAddress", "localhost:9988");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.google.com");
		
		 Capabilities cap = driver.getCapabilities();
		 Map<String, Object> map = cap.asMap();
		 System.out.println(map);
	}
}
