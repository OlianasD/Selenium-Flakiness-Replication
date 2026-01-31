package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

	@FindBy(id = "form-username")
	WebElement email;

	@FindBy(id = "form-password")
	WebElement password;

	@FindBy(xpath = "/html/body/div/form/div[1]/button")
	WebElement login;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public KanboardHomePage loginToKanboard(String username, String psw) {
		email.sendKeys(username);
		password.sendKeys(psw);
		login.click();
		return new KanboardHomePage(driver);

	}

}
