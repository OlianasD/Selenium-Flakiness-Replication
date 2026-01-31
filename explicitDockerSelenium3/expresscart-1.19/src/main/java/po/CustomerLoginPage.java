package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Wait;

public class CustomerLoginPage extends PageObject {
	
	@FindBy(id = "email")
	protected WebElement email;
	
	@FindBy(id = "password")
	protected WebElement password;
	
	@FindBy(id = "customerloginForm")
	protected WebElement loginBtn;

	protected Wait wait;

	public CustomerLoginPage(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public CustomerLoginPage setEmail(String mail) {
		wait.waitClickability(email);
		email.sendKeys(mail);
		return this;
	}
	
	public CustomerLoginPage setPassword(String psw) {
		wait.waitClickability(password);
		password.sendKeys(psw);
		return this;
	}
	
	public CustomerInfoPage login() {
		wait.waitClickability(loginBtn);
		loginBtn.click();
		return new CustomerInfoPage(driver);
	}
	
	

}
