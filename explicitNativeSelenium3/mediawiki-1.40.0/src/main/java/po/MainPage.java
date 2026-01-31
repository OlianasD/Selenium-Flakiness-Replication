package po;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

public class MainPage extends PageObject {
	
	@FindBy(linkText = "Log in")
	protected WebElement login;
	
	@FindBy(linkText = "Create account")
	protected WebElement createAccount;

	protected Wait wait;
	

	public MainPage(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public CreateAccountPage createAccount() {
		createAccount.click();
		return new CreateAccountPage(driver);
	}
	
	public SpecialPagesPage specialPages() {
		wait.waitClickability(By.linkText("Special pages")).click();
		return new SpecialPagesPage(driver);
	}
	
	public LoginPage login() {
		login.click();
		return new LoginPage(driver);
	}
	
	public SearchResultsPage searchNonExisting(String query) {
		WebElement searchBar = wait.waitClickabilityRefreshed(By.id("searchInput"));
		searchBar.sendKeys(query);
		searchBar.sendKeys(Keys.ENTER);
		return new SearchResultsPage(driver, query);
	}
	
	public WikiPage searchExisting(String query) {
		WebElement searchBar = wait.waitClickabilityRefreshed(By.id("searchInput"));
		searchBar.sendKeys(query);
		wait.waitClickability(By.className("highlight"));
		searchBar.sendKeys(Keys.ENTER);
		return new WikiPage(driver);
	}
	
	public WikiPage goToUserPage(String user) {
		wait.waitClickability(By.linkText(user)).click();
		return new WikiPage(driver);
	}
	
	

}
