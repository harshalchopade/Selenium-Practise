package testNGlistenersdemo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/*
 * What is Listeners
 * 
 * Listeners are the very imp features of the TestNG which allows you to customized the
 * log or reports of TestNG.
 * As the name suggest it listens to certain  events and behave accordingly.
 * We can fully customized the logs using Listeners.
 * 
 * We use ITestListener in this demo.
 * 
 * Different ways to implement Listeners
 * 
 * Either we can extend TestListenerAdapter class
 * 
 * Implement interface ITestListener which has certain method we have implement
 * 
 * Implement
 * 1.We can implement on class level.
 * 2.We can implement on suite level.
 * */

public class TestNGListeners implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("Test case are started and details are "+result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case are successed and details are "+result.getName());

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test case are failed and details are "+result.getName());

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case are skipped and details are "+result.getName());
	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}

}
