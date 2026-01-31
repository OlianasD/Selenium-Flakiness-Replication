package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import utils.Strings;

public class ViewIssuesPage extends BaseNavBar {
	
	
	
	public ViewIssuesPage(WebDriver driver) {
		super(driver);
	}
	
	
	public String getCategory() {
		return driver.findElement(By.xpath("//*[@id=\"buglist\"]/tbody/tr/td[7]/div")).getText();
	}
	
	public String getSeverity() {
		return driver.findElement(By.xpath("//*[@id=\"buglist\"]/tbody/tr/td[8]/span")).getText();
	}
	
	public String getStatus() {
		return driver.findElement(By.xpath("//*[@id=\"buglist\"]/tbody/tr/td[9]/div")).getText();
	}
	
	public String getSummary() {
		return driver.findElement(By.xpath("//*[@id=\"buglist\"]/tbody/tr/td[11]/a")).getText();
	}
	
	public ViewIssuesPage selectFirstIssue() {
		driver.findElement(By.xpath("//*[@id=\"buglist\"]/tbody/tr/td[1]/div/label/span")).click();
		return this;
	}
	
	
	public AssignIssuePage assignIssue() {
		new Select(driver.findElement(By.name("action"))).selectByVisibleText(Strings.assign);
		driver.findElement(By.xpath("//*[@id=\"bug_action\"]/div/div[2]/div[2]/div[2]/div[1]/input")).click();
		return new AssignIssuePage(driver);
	}
	
	public EditIssuePage editFirstIssue() {
		driver.findElement(By.xpath("//*[@id=\"buglist\"]/tbody/tr/td[2]/a/i")).click();
		return new EditIssuePage(driver);
	}
	
	public DeleteIssuePage deleteIssue() {
		new Select(driver.findElement(By.name("action"))).selectByVisibleText(Strings.delete);
		driver.findElement(By.xpath("//*[@id=\"bug_action\"]/div/div[2]/div[2]/div[2]/div[1]/input")).click();
		return new DeleteIssuePage(driver);
	}
	
	public String getIssueListText() {
		return driver.findElement(By.xpath("//*[@id=\"bug_action\"]/div/div[1]/h4")).getText();
	}
	
	
	
	
	
	
	
}
