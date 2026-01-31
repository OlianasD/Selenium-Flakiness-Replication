package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.Wait;

public class AdvancedUserSearchPage {
	private WebDriver driver;
	@FindBy(id="lastName")
	private WebElement lastname;
	@FindBy(id="action")
	private WebElement rolename;
	@FindBy(css="input.claroButton")
	private WebElement searchButton;

	protected Wait wait;
		
	public AdvancedUserSearchPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
	}
	
	public AdminUsersPage search(String name, String role) throws InterruptedException{
		wait.waitClickability(lastname);
		lastname.sendKeys(name);
		wait.waitClickability(rolename);
		new Select(rolename).selectByVisibleText(role);
		wait.waitClickability(searchButton);
		searchButton.click();
		AdminUsersPage page = new AdminUsersPage(driver);
		return page;
	}
}
