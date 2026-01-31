package po;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Wait;

public class AdminUsersPage extends ClarolinePage{
	@FindBy(xpath=".//*[@id='L0']")
	private WebElement lastName;
	@FindBy(xpath=".//*[@id='claroBody']/table[2]/tbody/tr/td[3]")
	private WebElement firstName;
	@FindBy(xpath=".//*[@id='claroBody']/table[2]/tbody/tr/td[6]")
	private WebElement role;
	@FindBy(css="img[alt='Delete']")
	private WebElement removeUserButton;
	@FindBy(linkText="No.")
	private WebElement orderLink;
	
	protected Wait wait;
	
	public AdminUsersPage(WebDriver driver){
		super(driver);
		wait = new Wait(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String getLastName(){
		wait.waitVisibility(lastName);
		return lastName.getText();
	}
	
	public String getFirstName(){
		wait.waitVisibility(firstName);
		return firstName.getText();
	}
	
	public String getRole(){
		wait.waitVisibility(role);
		return role.getText();
	}
	
	public AdminUsersPage removeUser() {
		wait.waitClickability(removeUserButton);
		removeUserButton.click();
		wait.waitAlert();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.navigate().refresh();
		return new AdminUsersPage(driver);
	}
	
	public String getLastNameI(int i){
		WebElement last = wait.waitVisibility(By.xpath(".//*[@id='L"+i+"']"));
		return last.getText();
	}
	
	public AdminUsersPage order() {
		wait.waitClickability(orderLink);
		orderLink.click();
		return this;
	}
	
	
}
