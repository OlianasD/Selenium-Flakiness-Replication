package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Wait;

public class LoginPage extends PageObject {

	@FindBy(id = "form-username")
	WebElement email;

	@FindBy(id = "form-password")
	WebElement password;

	@FindBy(xpath = "/html/body/div/form/div[1]/button")
	WebElement login;

	Wait wait;

	public LoginPage(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}

	public KanboardHomePage loginToKanboard(String username, String psw) {
		wait.waitClickability(email);
		email.sendKeys(username);
		wait.waitClickability(password);
		password.sendKeys(psw);
		wait.waitClickability(login);
		login.click();
		return new KanboardHomePage(driver);

	}

}
