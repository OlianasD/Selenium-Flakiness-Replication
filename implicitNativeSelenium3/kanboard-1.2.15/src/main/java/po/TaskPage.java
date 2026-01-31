package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskPage extends TaskSidebar {
	
	@FindBy(xpath = "//*[@id=\"task-summary\"]/div/div/div[1]/ul/li[1]/span")
	protected WebElement status;

	public TaskPage(WebDriver driver) {
		super(driver);
	}
	
	public TaskPage confirmCloseTask() {
		driver.findElement(By.xpath("//*[@id=\"modal-confirm-button\"]")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new TaskPage(driver);
	}
	
	public String getStatus() {
		return status.getText();
	}

}
