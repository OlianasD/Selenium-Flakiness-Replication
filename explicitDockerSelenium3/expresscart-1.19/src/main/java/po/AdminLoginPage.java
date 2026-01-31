package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

public class AdminLoginPage extends TopNavBar {
	
	@FindBy(id = "email")
	protected WebElement email;
	
	@FindBy(id = "password")
	protected WebElement password;
	
	@FindBy(id = "loginForm")
	protected WebElement signInBtn;
	
	@FindBy(className = "alert-danger")
	protected WebElement alert;
	
	protected Wait wait;

	public AdminLoginPage(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public AdminLoginPage setEmail(String mail) {
		email.sendKeys(mail);
		return this;
	}
	
	public AdminLoginPage setPassword(String psw) {
		password.sendKeys(psw);
		return this;
	}
	
	public AdminDashboardPage doLogin() {
		signInBtn.click();
		return new AdminDashboardPage(driver);
	}
	
	public AdminLoginPage doBadLogin() {
		signInBtn.click();
		return this;
	}
	
	public String getDangerAlertText() {
		wait.waitVisibility(alert);
		return alert.getText();
	}
	
	
	
	

}
