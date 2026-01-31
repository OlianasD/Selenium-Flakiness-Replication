package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SiteCategoryPage extends PageObject {
	
	@FindBy(xpath = "/html/body/section/div/div/div/a/h2")
	public WebElement firstArticle;
	
	public SiteCategoryPage(WebDriver driver) {
		super(driver);
	}
	
	public String getFirstArticle() {
		return firstArticle.getText();
	}
	
	
	
}