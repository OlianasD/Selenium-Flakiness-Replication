package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

public class UserSecurityPage extends EditUserPage {
	
	
	
	@FindBy(xpath = "//*[@id=\"security\"]/div[1]/a")
	protected WebElement changePasswordBtn;
	
	@FindBy(id = "jsnewPassword")
	protected WebElement newPassword;
	
	@FindBy(id = "jsconfirmPassword")
	protected WebElement confirmPassword;
	
	@FindBy(xpath = "//*[@id=\"jsform\"]/div[1]/div/button")
	protected WebElement saveBtn;
	
	@FindBy(id = "jsdisableUser")
	protected WebElement disableBtn;
	
	@FindBy(id = "jsdeleteUserAndDeleteContent")
	protected WebElement deleteBtn;


	public UserSecurityPage(WebDriver driver) {
		super(driver);
	}
	
	
	public UserSecurityPage changePassword() {
		wait.waitClickability(changePasswordBtn);
		changePasswordBtn.click();
		return new UserSecurityPage(driver);
	}
	
	public UserSecurityPage setPassword(String psw) {
		wait.waitClickability(newPassword);
		newPassword.sendKeys(psw);
		return this;
	}
	
	public UserSecurityPage confirmPassword(String psw) {
		wait.waitClickability(confirmPassword);
		confirmPassword.sendKeys(psw);
		return this;
	}
	
	public UsersPage save() {
		wait.waitClickability(saveBtn);
		saveBtn.click();
		return new UsersPage(driver);
	}
	
	public UsersPage disable() {
		wait.waitClickability(disableBtn);
		disableBtn.click();
		return new UsersPage(driver);
	}
	
	public UsersPage delete() {
		wait.waitClickability(deleteBtn);
		deleteBtn.click();
		return new UsersPage(driver);
	}
	
	
	

}
