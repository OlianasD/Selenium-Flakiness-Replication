package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteIssuePage extends BaseNavBar {
	
	@FindBy(xpath = "//*[@id=\"action-group-div\"]/form/div/div[2]/div[2]/input")
	public WebElement deleteIssueBtn;
	
	public DeleteIssuePage(WebDriver driver) {
		super(driver);
	}
	
	public ViewIssuesPage deleteIssue() {
		deleteIssueBtn.click();
		return new ViewIssuesPage(driver);
	}
}
