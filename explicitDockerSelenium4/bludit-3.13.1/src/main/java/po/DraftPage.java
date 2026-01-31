package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DraftPage extends AdminSidebar {

	public DraftPage(WebDriver driver) {
		super(driver);
	}
	
	public String getFirstDraftTitle(String title) {
		wait.waitVisibility(By.linkText(title));
		return driver.findElement(By.linkText(title)).getText();
	}

}
