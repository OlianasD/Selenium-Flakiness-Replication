package po;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage extends ClarolinePage {
	private WebDriver driver;
	@FindBy(xpath="(//img[@alt='Unregister'])[2]")
	private WebElement unregisterButton;
	
	public UserPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public UserPage removeEnrol() throws InterruptedException{
		unregisterButton.click();
		Alert al = driver.switchTo().alert();
		al.accept();
		driver.navigate().refresh();
		return new UserPage(driver);
	}
}
