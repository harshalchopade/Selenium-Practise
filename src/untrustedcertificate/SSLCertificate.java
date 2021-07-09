package untrustedcertificate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.Test;

public class SSLCertificate {
	/*
	 * What is Untrusted SSL certificate? Whenever We try to access HTTPS website or
	 * application so many time you will face untrusted SSL certificate issue. This
	 * issue comes in all browser like IE, Chrome,Safari, Firefox etc.
	 * 
	 * 2- Why we get this certificate issues often? This certificates some in
	 * multiple conditions and we should know all of them so that we can rectify
	 * them easily.
	 * 
	 * 1- Each secure site has Certificate so its certificate is not valid
	 * up-to-date.
	 * 
	 * 2– Certificate has been expired on date
	 * 
	 * 3– Certificate is only valid for (site name)
	 *
	 * 4- The certificate is not trusted because the issuer certificate is unknown
	 * due to many reasons.
	 * 
	 * Handle Untrusted Certificate Selenium
	 * 
	 * Step 1-We have to create FirefoxProfile in Selenium.
	 * 
	 * Step 2- We have some predefined method in Selenium called
	 * setAcceptUntrustedCertificates() which accept Boolean values(true/false)- so
	 * we will make it true.
	 * 
	 * Step 3-Open Firefox browser with the above-created profile.
	 * 
	 * Since Firefox comes default browser in Selenium so for other browsers like
	 * Chrome, IE, Safari we have to use below technique.
	 */
	
	@Test
	public void HandleChromeOptions() throws InterruptedException {

		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		

		// For FF

		/*
		 * //It create firefox profile FirefoxProfile profile=new FirefoxProfile();
		 * 
		 * // This will set the true value profile.setAcceptUntrustedCertificates(true);
		 * 
		 * // This will open firefox browser using above created profile WebDriver
		 * driver=new FirefoxDriver(profile);
		 * 
		 * driver.get("pass the url as per your requirement");
		 */

		// For Chrome

		/*
		 * // Set ACCEPT_SSL_CERTS variable to true
		 * capabilites.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		 */

		// Open browser with capability
		WebDriver driver = new ChromeDriver(options);

		// Pass application URL
		driver.get("https://www.cacert.org/");
		
		driver.quit();
	}
}
