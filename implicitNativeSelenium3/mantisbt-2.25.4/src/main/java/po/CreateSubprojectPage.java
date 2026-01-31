package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Strings;

public class CreateSubprojectPage extends ManageNavBar {
	
	@FindBy(id = "project-name")
	protected WebElement name;
	
	@FindBy(xpath = "//*[@id=\"manage-project-create-form\"]/div/div[3]/input")
	protected WebElement createBtn;

	public CreateSubprojectPage(WebDriver driver) {
		super(driver);
	}
	
	public CreateSubprojectPage setName(String name) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		this.name.sendKeys(name);
		return this;
	}
	
	public ManageProjectPage createSubproject() {
		createBtn.click();
		driver.findElement(By.linkText(Strings.contin)).click();
		return new ManageProjectPage(driver);
	}
	

}
