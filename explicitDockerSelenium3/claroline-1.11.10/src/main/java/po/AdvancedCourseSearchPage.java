package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Wait;

public class AdvancedCourseSearchPage {
	private WebDriver driver;
	@FindBy(id="intitule")
	private WebElement title;
	@FindBy(id="subscription_allowed")
	private WebElement allowed;
	@FindBy(id="subscription_key")
	private WebElement password;
	@FindBy(id="subscription_denied")
	private WebElement denied;
	@FindBy(css="input.claroButton")
	private WebElement searchButton;

	protected Wait wait;
		
	public AdvancedCourseSearchPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
	}
	
	public AdminCoursesPage searchAllowed(String tit)  {
		wait.waitClickability(title);
		title.sendKeys(tit);
		wait.waitClickability(allowed);
		allowed.click();
		wait.waitClickability(searchButton);
		searchButton.click();
		AdminCoursesPage page = new AdminCoursesPage(driver);
		return page;
	}
	
	public AdminCoursesPage searchPassword(String tit) {
		wait.waitClickability(title);
		title.sendKeys(tit);
		wait.waitClickability(password);
		password.click();
		wait.waitClickability(searchButton);
		searchButton.click();
		AdminCoursesPage page = new AdminCoursesPage(driver);
		return page;
	}
	
	public AdminCoursesPage searchDenied(String tit) {
		wait.waitClickability(title);
		title.sendKeys(tit);
		wait.waitClickability(denied);
		denied.click();
		wait.waitClickability(searchButton);
		searchButton.click();
		AdminCoursesPage page = new AdminCoursesPage(driver);
		return page;
	}
}
