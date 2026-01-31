package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

public class ProjectSummaryPage extends ProjectSidebar {

	@FindBy(className = "title")
	protected WebElement projectName;

	@FindBy(xpath = "//*[@id=\"main\"]/section/div[2]/ul/li[1]")
	protected WebElement status;

	@FindBy(xpath = "//*[@id=\"main\"]/section/div[2]/article/p")
	protected WebElement description;

	@FindBy(xpath = "//*[@id=\"main\"]/section/div[2]/ul/li[3]")
	protected WebElement accessLevel;

	@FindBy(xpath = "//*[@id=\"main\"]/section/div[2]/ul/li[4]")
	protected WebElement publicAccess;

	public ProjectSummaryPage(WebDriver driver) {
		super(driver);
	}

	public String getTitle(String expectedTitle) {
		wait.waitForTextToBe(By.className("title"), expectedTitle);
		return projectName.getText();
	}

	public String getStatus() {
		wait.waitVisibility(status);
		return status.getText();
	}

	public String getDescription() {
		wait.waitVisibility(description);
		return description.getText();
	}

	public String getAccessLevel() {
		wait.waitVisibility(accessLevel);
		return accessLevel.getText();
	}

	public String getPublicAccess() {
		wait.waitVisibility(publicAccess);
		return publicAccess.getText();
	}

}
