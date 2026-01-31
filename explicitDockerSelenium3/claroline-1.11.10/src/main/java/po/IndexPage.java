package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Wait;

public class IndexPage {
	private WebDriver driver;
	@FindBy(id="login")
	private WebElement username;
	@FindBy(id="password")
	private WebElement password;
	@FindBy(css="button[type='submit']")
	private WebElement confirm;

	protected Wait wait;
	public IndexPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
	}
	
	public DesktopPage login(String user, String pass){
		wait.waitClickability(username);
		username.sendKeys(user);
		wait.waitClickability(password);
		password.sendKeys(pass);
		wait.waitClickability(confirm);
		confirm.click();
		DesktopPage page = new DesktopPage(driver);
		return page;
	}
	
	
	
}
