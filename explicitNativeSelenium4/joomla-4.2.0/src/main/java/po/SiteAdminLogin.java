package po;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

public class SiteAdminLogin extends PageObject {
	
	@FindBy(id = "mod-login-username")
	protected WebElement username;
	
	@FindBy(id = "mod-login-password")
	protected WebElement password;
	
	@FindBy(id = "btn-login-submit")
	protected WebElement loginBtn;
	
	@FindBy(className = "alert-message")
	protected WebElement alertMsg;
	
	@FindBy(xpath = "//*[@id=\"form-login\"]/fieldset/div[1]/label/span")
	protected WebElement emptyLoginAlert;
	
	@FindBy(xpath = "//*[@id=\"form-login\"]/fieldset/div[2]/label/span")
	protected WebElement emptyPasswordAlert;
	
	protected Wait wait;
	
	public SiteAdminLogin(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public SiteAdminLogin setUsername(String usr) {
		wait.waitClickability(username);
		username.clear();
		username.sendKeys(usr);
		return this;
	}
	
	public SiteAdminLogin setPassword(String psw) {
		wait.waitClickability(password);
		password.clear();
		password.sendKeys(psw);
		return this;
	}
	
	public SiteAdminHome login() {
		wait.waitClickability(loginBtn);
		loginBtn.click();
		return new SiteAdminHome(driver);
	}
	
	public SiteAdminLogin badLogin() {
		wait.waitClickability(loginBtn);
		loginBtn.click();
		return new SiteAdminLogin(driver);
	}
	
	public String getAlertMessage() {
		wait.waitVisibility(alertMsg);
		return alertMsg.getText();
	}
	
	public String getEmptyLoginAlert() {
		wait.waitVisibility(emptyLoginAlert);
		return emptyLoginAlert.getText();
	}
	
	public String getEmptyPasswordAlert() {
		wait.waitVisibility(emptyPasswordAlert);
		return emptyPasswordAlert.getText();
	}
	
	
	
}
