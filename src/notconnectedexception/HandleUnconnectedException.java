package notconnectedexception;

import org.testng.annotations.Test;

public class HandleUnconnectedException {
	/*
	 * NotConnectedException - Unable to connect host 127.0.0.1 exception
	 * This issue occurs only for FF browser
	 * 
	 * To avoid this issue try below mentioned steps
	 * Use Selenium Latest  Jars.
	 * Use FF stable release.
	 * */
	@Test
	public void HandleChromeOptions() throws InterruptedException {

		// Code for launching the Chrome browser
		System.setProperty("webdriver.chrome.driver",
				"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");
	}

}
