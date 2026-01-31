package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Wait;

public class BaseNavBar {
	
	public WebDriver driver;
	
	@FindBy(linkText = "Author Login")
	protected WebElement authorLogin;
	
	protected Wait wait;
	
	public BaseNavBar(WebDriver driver) {
		this.driver = driver;
		wait = new Wait(driver);
		PageFactory.initElements(driver, this);
	}
	
	public AuthorLoginPage authorLogin() {
		wait.waitClickability(authorLogin);
		authorLogin.click();
		return new AuthorLoginPage(driver);
	}
	
	public LoggedHome home() {
		/*try {
			wait.waitClickability(By.linkText("Home")).click();
		} catch(WebDriverException e) {
			System.out.println("!!WebDriverException caught in BaseNavBar.home");
			wait.waitClickability(By.linkText("Home")).click();
		}*/
		wait.waitClickability(By.linkText("Home")).click();
		return new LoggedHome(driver);
	}
	
}
