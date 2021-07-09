package TestRunner;

import org.testng.TestNG;

import downloadfile.FileDownload;

public class TestRunner {
	//It will be useful we dont want to user testng.xml file
	//With the help of this we can mention any number of classes here and run it.
	//Also we can create jar of this class and run the test cases by clicking on created jar
	//We can also run that jar from cmd
	public static TestNG testng;

	public static void main(String[] args) {
		
		testng= new TestNG();
		testng.setTestClasses(new Class[] {FileDownload.class});
		testng.run();

	}

}
