package brokenlinks;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class VerifyBrokenLinksExample {

	public static void verifyLink(String linkurl) {
		try {
			URL url = new URL(linkurl);
			HttpsURLConnection httpURLConnect = (HttpsURLConnection) url.openConnection();
			httpURLConnect.setConnectTimeout(3000);
			httpURLConnect.connect();

			if (httpURLConnect.getResponseCode() == 200) {

				System.out.println(linkurl + " " + httpURLConnect.getResponseMessage());
			}
			if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {

				System.out.println(linkurl + " - " + httpURLConnect.getResponseMessage() + " - "
						+ HttpURLConnection.HTTP_NOT_FOUND);
			}

		} catch (Exception e) {
		}

	}

	@Test
	public void brokenLinksExample() throws InterruptedException {
		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Start application
		driver.get("https://www.google.com/webhp?client=firefox-b-d&safe=active");

		List<WebElement> links = driver.findElements(By.tagName("a"));
		List<String> urls = new ArrayList<String>();

		for (WebElement eachLink : links) {
			String link = eachLink.getAttribute("href");
			urls.add(link);
			verifyLink(link);
		}
		
		//to improve the performance of script
		urls.parallelStream().forEach(e->verifyLink(e));
		driver.quit();
	}
}
