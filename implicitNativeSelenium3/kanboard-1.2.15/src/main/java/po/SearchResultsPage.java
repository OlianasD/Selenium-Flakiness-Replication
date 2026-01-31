package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends TopNavBar {
	
	@FindBy(xpath = "/html/body/section/div[3]/div[2]/div[1]/span/a")
	protected WebElement firstTask;

	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}

	public String getFirstTask() {
		return firstTask.getText();
	}

}
