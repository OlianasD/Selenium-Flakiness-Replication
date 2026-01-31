package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectPage extends TopNavBar {

	public ProjectPage(WebDriver driver) {
		super(driver);
	}
	
	public TaskPage goToTask(String task) {
		driver.findElement(By.linkText(task)).click();
		return new TaskPage(driver);
	}
	

}
