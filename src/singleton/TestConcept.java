package singleton;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestConcept {
	
	@BeforeMethod
	public void setUp()
	{
		SingleTonConcept.initialize();
	}
	
	@Test
	public void getGoogleTitle()
	{
		String title = SingleTonConcept.driver.getTitle();
		String expectedTitle = "Google";
		Assert.assertEquals(title, expectedTitle);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		SingleTonConcept.tearDown();	
	}
	

}
