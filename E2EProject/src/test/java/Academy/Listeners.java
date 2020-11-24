package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtendReportersNG;
import resources.base;

public class Listeners extends base implements ITestListener {

	ExtentReports extend=ExtendReportersNG.getReportObject();
	ExtentTest test ;
	ThreadLocal<ExtentTest> extendTest= new ThreadLocal<ExtentTest>();
	
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=extend.createTest(result.getMethod().getMethodName());
		extendTest.set(test);
	}

	
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extendTest.get().log(Status.PASS, "Test Passed");
	}


	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extendTest.get().fail(result.getThrowable());
		WebDriver driver = null;
		String testMethodName = result.getMethod().getMethodName();
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {

		}

		try {
			extendTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver), result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extend.flush();
	}
	

}
