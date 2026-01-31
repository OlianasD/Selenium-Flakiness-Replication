package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.Strings;
import utils.Wait;

public class NewAccountPage extends ManageNavBar {
	@FindBy(name = "username")
	public WebElement username;
	
	@FindBy(name ="realname")
	public WebElement realname;
	
	@FindBy(name = "email")
	public WebElement email;
	
	@FindBy(name = "access_level")
	public WebElement accessLevel;
	
	@FindBy(xpath = "//*[@id=\"manage-user-create-form\"]/div/div[3]/input")
	public WebElement createUserBtn;
	
	protected Wait wait;
	
	public NewAccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
	}
	
	public NewAccountPage setUsername(String usr) {
		wait.waitClickability(username);
		this.username.clear();
		this.username.sendKeys(usr);
		return this;
	}
	
	public NewAccountPage setRealname(String rn) {
		wait.waitClickability(realname);
		this.realname.clear();
		this.realname.sendKeys(rn);
		return this;
	}
	
	public NewAccountPage setEmail(String eml) {
		wait.waitClickability(email);
		this.email.clear();
		this.email.sendKeys(eml);
		return this;
	}
	
	public NewAccountPage setAccessLevel(String level) {
		wait.waitClickability(accessLevel);
		new Select(accessLevel).selectByVisibleText(level);
		return this;
	}
	
	public ManageUsersPage createUser() {
		wait.waitClickability(createUserBtn);
		createUserBtn.click();
		/*try {
			wait.waitClickabilityRefreshed(By.linkText(Strings.manageUsers)).click();
		} catch(WebDriverException e) {
			wait.waitClickabilityRefreshed(By.linkText(Strings.manageUsers)).click();
		}*/
		wait.waitClickabilityRefreshed(By.linkText(Strings.manageUsers)).click();
		return new ManageUsersPage(driver);
	}
	
	public NewAccountPage createUserFails() {
		wait.waitClickability(createUserBtn);
		createUserBtn.click();
		return new NewAccountPage(driver);
	}
	
	public String getError() {
		wait.waitVisibility(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/p[2]"));
		return driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/p[2]")).getText();
	}
	

}
