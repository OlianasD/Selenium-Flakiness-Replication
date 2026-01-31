package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersPage extends AdminSidebar {
	
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/a")
	protected WebElement addUser;
	
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/table/tbody/tr[2]/td[1]/a")
	protected WebElement secondUserName;
	
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/table/tbody/tr[2]/td[4]")
	protected WebElement secondUserAbilitation;
	
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/table/tbody/tr[1]/td[1]/a")
	protected WebElement firstUserName;
	
	public UsersPage(WebDriver driver) {
		super(driver);
	}
	
	public AddUserPage addUser() {
		addUser.click();
		return new AddUserPage(driver);
	}
	
	public String getSecondUserName() {
		return secondUserName.getText();
	}
	
	public EditUserPage editSecondUser() {
		secondUserName.click();
		return new EditUserPage(driver);
	}
	
	public EditUserPage editFirstUser() {
		firstUserName.click();
		return new EditUserPage(driver);
	}
	
	public String getSecondUserAbilitation() {
		return secondUserAbilitation.getText();
	}
	
	public boolean containsUser(String usr) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return driver.findElement(By.tagName("body")).getText().contains(usr);
	}
	
	

}
