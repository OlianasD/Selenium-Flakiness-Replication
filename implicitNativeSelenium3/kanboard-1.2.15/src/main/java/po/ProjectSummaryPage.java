package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

	public String getTitle() {
		return projectName.getText();
	}

	public String getStatus() {
		return status.getText();
	}

	public String getDescription() {
		return description.getText();
	}

	public String getAccessLevel() {
		return accessLevel.getText();
	}

	public String getPublicAccess() {
		return publicAccess.getText();
	}

}
