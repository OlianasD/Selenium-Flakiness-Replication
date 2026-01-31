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
		// TODO Auto-generated constructor stub
	}

	public NewUserPage setUsername(String name) {
		userName.sendKeys(name);
		return this;
	}
	
	public NewUserPage setEmail(String mail) {
		email.sendKeys(mail);
		return this;
	}
	
	public NewUserPage setPassword(String psw) {
		password.sendKeys(psw);
		return this;
	}
	
	public NewUserPage setConfirmPassword(String psw) {
		driver.findElement(By.xpath("//*[@id=\"userNewForm\"]/div[4]/input")).sendKeys(psw);
		return this;
	}
	
	public AdminSidebar addUser() {
		addBtn.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new AdminSidebar(driver);
	}
	
	public NewUserPage addUserError() {
		addBtn.click();
		return new NewUserPage(driver);
	}
	
	public boolean usernameFieldHasError() {
		return userNameError.getAttribute("class").contains("has-error has-danger");
	}
	
	public boolean emailFieldHasError() {
		return emailError.getAttribute("class").contains("has-error has-danger");
	}
	
	public boolean passwordFieldHasError() {
		return passwordError.getAttribute("class").contains("has-error has-danger");
	}
	
	public boolean passwordConfirmFieldHasError() {
		return passwordConfirmError.getAttribute("class").contains("has-error has-danger");
	}
}
