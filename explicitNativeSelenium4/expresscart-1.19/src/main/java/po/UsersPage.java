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
	}
	
	public String getThirdUserText() {
		wait.waitVisibility(thirdUserText);
		return thirdUserText.getText();
	}

	public boolean waitForThirdUserTextToBe(String expected) {
		return wait.waitForTextToBe(By.xpath("//*[@id=\"container\"]/div/main/div[2]/ul/li[3]"), expected);
	}
	
	public UsersPage deleteThirdUser() {
		wait.waitClickability(thirdUserDelBtn);
		thirdUserDelBtn.click();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		return this;
	}
	
	public boolean containsUser(String mail) {
		return driver.findElement(By.tagName("body")).getText().contains(mail);
	}

}
