package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskSidebar extends TopNavBar {
	
	@FindBy(linkText = "Close this task")
	protected WebElement closeTask;

	public TaskSidebar(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public TaskPage closeTask() {
		closeTask.click();
		return new TaskPage(driver);
	}

}
