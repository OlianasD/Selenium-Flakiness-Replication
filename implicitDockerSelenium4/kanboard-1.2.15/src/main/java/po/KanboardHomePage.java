package po;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
		// TODO Auto-generated constructor stub
	}
	
	public AddNewProjectPage newProject() {
		newProjectLink.click();
		return new AddNewProjectPage(driver);
	}
	
	public ProjectManagementPage goToFirstProject() {
		firstProjectLink.click();
		return new ProjectManagementPage(driver);
	}
	
	public ProjectSummaryPage firstProjectSummary() {
		option.click();
		configure.click();
		return new ProjectSummaryPage(driver);
	}
	
	public AddNewProjectPage newPersonalProject() {
		newPrivateProjectLink.click();
		return new AddNewProjectPage(driver);
	}
	
	public SearchResultsPage search(String key) {
		search.sendKeys(key);
		search.sendKeys(Keys.RETURN);
		return new SearchResultsPage(driver);
	}
	
	public ProjectPage goToProject(String proj) {
		driver.findElement(By.linkText(proj)).click();
		return new ProjectPage(driver);
	}
	
	
	

}
