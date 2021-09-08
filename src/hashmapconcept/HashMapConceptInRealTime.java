package hashmapconcept;
import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HashMapConceptInRealTime {
	/*Real time use of HashMap*/
	
	 public static WebDriver driver;

	public static HashMap<String, String> getCredentials() {
		HashMap<String, String> userDetails = new HashMap<String, String>();
		userDetails.put("user1", "harshal@test123");
		userDetails.put("user2", "pankaj@test555");

		return userDetails;
	}

	public static String getUserID(String user)
	{
		String userID = getCredentials().get(user);
		return userID.split("@")[0];
	}
	
	public static String getPassword(String user)
	{
		String pwd = getCredentials().get(user);
		return pwd.split("@")[1];
	}
	
	public static void main(String[] args) {
		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D://Software Setup//Selenium - Java//chromedriver_win32//chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys(getUserID("user1"));
		driver.findElement(By.id("password")).sendKeys(getUserID("user1"));
	}
}
