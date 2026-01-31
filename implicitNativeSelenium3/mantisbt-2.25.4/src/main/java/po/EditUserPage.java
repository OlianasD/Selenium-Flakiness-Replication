package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Strings;

public class EditUserPage extends ManageNavBar {
	
	@FindBy(id="edit-realname")
	protected WebElement realName;
	
	@FindBy(id = "edit-username")
	protected WebElement username;
	
	@FindBy(xpath = "//*[@id=\"edit-user-form\"]/div/div[2]/div[2]/input")
	protected WebElement updateUserBtn;
	
	@FindBy(xpath = "//*[@id=\"manage-user-delete-form\"]/fieldset/span/input")
	protected WebElement deleteUserBtn;
	
	public EditUserPage(WebDriver driver) {
		super(driver);
	}
	
	public EditUserPage setRealName(String name) {
		realName.clear();
		realName.sendKeys(name);
		return this;
	}
	
	public EditUserPage setUsername(String usr) {
		username.clear();
		username.sendKeys(usr);
		return this;
	}
	
	public String getRealName() {
		return driver.findElement(By.id("edit-realname")).getAttribute("value");
	}
	
	public EditUserPage updateUser() {
		updateUserBtn.click();
		driver.findElement(By.linkText(Strings.contin)).click();
		return new EditUserPage(driver);
	}
	
	public EditUserPage updateUserFails() {
		updateUserBtn.click();
		return new EditUserPage(driver);
	}
	
	public String getError() {
		return driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/p[2]")).getText();
	}
	
	public DeleteUserConfirmPage deleteUser() {
		deleteUserBtn.click();
		return new DeleteUserConfirmPage(driver);
	}
	
}