package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends PageObject {
	
	@FindBy(id = "wpName2")
	protected WebElement username;
	
	@FindBy(id = "wpPassword2")
	protected WebElement password;
	
	@FindBy(id = "wpRetype")
	protected WebElement confirmPassword;
	
	@FindBy(id = "wpRealName")
	protected WebElement realName;
	
	@FindBy(id = "wpCreateaccount")
	protected WebElement createAccountBtn;
	
	
	public CreateAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public CreateAccountPage setUsername(String usr) {
		username.sendKeys(usr);
		return this;
	}
	
	public CreateAccountPage setPassword(String psw) {
		password.sendKeys(psw);
		return this;
	}
	
	public CreateAccountPage confirmPassword(String psw) {
		confirmPassword.sendKeys(psw);
		return this;
	}
	
	public CreateAccountPage setRealName(String rn) {
		realName.sendKeys(rn);
		return this;
	}
	
	public CreateAccountPage create() {
		createAccountBtn.click();
		return new CreateAccountPage(driver);
	}
	
	public String getSuccessMessage() {
		return driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/p[1]")).getText();
	}
	
	public String getUsernameValidationMessage() {
		return username.getAttribute("validationMessage");
	}
	
	

}
