package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StatesPage extends AdminSidebar {
	
	@FindBy(id = "page-header-desc-state-new_state")
	protected WebElement addNewState;
	
	@FindBy(className = "alert-success")
	protected WebElement tagMessage;
	
	@FindBy(id = "subtab-AdminStates")
	protected WebElement statesTab;

	public StatesPage(WebDriver driver) {
		super(driver);
	}
	
	public AddNewStatePage addNewState() {
		addNewState.click();
		return new AddNewStatePage(driver);
	}
	
	public String getSuccessMessage() {
		wait.waitVisibility(By.className("alert-success"));
		return tagMessage.getText();
	}

	public boolean waitForAlertToContainText(String expected) {
		return wait.waitForTextToBeContained(By.className("alert-success"), expected);
	}
	
	public StatesPage goToStatesTab() {
		statesTab.click();
		return new StatesPage(driver);
	}

}
