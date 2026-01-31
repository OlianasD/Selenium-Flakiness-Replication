package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageUsersPage extends ManageNavBar {
	
	//@FindBy(className = "button-small")
	@FindBy(xpath = "//*[@id=\"manage-user-div\"]/div[1]/a")
	public WebElement createUserBtn;
	
	public ManageUsersPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public NewAccountPage createNewUser() {
		createUserBtn.click();
		return new NewAccountPage(driver);
	}
	
	public String getUsername(int i) {
		return driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[4]/div[2]/div[2]/div/table/tbody/tr["+i+"]/td[1]/a")).getText();
	}
	
	public String getRealName(int i) {
		return driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[4]/div[2]/div[2]/div/table/tbody/tr["+i+"]/td[2]")).getText();
	}
	
	public String getEmail(int i) {
		return driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[4]/div[2]/div[2]/div/table/tbody/tr["+i+"]/td[3]")).getText();
	}
	
	public String getAccessLevel(int i) {
		return driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[4]/div[2]/div[2]/div/table/tbody/tr["+i+"]/td[4]")).getText();
	}
	
	public EditUserPage goToUser(String user) {
		driver.findElement(By.linkText(user)).click();
		return new EditUserPage(driver);
	}
	
	public boolean isUserPresent(String userName) {
		return driver.findElement(By.tagName("BODY")).getText().contains(userName);
	}
	
	
}
