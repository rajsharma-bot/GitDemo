package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportersNG {

	static ExtentReports extend;
	
	public static ExtentReports getReportObject()
	{
		// ExtendReports && ExtendSparkReporter
				String path=System.getProperty("user.dir")+"\\reports\\index.html";
				ExtentSparkReporter report = new ExtentSparkReporter(path);
				report.config().setReportName("Web Automation Reports");
				report.config().setDocumentTitle("Extend Report");
				extend =new  ExtentReports();
				extend.attachReporter(report);
				extend.setSystemInfo("Tester Name", "Raj Sharma");
				return extend;
				
	}
}
