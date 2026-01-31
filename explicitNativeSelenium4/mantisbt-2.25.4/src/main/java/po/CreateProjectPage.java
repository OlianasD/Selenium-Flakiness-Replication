package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utils.Wait;

public class CreateProjectPage extends ManageNavBar {

	@FindBy(name = "status")
	protected WebElement status;
	
	@FindBy(name = "view_state")
	protected WebElement visibility;
	
	@FindBy(name = "description")
	protected WebElement description;
	
	protected Wait wait;
	

	public CreateProjectPage(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public CreateProjectPage setName(String nameStr) {
		/*try {
			wait.waitClickabilityRefreshed(By.name("name")).sendKeys(nameStr);
		} catch(WebDriverException e) {
			wait.waitClickabilityRefreshed(By.name("name")).sendKeys(nameStr);
		}*/
		wait.waitClickabilityRefreshed(By.name("name")).sendKeys(nameStr);
		return this;
	}
	
	public CreateProjectPage setStatus(String stat) {
		new Select(status).selectByVisibleText(stat);
		return this;
	}
	
	public CreateProjectPage setVisibility(String visib) {
		new Select(visibility).selectByVisibleText(visib);
		return this;
	}
	
	public CreateProjectPage setDescription(String descr) {
		wait.waitClickability(description);
		description.clear();
		description.sendKeys(descr);
		return this;
	}
	
	public BaseNavBar createProject() {
		wait.waitClickability(By.xpath("//*[@id=\"manage-project-create-form\"]/div/div[3]/input"));
		driver.findElement(By.xpath("//*[@id=\"manage-project-create-form\"]/div/div[3]/input")).click();
		return new BaseNavBar(driver);
	}
	
	public CreateProjectPage createProjectFails() {
		wait.waitClickability(By.xpath("//*[@id=\"manage-project-create-form\"]/div/div[3]/input"));
		driver.findElement(By.xpath("//*[@id=\"manage-project-create-form\"]/div/div[3]/input")).click();
		return new CreateProjectPage(driver);
	}
	
	public String getError() {
		wait.waitVisibility(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/p[2]"));
		return driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/p[2]")).getText();
	}

}
