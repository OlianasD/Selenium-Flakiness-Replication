package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RevisionHistoryPage extends PageObject {
	
	@FindBy(linkText = "rollback 1 edit")
	protected WebElement rollbackLast;

	public RevisionHistoryPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public RevisionHistoryPage rollbackLastEdit() {
		rollbackLast.click();
		return new RevisionHistoryPage(driver);
	}
	
	public String getMessage() {
		return driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/p[1]")).getText();
	}
	
	public WikiPage goToLink(String pageName) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.linkText(pageName)).click();
		return new WikiPage(driver);
	}

}
