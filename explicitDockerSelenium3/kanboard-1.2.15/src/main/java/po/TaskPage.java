package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

public class TaskPage extends TaskSidebar {
	
	@FindBy(xpath = "//*[@id=\"task-summary\"]/div/div/div[1]/ul/li[1]/span")
	protected WebElement status;
	
	protected Wait wait;

	public TaskPage(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public TaskPage confirmCloseTask() {
		By locator = By.xpath("//*[@id=\"modal-confirm-button\"]");
		wait.waitClickability(locator);
		driver.findElement(locator).click();
		return new TaskPage(driver);
	}
	
	public String getStatus(String expected) {
		By locator = By.xpath("//*[@id=\"task-summary\"]/div/div/div[1]/ul/li[1]/span");
		wait.waitForTextToBe(locator, expected);
		return status.getText();
	}

}
