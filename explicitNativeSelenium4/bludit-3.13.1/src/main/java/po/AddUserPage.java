package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.Wait;

public class AddUserPage extends AdminSidebar {
	
	@FindBy(id = "jsnew_username")
	protected WebElement username;
	
	@FindBy(id = "jsnew_password")
	protected WebElement password;
	
	@FindBy(id = "jsconfirm_password")
	protected WebElement confirmPassword;
	
	@FindBy(id = "jsemail")
	protected WebElement email;
	
	@FindBy(xpath ="//*[@id=\"jsform\"]/div[1]/div/button")
	protected WebElement saveBtn;

	
	public AddUserPage(WebDriver driver) {
		super(driver);
	}
	
	public AddUserPage setUsername(String usr) {
		wait.waitClickability(username);
		username.sendKeys(usr);
		return this;
	}
	
	public AddUserPage setPassword(String psw) {
		wait.waitClickability(password);
		password.sendKeys(psw);
		return this;
	}
	
	public AddUserPage confirmPassword(String psw) {
		wait.waitClickability(confirmPassword);
		confirmPassword.sendKeys(psw);
		return this;
	}
	
	public AddUserPage setEmail(String mail) {
		wait.waitClickability(email);
		email.sendKeys(mail);
		return this;
	}
	
	public AddUserPage setRole(String role) {
		wait.waitClickability(driver.findElement(By.id("jsrole")));
		new Select(driver.findElement(By.id("jsrole"))).selectByVisibleText(role);
		return this;
	}
	
	public UsersPage save() {
		wait.waitClickability(saveBtn);
		saveBtn.click();
		return new UsersPage(driver);
	}
	
	
	
	

}
