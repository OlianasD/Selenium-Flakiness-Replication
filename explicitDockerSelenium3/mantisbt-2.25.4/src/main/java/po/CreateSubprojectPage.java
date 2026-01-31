package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
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
	
	public CreateSubprojectPage setName(String nm) {
		/*try {
			wait.waitClickabilityRefreshed(By.id("project-name")).sendKeys(nm);
		} catch(WebDriverException e) {
			wait.waitClickabilityRefreshed(By.id("project-name")).sendKeys(nm);
		}*/
		wait.waitClickabilityRefreshed(By.id("project-name")).sendKeys(nm);
		return this;
	}
	
	public ManageProjectPage createSubproject() {
		wait.waitClickability(createBtn);
		createBtn.click();
		wait.waitClickability(By.linkText(Strings.contin));
		driver.findElement(By.linkText(Strings.contin)).click();
		return new ManageProjectPage(driver);
	}
	

}
