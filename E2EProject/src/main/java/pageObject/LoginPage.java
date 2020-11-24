package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	By email=By.id("user_email");
	By pass= By.id("user_password");
	By LoginB= By.cssSelector("input[type='submit']");
	By AlertT =By.cssSelector("div[role='alert']");
	
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPass()
	{
		return driver.findElement(pass);
	}
	public WebElement LoginButton() {
		return driver.findElement(LoginB);
	}
	public void AlertText()
	{
		driver.findElement(AlertT).getText();
		
	}
	
}
