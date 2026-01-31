package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogin extends PageObject {
	
	@FindBy(id = "jsusername")
	protected WebElement username;
	
	@FindBy(id = "jspassword")
	protected WebElement password;
	
	@FindBy(name = "save")
	protected WebElement loginBtn;
	
	@FindBy(id = "alert")
	protected WebElement alert;
	
	public AdminLogin(WebDriver driver) {
		super(driver);
	}
	
	public AdminLogin setUsername(String usr) {
		username.sendKeys(usr);
		return this;
	}
	
	public AdminLogin setPassword(String psw) {
		password.sendKeys(psw);
		return this;
	}
	
	public AdminHome login() {
		loginBtn.click();
		return new AdminHome(driver);
	}
	
	public AdminLogin badLogin() {
		loginBtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new AdminLogin(driver);
	}
	
	public boolean isAlertVisible() {
		return alert.isDisplayed();
	}
	
	public String getAlertText() {
		return alert.getText();
	}

}
