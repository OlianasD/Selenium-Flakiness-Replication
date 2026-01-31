package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

public class AdminLogin extends PageObject {
	
	@FindBy(id = "jsusername")
	protected WebElement username;
	
	@FindBy(id = "jspassword")
	protected WebElement password;
	
	@FindBy(name = "save")
	protected WebElement loginBtn;
	
	protected Wait wait;
	
	public AdminLogin(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public AdminLogin setUsername(String usr) {
		wait.waitClickability(username);
		username.sendKeys(usr);
		return this;
	}
	
	public AdminLogin setPassword(String psw) {
		wait.waitClickability(password);
		password.sendKeys(psw);
		return this;
	}
	
	public AdminHome login() {
		wait.waitClickability(loginBtn);
		loginBtn.click();
		return new AdminHome(driver);
	}
	
	public AdminLogin badLogin() {
		wait.waitClickability(loginBtn);
		loginBtn.click();
		return new AdminLogin(driver);
	}
	
	public boolean isAlertVisible() {
		return wait.waitClickabilityRefreshed(By.id("alert")).isDisplayed();
	}
	
	public String getAlertText() {
		wait.waitVisibility(driver.findElement(By.id("alert")));
		return driver.findElement(By.id("alert")).getText();
	}

}
