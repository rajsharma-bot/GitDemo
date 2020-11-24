package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializingDriver() throws IOException
	{
		 prop =new Properties();
		FileInputStream fis= new FileInputStream("C:\\Users\\rajsh\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		
	prop.load(fis);
	String BrowserName=prop.getProperty("Browser");
	if(BrowserName.equals("chrome"))
	{
		
		driver=new ChromeDriver();
		
	}
	else if(BrowserName.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\rajsh\\Downloads\\BrowserDrivers\\geckodriver.exe");
		 driver=new FirefoxDriver();
	}
	else if(BrowserName.equals("IE"))
	{
		System.setProperty("webdriver.ie.driver", "C:\\Users\\rajsh\\Downloads\\BrowserDrivers\\IEDriverServer.exe");
		 driver=new InternetExplorerDriver();
	}
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
	}
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;

}
}
