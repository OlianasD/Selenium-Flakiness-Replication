package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

public class CustomerInfoPage extends MainNavBar {
	
	@FindBy(linkText = "Home")
	protected WebElement homeLink;
	
	protected Wait wait;
	
	public CustomerInfoPage(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public Home goHome() {
		wait.waitClickability(homeLink);
		homeLink.click();
		return new Home(driver);
	}

}
