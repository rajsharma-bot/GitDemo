package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	By signIn=By.cssSelector("a[href*=sign_in]");
	By Title=By.xpath("//div[@class='container']/div/h2");
	By Nav=By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getLogin()
	{
		return driver.findElement(signIn);
	}
	public WebElement getTitle()
	{
		return driver.findElement(Title);
	}
	public WebElement GetNavDetails()
	{
		return driver.findElement(Nav);
	}
	
}
