package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {
	
	@FindBy(id = "wpName1")
	protected WebElement username;
	
	@FindBy(id = "wpPassword1")
	protected WebElement password;
	
	@FindBy(id = "wpLoginAttempt")
	protected WebElement loginBtn;

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public LoginPage setUsername(String usr) {
		username.clear();
		username.sendKeys(usr);
		return this;
	}
	
	public LoginPage setPassword(String psw) {
		password.clear();
		password.sendKeys(psw);
		return this;
	}
	
	public MainPage login() {
		loginBtn.click();
		return new MainPage(driver);
	}

}
