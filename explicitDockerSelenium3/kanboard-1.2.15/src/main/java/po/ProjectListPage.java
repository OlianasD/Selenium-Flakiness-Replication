package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Wait;

public class ProjectListPage extends TopNavBar {
	
	public ProjectListPage(WebDriver driver) {
		super(driver);
	}
	
	public boolean firstProjectIsNot(String proj) {
		By locator = By.xpath("//*[@id=\"dashboard\"]/div[2]/div[2]/div[2]/div[1]/span/a");
		return wait.waitForTextToDisappear(locator, proj);
	}

}