package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewUserPage extends TopNavBar {

	@FindBy(id = "form-username")
	protected WebElement formUserName;

	@FindBy(id = "form-name")
	protected WebElement formName;

	@FindBy(id = "form-email")
	protected WebElement formEmail;

	@FindBy(id = "form-password")
	protected WebElement formPassword;

	@FindBy(id = "form-confirmation")
	protected WebElement formConfirm;

	@FindBy(xpath = "//*[@id=\"modal-content\"]/form/div[2]/div/button")
	protected WebElement saveBtn;

	@FindBy(xpath = "//*[@id=\"modal-content\"]/form/div[1]/div[1]/fieldset[2]/label[1]/input")
	protected WebElement remoteUser;

	@FindBy(xpath = "//*[@id=\"modal-content\"]/form/div[1]/div[1]/fieldset[1]/ul")
	protected WebElement nameError;

	@FindBy(xpath = "//*[@id=\"modal-content\"]/form/div[1]/div[1]/fieldset[2]/ul[1]")
	protected WebElement pswError;

	@FindBy(xpath = "//*[@id=\"modal-content\"]/form/div[1]/div[1]/fieldset[2]/ul[2]")
	protected WebElement pswConfirmError;

	public NewUserPage(WebDriver driver) {
		super(driver);
	}

	public NewUserPage setUsername(String usr) {
		formUserName.sendKeys(usr);
		return this;
	}

	public NewUserPage setFullname(String name) {
		formName.sendKeys(name);
		return this;
	}

	public NewUserPage setEmail(String mail) {
		formEmail.sendKeys(mail);
		return this;
	}

	public NewUserPage setPassword(String psw) {
		formPassword.sendKeys(psw);
		return this;
	}

	public NewUserPage confirmPassword(String psw) {
		formConfirm.sendKeys(psw);
		return this;
	}

	public NewUserPage setRemote() {
		remoteUser.click();
		return this;
	}

	public UserSummaryPage save() {
		saveBtn.click();
		return new UserSummaryPage(driver);
	}

	public NewUserPage saveError() {
		saveBtn.click();
		return new NewUserPage(driver);
	}

	public String getNameError() {
		return nameError.getText();
	}

	public String getPswError() {
		return pswError.getText();
	}

	public String getPswConfirmError() {
		return pswConfirmError.getText();
	}

}
