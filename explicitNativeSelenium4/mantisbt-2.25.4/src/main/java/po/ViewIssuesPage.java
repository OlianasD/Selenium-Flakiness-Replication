package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import utils.Strings;
import utils.Wait;

public class ViewIssuesPage extends BaseNavBar {
	
	
	protected Wait wait;
	
	public ViewIssuesPage(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	
	public String getCategory() {
		wait.waitVisibility(By.xpath("//*[@id=\"buglist\"]/tbody/tr/td[7]/div"));
		return driver.findElement(By.xpath("//*[@id=\"buglist\"]/tbody/tr/td[7]/div")).getText();
	}
	
	public String getSeverity() {
		wait.waitVisibility(By.xpath("//*[@id=\"buglist\"]/tbody/tr/td[8]/span"));
		return driver.findElement(By.xpath("//*[@id=\"buglist\"]/tbody/tr/td[8]/span")).getText();
	}
	
	public String getStatus() {
		wait.waitVisibility(By.xpath("//*[@id=\"buglist\"]/tbody/tr/td[9]/div"));
		return driver.findElement(By.xpath("//*[@id=\"buglist\"]/tbody/tr/td[9]/div")).getText();
	}
	
	public String getSummary() {
		wait.waitVisibility(By.xpath("//*[@id=\"buglist\"]/tbody/tr/td[11]/a"));
		return driver.findElement(By.xpath("//*[@id=\"buglist\"]/tbody/tr/td[11]/a")).getText();
	}
	
	public ViewIssuesPage selectFirstIssue() {
		wait.waitVisibility(By.xpath("//*[@id=\"buglist\"]/tbody/tr/td[1]/div/label/span"));
		driver.findElement(By.xpath("//*[@id=\"buglist\"]/tbody/tr/td[1]/div/label/span")).click();
		return this;
	}
	
	
	public AssignIssuePage assignIssue() {
		wait.waitClickability(By.name("action"));
		new Select(driver.findElement(By.name("action"))).selectByVisibleText(Strings.assign);
		wait.waitClickability(By.xpath("//*[@id=\"bug_action\"]/div/div[2]/div[2]/div[2]/div[1]/input"));
		driver.findElement(By.xpath("//*[@id=\"bug_action\"]/div/div[2]/div[2]/div[2]/div[1]/input")).click();
		return new AssignIssuePage(driver);
	}
	
	public EditIssuePage editFirstIssue() {
		wait.waitClickability(By.xpath("//*[@id=\"buglist\"]/tbody/tr/td[2]/a/i"));
		driver.findElement(By.xpath("//*[@id=\"buglist\"]/tbody/tr/td[2]/a/i")).click();
		return new EditIssuePage(driver);
	}
	
	public DeleteIssuePage deleteIssue() {
		wait.waitClickability(By.name("action"));
		new Select(driver.findElement(By.name("action"))).selectByVisibleText(Strings.delete);
		wait.waitClickability(By.xpath("//*[@id=\"bug_action\"]/div/div[2]/div[2]/div[2]/div[1]/input"));
		driver.findElement(By.xpath("//*[@id=\"bug_action\"]/div/div[2]/div[2]/div[2]/div[1]/input")).click();
		return new DeleteIssuePage(driver);
	}
	
	public String getIssueListText() {
		wait.waitVisibility(By.xpath("//*[@id=\"bug_action\"]/div/div[1]/h4"));
		return driver.findElement(By.xpath("//*[@id=\"bug_action\"]/div/div[1]/h4")).getText();
	}
	
	
	
	
	
	
	
}
