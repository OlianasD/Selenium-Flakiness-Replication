package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangeCredentialsPage extends PageObject {
	
	@FindBy(name = "password")
	protected WebElement password;
	
	@FindBy(name = "retype")
	protected WebElement confirmPassword;
	
	@FindBy(id = "change_credentials_submit")
	protected WebElement changeBtn;

	public ChangeCredentialsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
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
	
	public String getSuccessMessage() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]")).getText();
	}
	
	public String getErrorMessage() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/form/div[1]/div[2]/div/span[2]")).getText();
	}
	
	
	
	

}
