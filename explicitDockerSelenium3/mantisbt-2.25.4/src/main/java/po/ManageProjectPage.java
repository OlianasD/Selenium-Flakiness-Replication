package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageProjectPage extends ManageNavBar {
	
	@FindBy(xpath = "//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/form/button")
	protected WebElement createProjectBtn;
	
	
	public ManageProjectPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public CreateProjectPage createProject() {
		wait.waitClickability(createProjectBtn);
		createProjectBtn.click();
		return new CreateProjectPage(driver);
	}
	
	public String getProjectName() {
		wait.waitVisibility(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/div[2]/div/div[2]/table/tbody/tr/td[1]/a"));
		return driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/div[2]/div/div[2]/table/tbody/tr/td[1]/a")).getText();
	}
	
	public String getProjectStatus() {
		wait.waitVisibility(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/div[2]/div/div[2]/table/tbody/tr/td[2]"));
		return driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/div[2]/div/div[2]/table/tbody/tr/td[2]")).getText();
	}
	
	public String getProjectVisibility() {
		wait.waitVisibility(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/div[2]/div/div[2]/table/tbody/tr/td[4]"));
		return driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/div[2]/div/div[2]/table/tbody/tr/td[4]")).getText();
	}
	
	public String getProjectDescription() {
		wait.waitVisibility(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/div[2]/div/div[2]/table/tbody/tr/td[5]"));
		return driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/div[2]/div/div[2]/table/tbody/tr/td[5]")).getText();
	}
	
	public EditProjectPage goToProject(String projectName) {
		wait.waitClickability(By.linkText(projectName));
		driver.findElement(By.linkText(projectName)).click();
		return new EditProjectPage(driver);
	}
	
	public boolean isProjectPresent(String projectName) {
		return wait.waitForTextToBeContained(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/div[2]"), projectName);
	}

	public boolean isProjectAbsent(String projectName) {
		/*try {
			return wait.waitForTextToDisappear(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/div[2]"), projectName);
		} catch(WebDriverException e) {
			return wait.waitForTextToDisappear(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/div[2]"), projectName);
		}*/
		return wait.waitForTextToDisappear(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/div[2]"), projectName);
	}
	

}
