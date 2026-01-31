package po;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Wait;

public class KanboardHomePage extends TopNavBar {
	
	@FindBy(linkText = "New project")
	protected WebElement newProjectLink;
	
	@FindBy(linkText =  "Test 2")
	protected WebElement firstProjectLink;
	
	@FindBy(xpath =  "//*[@id=\"dashboard\"]/div[2]/div[2]/div[2]/div[1]/div/a/strong/i")
	protected WebElement option;
	
	@FindBy(linkText = "Configure this project")
	protected WebElement configure;
	
	@FindBy(linkText = "New personal project")
	protected WebElement newPrivateProjectLink;
	
	@FindBy(id = "form-search")
	protected WebElement search;

	public KanboardHomePage(WebDriver driver) {
		super(driver);
	}
	
	public AddNewProjectPage newProject() {
		wait.waitClickability(newProjectLink);
		newProjectLink.click();
		return new AddNewProjectPage(driver);
	}
	
	public ProjectManagementPage goToFirstProject() {
		wait.waitClickability(firstProjectLink);
		firstProjectLink.click();
		return new ProjectManagementPage(driver);
	}
	
	public ProjectSummaryPage firstProjectSummary() {
		wait.waitClickability(option);
		option.click();
		wait.waitClickability(configure);
		configure.click();
		return new ProjectSummaryPage(driver);
	}
	
	public AddNewProjectPage newPersonalProject() {
		wait.waitClickability(newPrivateProjectLink);
		newPrivateProjectLink.click();
		return new AddNewProjectPage(driver);
	}
	
	public SearchResultsPage search(String key) {
		wait.waitClickability(search);
		search.sendKeys(key);
		search.sendKeys(Keys.RETURN);
		return new SearchResultsPage(driver);
	}
	
	public ProjectPage goToProject(String proj) {
		wait.waitClickability(By.linkText(proj)).click();
		return new ProjectPage(driver);
	}
	
	
	

}
