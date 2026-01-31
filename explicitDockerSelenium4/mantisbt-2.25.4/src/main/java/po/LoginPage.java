package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Strings;
import utils.Wait;

public class LoginPage {
	
	public WebDriver driver;
	
	@FindBy(name = "username")
	public WebElement username;
	
	@FindBy(name = "password")
	public WebElement password;
	
	@FindBy(className = "btn")
	public WebElement loginBtn;
	
	protected Wait wait;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new Wait(driver);
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage setUsername(String usr) {
		wait.waitClickability(username);
		this.username.clear();
		this.username.sendKeys(usr);
		login();
		return this;
	}
	
	public LoginPage setPassword(String psw) {
		wait.waitClickability(password);
		this.password.clear();
		this.password.sendKeys(psw);
		return this;
	}
	
	public void login() {
		loginBtn.click();
	}
	
	public boolean isLoginFailed() {
		wait.waitVisibility(By.xpath("//*[@id=\"main-container\"]/div/div/div/div/div[4]/p"));
		return driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div/div/div/div[4]/p")).getText()
		.contains(Strings.loginFailedError);
	}
	
	public boolean isLoginBtnDisplayed() {
		return loginBtn.isDisplayed();
	}
}
