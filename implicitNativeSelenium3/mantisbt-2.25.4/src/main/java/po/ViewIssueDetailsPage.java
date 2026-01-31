package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewIssueDetailsPage extends BaseNavBar {
	
	@FindBy(xpath = "//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[6]/td[1]")
	protected WebElement priority;
	
	@FindBy(xpath = "//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[6]/td[2]")
	protected WebElement severity;
	
	@FindBy(xpath = "//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[7]/td[1]")
	protected WebElement status;
	
	@FindBy(xpath = "//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[10]/td")
	protected WebElement summary;

	public ViewIssueDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	public String getPriority() {
		return priority.getText();
	}
	
	public String getSeverity() {
		return severity.getText();
	}
	
	public String getStatus() {
		return status.getText();
	}
	
	public String getSummary() {
		return summary.getText();
	}
	
}
