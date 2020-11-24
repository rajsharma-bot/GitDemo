package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;

public class HomePage extends base {
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializingDriver();
		log.info("Driver is initialze");
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		log.info("Navigated to Home page");
		l.getLogin().click();
		log.info("Sucessfully click on Login button");
		log.info("Sucessfully click on Login button");
	}

	@Test(dataProvider = "getData")
	public void baseNavigation(String email, String password, String text) throws IOException {

		LoginPage ld = new LoginPage(driver);
		ld.getEmail().sendKeys(email);
		ld.getPass().sendKeys(password);
		ld.LoginButton().click();
		log.info("Sucessfull click on login button ");
		// System.out.println(text);
		log.info(text);
		ld.AlertText();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		// Invalid user ID
		data[0][0] = "randam@xyz.com";
		data[0][1] = "1455778";
		data[0][2] = "Invalid ID";

		// valid Id
		data[1][0] = "test@test.com";
		data[1][1] = "1245454";
		data[1][2] = "Valid ID";

		return data;
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}
