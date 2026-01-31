package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Wait;

public class SearchResultsPage extends PageObject {
	
	protected String query;
	
	protected Wait wait;
	
	public SearchResultsPage(WebDriver driver, String query) {
		super(driver);
		this.query = query;
		wait = new Wait(driver);
	}
	
	public PageCreationPage createNonExisting() {
		wait.waitClickability(By.linkText(query));
		driver.findElement(By.linkText(query)).click();
		return new PageCreationPage(driver);
	}
	
	

}
