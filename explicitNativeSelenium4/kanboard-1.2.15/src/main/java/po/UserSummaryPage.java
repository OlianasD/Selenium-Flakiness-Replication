package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

public class UserSummaryPage extends TopNavBar {
	
	@FindBy(xpath = "//*[@id=\"user-section\"]/div[2]/ul[1]/li[1]/strong")
	protected WebElement username;
	
	@FindBy(xpath = "//*[@id=\"user-section\"]/div[2]/ul[1]/li[2]/strong")
	protected WebElement fullName;
	
	@FindBy(xpath = "//*[@id=\"user-section\"]/div[2]/ul[1]/li[3]/strong")
	protected WebElement email;
	
	@FindBy(xpath = "//*[@id=\"user-section\"]/div[2]/ul[2]/li[3]/strong")
	protected WebElement accountType;
	
	@FindBy(linkText = "Edit profile")
	protected WebElement editProfile;

	public UserSummaryPage(WebDriver driver) {
		super(driver);
	}
	
	public String getUsername() {
		wait.waitVisibility(username);
		return username.getText();
	}
	
	public String getFullname() {
		wait.waitVisibility(fullName);
		return fullName.getText();
	}
	
	public String getEmail() {
		wait.waitVisibility(email);
		return email.getText();
	}
	
	public String getAccountType() {
		wait.waitVisibility(accountType);
		return accountType.getText();
	}
	
	public EditUserProfilePage editProfile() {
		wait.waitClickability(editProfile);
		editProfile.click();
		return new EditUserProfilePage(driver);
	}
	
}