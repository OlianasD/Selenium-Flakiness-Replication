package po;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class EditIssuePage extends BaseNavBar {
	
	@FindBy(id = "priority")
	protected WebElement priority;
	
	@FindBy(id= "severity")
	protected WebElement severity;
	
	@FindBy(id= "status")
	protected WebElement status;
	
	@FindBy(id = "summary")
	protected WebElement summary;
	
	@FindBy(xpath = "//*[@id=\"update_bug_form\"]/div/div[3]/input")
	protected WebElement updateIssueBtn;
	
	public EditIssuePage(WebDriver driver) {
		super(driver);
	}
	
	public EditIssuePage setPriority(String prior) {
		new Select(priority).selectByVisibleText(prior);
		return this;
	}
	
	public EditIssuePage setSeverity(String sev) {
		new Select(severity).selectByVisibleText(sev);
		return this;
	}
	
	public EditIssuePage setStatus(String st) {
		new Select(status).selectByVisibleText(st);
		return this;
	}
	
	public EditIssuePage setSummary(String summ) {
		summary.clear();
		summary.sendKeys(summ);
		return this;
	}
	
	public ViewIssueDetailsPage updateIssue() {
		updateIssueBtn.click();
		return new ViewIssueDetailsPage(driver);
	}
	
	

}
