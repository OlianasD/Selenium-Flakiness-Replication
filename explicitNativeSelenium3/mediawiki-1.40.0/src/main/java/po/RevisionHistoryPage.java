package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Wait;

public class RevisionHistoryPage extends PageObject {
	
	@FindBy(linkText = "rollback 1 edit")
	protected WebElement rollbackLast;

	protected Wait wait;
	public RevisionHistoryPage(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public RevisionHistoryPage rollbackLastEdit() {
		wait.waitClickability(rollbackLast);
		rollbackLast.click();
		return new RevisionHistoryPage(driver);
	}
	
	public String getMessage() {
		return driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/p[1]")).getText();
	}

	public boolean waitForMessageToBe(String expected) {
		return wait.waitForTextToBe(By.xpath("//*[@id=\"mw-content-text\"]/p[1]"), expected);
	}
	
	public WikiPage goToLink(String pageName) {
		wait.waitClickabilityRefreshed(By.linkText(pageName)).click();
		return new WikiPage(driver);
	}

	public WikiPage returnToRevertedPage() {
		wait.waitClickability(By.xpath("//*[@id=\"mw-returnto\"]/a")).click();
		return new WikiPage(driver);
	}

}
