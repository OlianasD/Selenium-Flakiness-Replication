package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorLoginPage extends BaseNavBar {
	
	@FindBy(id="username")
	protected WebElement username;
	
	@FindBy(id="password")
	protected WebElement password;
	
	@FindBy(className = "btn-primary")
	protected WebElement loginBtn;
	
	@FindBy(className = "alert-message")
	protected WebElement alertMsg;
	
	@FindBy(xpath = "//*[@id=\"username-lbl\"]/span[2]")
	protected WebElement emptyLoginAlert;
	
	public AuthorLoginPage(WebDriver driver) {
		super(driver);
	}
	
	public AuthorLoginPage setUsername(String usr) {
		wait.waitClickability(username);
		username.clear();
		username.sendKeys(usr);
		return this;
	}
	
	public AuthorLoginPage setPassword(String psw) {
		wait.waitClickability(password);
		password.clear();
		password.sendKeys(psw);
		return this;
	}
	
	public ProfilePageInfo login() {
		wait.waitClickability(loginBtn);
		loginBtn.click();
		return new ProfilePageInfo(driver);
	}
	
	public AuthorLoginPage badLogin() {
		wait.waitClickability(loginBtn);
		loginBtn.click();
		return new AuthorLoginPage(driver);
	}
	
	public String getAlertMessage() {
		wait.waitVisibility(alertMsg);
		return alertMsg.getText();
	}
	
	public String getEmptyLoginAlert() {
		wait.waitVisibility(emptyLoginAlert);
		return emptyLoginAlert.getText();
	}

}
