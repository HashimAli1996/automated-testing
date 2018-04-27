package testingProject.testingProjectArtifact;

import java.io.File;

import org.junit.After;
import org.junit.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporting {
	
	ExtentReports extent;
	ExtentTest test;
	
	File currentDir = new File("");

	
	@Test
	public void method1() {
		
		extent = new ExtentReports(currentDir.getAbsolutePath()+ "/htmltest.html",  true);
	
		test = extent.startTest("Verify Application title");
		
		test.log(LogStatus.INFO, "Browser Started");
		
		test.log(LogStatus.PASS, "verify status of title page");
		
	}
	
	
	@After
	public void after() {
		
		extent.endTest(test);		
		extent.flush();
	}
}
