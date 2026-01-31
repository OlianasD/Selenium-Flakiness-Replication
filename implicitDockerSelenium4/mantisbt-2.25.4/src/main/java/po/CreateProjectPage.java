package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateProjectPage extends ManageNavBar {
	
	@FindBy(name = "name")
	protected WebElement name;
	
	@FindBy(name = "status")
	protected WebElement status;
	
	@FindBy(name = "view_state")
	protected WebElement visibility;
	
	@FindBy(name = "description")
	protected WebElement description;
	

	public CreateProjectPage(WebDriver driver) {
		super(driver);
	}
	
	public CreateProjectPage setName(String nameStr) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		name.clear();
		name.sendKeys(nameStr);
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
		description.clear();
		description.sendKeys(descr);
		return this;
	}
	
	public BaseNavBar createProject() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id=\"manage-project-create-form\"]/div/div[3]/input")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new BaseNavBar(driver);
	}
	
	public CreateProjectPage createProjectFails() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id=\"manage-project-create-form\"]/div/div[3]/input")).click();
		return new CreateProjectPage(driver);
	}
	
	public String getError() {
		return driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[2]/p[2]")).getText();
	}

}
