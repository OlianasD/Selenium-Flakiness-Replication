package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpecialPagesPage extends PageObject {
	
	@FindBy(linkText = "Create account")
	protected WebElement createAccount;
	
	@FindBy(linkText = "User rights")
	protected WebElement userRights;
	
	@FindBy(linkText = "Block user")
	protected WebElement blockUser;
	
	@FindBy(linkText = "Change credentials")
	protected WebElement changeCreds;
	

	public SpecialPagesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public CreateAccountPage createAccount() {
		createAccount.click();
		return new CreateAccountPage(driver);
	}
	
	public UserRightsPage userRights() {
		userRights.click();
		return new UserRightsPage(driver);
	}
	
	
	public BlockUserPage blockUser() {
		blockUser.click();
		return new BlockUserPage(driver);
	}
	
	public ChangeCredentialsPage changeCredentials() {
		changeCreds.click();
		return new ChangeCredentialsPage(driver);
	}
	
	
}
