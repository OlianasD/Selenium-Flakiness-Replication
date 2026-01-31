package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrestaLogin {
	protected WebDriver driver;

	@FindBy(name = "email")
	protected WebElement email;

	@FindBy(name = "passwd")
	protected WebElement password;

	@FindBy(name = "submitLogin")
	protected WebElement login;

	public PrestaLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public AdminPage loginToPresta(String username, String psw) {
		email.sendKeys(username);
		password.sendKeys(psw);
		login.click();
		return new AdminPage(driver);

	}
}