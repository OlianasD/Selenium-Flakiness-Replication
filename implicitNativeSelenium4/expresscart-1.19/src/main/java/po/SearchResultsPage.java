package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends Home {
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/div[1]/div[1]/h1/strong")
	protected WebElement searchKey;

	public SearchResultsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public String getFirstItemName() {
		return driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[2]/div/div/div/a/h3")).getText();
	}
	
	public String getSearchKey() {
		return searchKey.getText();
	}
	
	public String getDangerAlertText() {
		return driver.findElement(By.className("text-danger")).getText();
	}
}
