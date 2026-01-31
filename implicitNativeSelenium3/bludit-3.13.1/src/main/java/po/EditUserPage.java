package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditUserPage extends AdminSidebar {
	
	@FindBy(id = "nav-security-tab")
	protected WebElement securityTab;
	
	@FindBy(id = "nav-social-tab")
	protected WebElement socials;

	public EditUserPage(WebDriver driver) {
		super(driver);
	}
	
	public UserSecurityPage security() {
		securityTab.click();
		return new UserSecurityPage(driver);
	}
	
	public SocialNetworksPage socials() {
		socials.click();
		return new SocialNetworksPage(driver);
	}

}
