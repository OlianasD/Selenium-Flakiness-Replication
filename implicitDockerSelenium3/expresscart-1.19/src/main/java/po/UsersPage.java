package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersPage extends AdminSidebar {
	
	@FindBy(xpath ="//*[@id=\"container\"]/div/main/div[2]/ul/li[3]")
	protected WebElement thirdUserText;
	
	@FindBy(xpath = "/html/body/div[2]/div/main/div[2]/ul/li[3]/span/a[2]")
	protected WebElement thirdUserDelBtn;
	

	public UsersPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String getThirdUserText() {
		return thirdUserText.getText();
	}
	
	public UsersPage deleteThirdUser() {
		thirdUserDelBtn.click();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		return this;
	}
	
	public boolean containsUser(String mail) {
		return driver.findElement(By.tagName("body")).getText().contains(mail);
	}

}
