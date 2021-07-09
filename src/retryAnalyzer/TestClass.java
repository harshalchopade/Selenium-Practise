package retryAnalyzer;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass {
	
	@Test(retryAnalyzer = retryAnalyzer.RetryAnalyzer.class)
	public void test1()
	{
		Assert.assertEquals(false, true);
	}
	
	@Test
	public void test2()
	{
		Assert.assertEquals(false, true);
	}
}
