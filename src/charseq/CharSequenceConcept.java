package charseq;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CharSequenceConcept {
	//We can pass multiple string to sendKeys()
	
public static void main(String[] args) {
	
	 //Code for launching the Chrome browser
	  System.setProperty("webdriver.chrome.driver",
			  "D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver(); 
	  driver.manage().window().maximize();
	  driver.get("https://demoqa.com/select-menu"); 
	  WebElement uname = driver.findElement(By.id("userName"));
	  
	  //1.using String
	  uname.sendKeys("harshal");
	  
	  //2.using StringBuilder
	  StringBuilder sb = new StringBuilder()
			  .append("harshal")
			  .append("test")
			  .append(" ")
			  .append("automation");
	  uname.sendKeys(sb);
	  
	//3.using StringBuffer
	  StringBuffer sb1 = new StringBuffer()
			  .append("harshal")
			  .append("test")
			  .append(" ")
			  .append("automation");
	  uname.sendKeys(sb1);
	  
		
	  uname.sendKeys("harshal", sb, sb1, Keys.TAB);
}

}
