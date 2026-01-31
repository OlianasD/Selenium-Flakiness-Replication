package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoginPage extends TopNavBar {
	
	@FindBy(id = "email")
	protected WebElement email;
	
	@FindBy(id = "password")
	protected WebElement password;
	
	@FindBy(id = "loginForm")
	protected WebElement signInBtn;

	public AdminLoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
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
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	public String getDangerAlertText() {
		return driver.findElement(By.className("alert-danger")).getText();
	}
	
	
	
	

}
