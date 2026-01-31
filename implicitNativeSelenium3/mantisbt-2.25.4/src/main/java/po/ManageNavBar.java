package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Strings;

public class ManageNavBar extends BaseNavBar {
	
	@FindBy(linkText = Strings.manageUsers)
	protected WebElement manageUsers;
	
	@FindBy(linkText = Strings.manageProjects)
	protected WebElement manageProjects;
	
	public ManageNavBar(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public ManageUsersPage manageUsers() {
		manageUsers.click();
		return new ManageUsersPage(driver);
	}
	
	public ManageProjectPage manageProjects() {
		manageProjects.click();
		return new ManageProjectPage(driver);
	}

}