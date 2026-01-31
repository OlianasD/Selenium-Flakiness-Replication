package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Wait;

public class ChangeCredentialsPage extends PageObject {
	
	@FindBy(name = "password")
	protected WebElement password;
	
	@FindBy(name = "retype")
	protected WebElement confirmPassword;
	
	@FindBy(id = "change_credentials_submit")
	protected WebElement changeBtn;

	protected Wait wait;

	public ChangeCredentialsPage(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public ChangeCredentialsPage clickUsername() {
		driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/dl/dd/a")).click();
		return new ChangeCredentialsPage(driver);
	}
	
	public ChangeCredentialsPage setPassword(String psw) {
		password.sendKeys(psw);
		return this;
	}
	
	public ChangeCredentialsPage confirmPassword(String psw) {
		confirmPassword.sendKeys(psw);
		return this;
	}
	
	public ChangeCredentialsPage change() {
		changeBtn.click();
		return new ChangeCredentialsPage(driver);
	}

	public boolean waitForSuccessMessageToBe(String expected) {
		return wait.waitForTextToBe(By.xpath("//*[@id=\"mw-content-text\"]/div[1]"), expected);
	}

	public boolean waitForErrorMessageToBe(String expected) {
		return wait.waitForTextToBe(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/form/div[1]/div[2]/div/span[2]"), expected);
	}
	
	
	
	

}
