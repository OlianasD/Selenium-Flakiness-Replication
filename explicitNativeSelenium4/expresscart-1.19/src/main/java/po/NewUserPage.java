package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewUserPage extends AdminSidebar {
	
	@FindBy(id= "usersName")
	public WebElement userName;
	
	@FindBy(id= "userEmail")
	public WebElement email;
	
	@FindBy(id= "userPassword")
	public WebElement password;
	
	@FindBy(id = "btnUserAdd")
	public WebElement addBtn;
	
	@FindBy(xpath = "//*[@id=\"userNewForm\"]/div[1]")
	public WebElement userNameError;
	
	@FindBy(xpath = "//*[@id=\"userNewForm\"]/div[2]")
	public WebElement emailError;
	
	@FindBy(xpath = "//*[@id=\"userNewForm\"]/div[3]")
	public WebElement passwordError;
	
	@FindBy(xpath = "//*[@id=\"userNewForm\"]/div[4]")
	public WebElement passwordConfirmError;

	public NewUserPage(WebDriver driver) {
		super(driver);
	}

	public NewUserPage setUsername(String name) {
		wait.waitClickability(userName);
		userName.sendKeys(name);
		return this;
	}
	
	public NewUserPage setEmail(String mail) {
		wait.waitClickability(email);
		email.sendKeys(mail);
		return this;
	}
	
	public NewUserPage setPassword(String psw) {
		wait.waitClickability(password);
		password.sendKeys(psw);
		return this;
	}
	
	public NewUserPage setConfirmPassword(String psw) {
		wait.waitClickability(By.xpath("//*[@id=\"userNewForm\"]/div[4]/input")).sendKeys(psw);
		return this;
	}
	
	public AdminSidebar addUser() {
		wait.waitClickability(addBtn);
		addBtn.click();
		return new AdminSidebar(driver);
	}
	
	public NewUserPage addUserError() {
		wait.waitClickability(addBtn);
		addBtn.click();
		return new NewUserPage(driver);
	}
	
	public boolean usernameFieldHasError() {
		wait.waitVisibility(userNameError);
		return userNameError.getAttribute("class").contains("has-error has-danger");
	}
	
	public boolean emailFieldHasError() {
		wait.waitVisibility(emailError);
		return emailError.getAttribute("class").contains("has-error has-danger");
	}
	
	public boolean passwordFieldHasError() {
		wait.waitVisibility(passwordError);
		return passwordError.getAttribute("class").contains("has-error has-danger");
	}
	
	public boolean passwordConfirmFieldHasError() {
		wait.waitVisibility(passwordConfirmError);
		return passwordConfirmError.getAttribute("class").contains("has-error has-danger");
	}
}
