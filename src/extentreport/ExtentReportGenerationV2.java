package extentreport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import library.Utility;

public class ExtentReportGenerationV2 
{
	ExtentReports report;
	ExtentTest logger; 
	WebDriver driver;
	
	@Test
	public void verifyBlogTitle()
	{
	report=new ExtentReports("C:\\Users\\hchopade\\eclipse-workspace\\SeleniumTutorials\\Reports\\LearnAutomation.html");
	 
	logger=report.startTest("VerifyBlogTitle");
	
	System.setProperty("webdriver.chrome.driver",
			"D:\\Software Setup\\Selenium - Java\\chromedriver_win32\\chromedriver.exe");
	 
	driver=new ChromeDriver();
	 
	driver.manage().window().maximize();
	 
	logger.log(LogStatus.INFO, "Browser started ");
	 
	driver.get("http://www.learn-automation.com");
	 
	logger.log(LogStatus.INFO, "Application is up and running");
	 
	String title=driver.getTitle();
	 
	Assert.assertTrue(title.contains("Google")); 
	 
	logger.log(LogStatus.PASS, "Title verified");
	
	driver.quit();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
	if(result.getStatus()==ITestResult.FAILURE)
	{
	 
	String screenshot_path=Utility.captureScreenshots(driver, result.getName());
	String image= logger.addScreenCapture(screenshot_path);
	logger.log(LogStatus.FAIL, "Title verification", image);
	}
	 
	report.endTest(logger);
	report.flush();
	 
	driver.get("C:\\Users\\hchopade\\eclipse-workspace\\SeleniumTutorials\\Reports\\LearnAutomation.html");
	}
}
