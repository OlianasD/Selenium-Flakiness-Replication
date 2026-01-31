package po;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

public class LoggedNavBar extends BaseNavBar {
	
	@FindBy(linkText = "Site Administrator")
	protected WebElement siteAdmin;
	
	@FindBy(linkText = "Create a Post")
	protected WebElement createPost;
	
	@FindBy(linkText = "Log out")
	protected WebElement logout;
	
	protected Wait wait;
	
	public LoggedNavBar(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public SiteAdminLogin siteAdmin() {
		wait.waitClickability(siteAdmin);
		siteAdmin.click();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver = driver.switchTo().window(tabs2.get(1));
		return new SiteAdminLogin(driver);
	}
	
	public CreatePostPage createPost() {
		wait.waitClickability(createPost);
		createPost.click();
		return new CreatePostPage(driver);
	}
	
	public void adminLogout() {
		wait.waitClickability(logout);
		logout.click();
		wait.waitClickability(By.className("btn-primary")).click();
	}
	
	public void standardUserLogOut() {
		wait.waitClickability(authorLogin);
		authorLogin.click();
		wait.waitClickability(By.className("btn-primary")).click();
	}

}
