package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Wait;

public class SiteCategoryPage extends PageObject {
	
	@FindBy(xpath = "/html/body/section/div/div/div/a/h2")
	public WebElement firstArticle;

	protected Wait wait;

	public SiteCategoryPage(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public String getFirstArticle() {
		wait.waitVisibility(firstArticle);
		return firstArticle.getText();
	}
	
	
	
}