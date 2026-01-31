package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewProjectPage extends PageObject {

	@FindBy(id = "form-name")
	protected WebElement newProjectInput;

	@FindBy(xpath = "//*[@id=\"project-creation-form\"]/div[2]/div/button")
	protected WebElement saveBtn;

	@FindBy(className = "form-errors")
	protected WebElement errorMsg;

	public AddNewProjectPage(WebDriver driver) {
		super(driver);

	}

	public ProjectSummaryPage addNewProject(String name) {
		newProjectInput.sendKeys(name);
		saveBtn.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new ProjectSummaryPage(driver);

	}

	public AddNewProjectPage addEmptyProject() {
		saveBtn.click();
		return new AddNewProjectPage(driver);
	}

	public String getErrorMessage() {
		return errorMsg.getText();
	}

}
