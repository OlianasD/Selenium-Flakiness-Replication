package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

public class AdminSidebar extends PageObject {
	
	@FindBy(linkText = "New content")
	protected WebElement newContent;

	
	@FindBy(linkText = "Users")
	protected WebElement users;
	
	@FindBy(linkText = "General")
	protected WebElement general;
	
	@FindBy(linkText = "Categories")
	protected WebElement categories;
	
	protected Wait wait;
	
	
	public AdminSidebar(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public NewContentPage newContent() {
		wait.waitClickability(newContent);
		newContent.click();
		return new NewContentPage(driver);
	}
	
	public ContentPage content() {
		WebElement cont = wait.waitClickability(By.linkText("Content"));
		cont.click();
		return new ContentPage(driver);
	}
	
	public UsersPage users() {
		wait.waitClickability(users);
		users.click();
		return new UsersPage(driver);
	}
	
	public GeneralSettingsPage general() {
		wait.waitClickability(general);
		general.click();
		return new GeneralSettingsPage(driver);
	}
	
	public CategoriesPage categories() {
		wait.waitClickability(categories);
		categories.click();
		return new CategoriesPage(driver);
	}

}
