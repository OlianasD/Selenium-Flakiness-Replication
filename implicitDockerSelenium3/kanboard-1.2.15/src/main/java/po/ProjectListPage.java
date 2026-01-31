package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectListPage extends TopNavBar {

	public ProjectListPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean containsProject(String proj) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return driver.findElement(By.tagName("body")).getText().contains(proj);
	}
}