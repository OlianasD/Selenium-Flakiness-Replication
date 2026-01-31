package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SiteAdminHome extends PageObject {
	
	@FindBy(xpath = "//*[@id=\"cpanel-modules\"]/div/div/div[1]/div/div[2]/nav/ul/li[1]/ul/li[1]/a")
	protected WebElement usersLink;
	
	@FindBy(linkText = "Articles")
	protected WebElement articles;
	
	@FindBy(linkText = "Article Categories")
	protected WebElement categories;
	
	@FindBy(linkText = "Menus")
	protected WebElement menus;
	
	@FindBy(xpath = "//*[@id=\"menu12\"]/li[5]/a")
	protected WebElement sideUsers;
	
	@FindBy(xpath = "//*[@id=\"menu12\"]/li[2]/a")
	protected WebElement sideContent;
	
	public SiteAdminHome(WebDriver driver) {
		super(driver);
	}
	
	public ManageUsersPage users() {
		usersLink.click();
		return new ManageUsersPage(driver);
	}
	
	public ManageArticlesPage articles() {
		articles.click();
		return new ManageArticlesPage(driver);
	}
	
	public ManageCategoriesPage categories() {
		categories.click();
		return new ManageCategoriesPage(driver);
	}
	
	public MenuPage menus() {
		menus.click();
		return new MenuPage(driver);
	}
	
	public UsersSidebar sideUsers() {
		sideUsers.click();
		return new UsersSidebar(driver);
	}
	
	public ContentSidebar sideContent() {
		sideContent.click();
		return new ContentSidebar(driver);
	}
	
	
	
}
