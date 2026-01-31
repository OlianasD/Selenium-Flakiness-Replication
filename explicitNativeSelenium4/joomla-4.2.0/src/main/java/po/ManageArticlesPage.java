package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Wait;

public class ManageArticlesPage extends SiteAdminPageObject {
	
	protected Wait wait;
	
	public ManageArticlesPage(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public ManageArticlesPage deleteFirstArticle() {
		wait.waitClickability(By.id("cb0")).click();
		wait.waitClickability(By.xpath("//*[@id=\"toolbar-status-group\"]/button")).click();
		wait.waitClickability(By.xpath("//*[@id=\"status-group-children-trash\"]/button")).click();
		return this;
	}
	
	public String getAlertMessage(String message) {
		By locator = By.className("alert-message");
		wait.waitForTextToBe(locator, message);
		return driver.findElement(locator).getText();
	}
	
	public boolean containsArticle(String title) {
		return wait.waitVisibility(By.id("articleList")).getText().contains(title);
	}
	
	public EditArticleSiteAdminPage goToArticle(String article) {
		wait.waitClickability(By.linkText(article)).click();
		return new EditArticleSiteAdminPage(driver);
	}
	
	public String getFirstArticleCategory() {
		return wait.waitVisibility(By.xpath("//*[@id=\"articleList\"]/tbody/tr[1]/th/div/div[2]/a")).getText();
	}
	
	public ManageArticlesPage archiveSecondArticle() {
		wait.waitClickability(By.id("cb1")).click();
		wait.waitClickability(By.xpath("//*[@id=\"toolbar-status-group\"]/button")).click();
		wait.waitClickability(By.xpath("//*[@id=\"status-group-children-archive\"]/button")).click();
		return this;
	}

}
