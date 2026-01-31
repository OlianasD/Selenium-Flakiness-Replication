package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

public class EditProfilePage extends LoggedNavBar {
	
	@FindBy(id = "jform_name")
	protected WebElement name;
	
	@FindBy(id = "jform_password1")
	protected WebElement password;
	
	@FindBy(id = "jform_password2")
	protected WebElement confirmPassword;
	
	@FindBy(className = "btn-primary")
	protected WebElement submitBtn;
	
	protected Wait wait;
	
	public EditProfilePage(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public String getName() {
		wait.waitVisibility(name);
		return name.getAttribute("value");
	}
	
	public EditProfilePage setPassword(String psw) {
		wait.waitClickability(password);
		password.sendKeys(psw);
		return this;
	}
	
	public EditProfilePage confirmPassword(String psw) {
		wait.waitClickability(confirmPassword);
		confirmPassword.sendKeys(psw);
		return this;
	}
	
	public EditProfilePage submit() {
		wait.waitClickability(submitBtn);
		submitBtn.click();
		return this;
	}
	
	public String getAlertMessage() {
		wait.waitVisibility(By.className("alert-message"));
		return driver.findElement(By.className("alert-message")).getText();
	}
	
	
}
