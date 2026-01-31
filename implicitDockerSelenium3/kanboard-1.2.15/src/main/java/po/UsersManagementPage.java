package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersManagementPage extends TopNavBar {

	@FindBy(linkText = "New user")
	protected WebElement newUser;

	@FindBy(xpath = "/html/body/section/div[3]/div[2]/div[1]/div/a/strong/i")
	protected WebElement firstUserDropdown;

	@FindBy(linkText = "Remove")
	protected WebElement remove;

	@FindBy(xpath = "//*[@id=\"modal-confirm-button\"]")
	protected WebElement confirmRemoveBtn;

	public UsersManagementPage(WebDriver driver) {
		super(driver);
	}

	public NewUserPage newUser() {
		newUser.click();
		return new NewUserPage(driver);
	}

	public UsersManagementPage removeFirstUser() {
		firstUserDropdown.click();
		remove.click();
		confirmRemoveBtn.click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new UsersManagementPage(driver);
	}

	public boolean containsUser(String user) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return driver.findElement(By.tagName("body")).getText().contains(user);
	}

	public UserSummaryPage goToUser(String user) {
		driver.findElement(By.linkText(user)).click();
		return new UserSummaryPage(driver);
	}

}
