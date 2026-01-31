package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementManagementPage extends AdminSidebar {
	
	@FindBy(className = "alert-text")
	protected WebElement tagMessage;

	public ElementManagementPage(WebDriver driver) {
		super(driver);
	}
	
	public String getSuccessMessage() {
		wait.waitVisibility(tagMessage);
		return tagMessage.getText();
	}

	public boolean waitForAlertToContainText(String expected) {
		return wait.waitForTextToBeContained(By.className("alert-text"), expected);
	}

}
