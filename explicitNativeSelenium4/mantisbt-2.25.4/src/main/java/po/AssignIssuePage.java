package po;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AssignIssuePage extends BaseNavBar {
	
	@FindBy(xpath = "//*[@id=\"action-group-div\"]/form/div/div[2]/div[2]/input")
	protected WebElement assignIssueBtn;
	
	public AssignIssuePage(WebDriver driver) {
		super(driver);
	}
	
	public ViewIssuesPage confirmAssignment() {
		wait.waitClickability(assignIssueBtn);
		assignIssueBtn.click();
		return new ViewIssuesPage(driver);
	}
	
}