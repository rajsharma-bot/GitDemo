package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;

public class Navigation extends base {

	public WebDriver driver;
	private static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializingDriver();
		driver.get(prop.getProperty("url"));
		System.out.println("Testing GIT");
		for(int i=0;i<5;i++)
		{
			System.out.println(i);
		}
		System.out.println("testing 2");
	}

	@Test
	public void baseNavigation() throws IOException {
		LandingPage l = new LandingPage(driver);
		log.info("checking whether element is avaiable or not");
		Assert.assertTrue(l.GetNavDetails().isDisplayed());

	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}