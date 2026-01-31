package po;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AssignIssuePage extends BaseNavBar {
	
	/*@FindBy(name = "assign")
	public WebElement selectUser;*/
	
	@FindBy(xpath = "//*[@id=\"action-group-div\"]/form/div/div[2]/div[2]/input")
	protected WebElement assignIssueBtn;
	
	public AssignIssuePage(WebDriver driver) {
		super(driver);
	}
	
	public ViewIssuesPage confirmAssignment() {
		assignIssueBtn.click();
		return new ViewIssuesPage(driver);
	}
	
}