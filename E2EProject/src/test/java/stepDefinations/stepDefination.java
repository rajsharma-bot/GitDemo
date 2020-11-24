package stepDefinations;



import org.junit.Assert;
import org.junit.runner.RunWith;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import cucumber.api.junit.Cucumber;
import pageObject.LandingPage;
import pageObject.LoginPage;
import pageObject.PortalHomePage;
import resources.base;



@RunWith(Cucumber.class)
public class stepDefination extends base {
	@Given("^Initialize the browser with firefox$")
	public void initialize_the_browser_with_firefox() throws Throwable {
		driver = initializingDriver();
	    
	}

	@Given("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_site(String arg1) throws Throwable {
		driver.get(arg1);
	}

	@Given("^click on login link on homepage to land on sign page$")
	public void click_on_login_link_on_homepage_to_land_on_sign_page() throws Throwable {
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();
	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and logs in$")
	public void user_enters_and_and_logs_in(String arg1, String arg2) throws Throwable {
		LoginPage ld = new LoginPage(driver);
		ld.getEmail().sendKeys(arg1);
		ld.getPass().sendKeys(arg1);
		ld.LoginButton().click();
	}

	@Then("^verify that user is succesfully logged in$")
	public void verify_that_user_is_succesfully_logged_in() throws Throwable {
		PortalHomePage p=new PortalHomePage(driver);
		Assert.assertTrue(p.GetSearch().isDisplayed());
		
	    
	}
	

	}

	    