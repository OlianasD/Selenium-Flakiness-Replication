package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

public class ViewIssueDetailsPage extends BaseNavBar {
	
	@FindBy(xpath = "//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[6]/td[1]")
	protected WebElement priority;
	
	@FindBy(xpath = "//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[6]/td[2]")
	protected WebElement severity;
	
	@FindBy(xpath = "//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[7]/td[1]")
	protected WebElement status;
	
	@FindBy(xpath = "//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[10]/td")
	protected WebElement summary;
	
	protected Wait wait;

	public ViewIssueDetailsPage(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public String getPriority() {
		wait.waitVisibility(priority);
		return priority.getText();
	}
	
	public String getSeverity() {
		wait.waitVisibility(severity);
		return severity.getText();
	}
	
	public String getStatus() {
		wait.waitVisibility(status);
		return status.getText();
	}
	
	public String getSummary() {
		wait.waitVisibility(summary);
		return summary.getText();
	}
	
}
