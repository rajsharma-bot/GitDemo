package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PortalHomePage {

	public WebDriver driver;
	By SearchBox =By.name("query");
	
	
	public PortalHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
	}
	
	public WebElement GetSearch() {
		// TODO Auto-generated constructor stub
		return driver.findElement(SearchBox);
		
	}
}
