package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

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
		wait.waitClickability(newUser);
		newUser.click();
		return new NewUserPage(driver);
	}

	public UsersManagementPage removeFirstUser() {
		wait.waitClickability(firstUserDropdown);
		firstUserDropdown.click();
		wait.waitClickability(remove);
		remove.click();
		wait.waitClickability(confirmRemoveBtn);
		confirmRemoveBtn.click();
		return new UsersManagementPage(driver);
	}

	
	public boolean firstUserIsNot(String user) {
		By locator = By.xpath("/html/body/section/div[3]/div[2]/div[1]/span/a");
		wait.waitStalenessRefreshed(driver.findElement(locator));
		/*try {
			wait.waitStalenessRefreshed(driver.findElement(locator));
		} catch(WebDriverException e) {
			System.out.println("!!WebDriver exception caught in UsersManagementPage.firstUserIsNot");
		}*/
		return wait.waitForTextToDisappear(locator, user);
	}

	public UserSummaryPage goToUser(String user) {
		wait.waitClickability(By.linkText(user)).click();
		return new UserSummaryPage(driver);
	}

}
