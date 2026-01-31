package po;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Wait;

public class UserPage extends ClarolinePage {
	@FindBy(xpath="(//img[@alt='Unregister'])[2]")
	private WebElement unregisterButton;

	protected Wait wait;
	
	public UserPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
	}
	
	public UserPage removeEnrol() throws InterruptedException{
		wait.waitClickability(unregisterButton);
		unregisterButton.click();
		wait.waitAlert();
		Alert al = driver.switchTo().alert();
		al.accept();
		driver.navigate().refresh();
		return new UserPage(driver);
	}
}
