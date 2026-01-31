package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends PageObject {
	
	
	protected String query;
	
	public SearchResultsPage(WebDriver driver, String query) {
		super(driver);
		this.query = query;
	}
	
	public PageCreationPage createNonExisting() {
		driver.findElement(By.linkText(query)).click();
		return new PageCreationPage(driver);
	}
	
	

}
