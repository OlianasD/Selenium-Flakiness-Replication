package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ReportIssuePage extends BaseNavBar {
	
	@FindBy(id ="category_id")
	protected WebElement category;
	
	@FindBy(id = "reproducibility")
	protected WebElement reproducibility;
	
	@FindBy(id= "severity")
	protected WebElement severity;
	
	@FindBy(id = "priority")
	protected WebElement priority;
	
	@FindBy(id = "summary")
	protected WebElement summary;
	
	@FindBy(id = "description")
	protected WebElement description;
	
	@FindBy(xpath = "//*[@id=\"report_bug_form\"]/div/div[2]/div[2]/input")
	protected WebElement submitIssueBtn;
	
	public ReportIssuePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public ReportIssuePage setCategory(String cat) {
		new Select(category).selectByVisibleText(cat);
		return this;
	}
	
	public ReportIssuePage setReproducibility(String repr) {
		new Select(reproducibility).selectByVisibleText(repr);
		return this;
	}
	
	public ReportIssuePage setSeverity(String sev) {
		new Select(severity).selectByVisibleText(sev);
		return this;
	}
	
	public ReportIssuePage setPriority(String prior) {
		new Select(priority).selectByVisibleText(prior);
		return this;
	}
	
	public ReportIssuePage setSummary(String summ) {
		summary.clear();
		summary.sendKeys(summ);
		return this;
	}
	
	public ReportIssuePage setDescription(String descr) {
		description.clear();
		description.sendKeys(descr);
		return this;
	}
	
	public ReportIssuePage submitIssue() {
		submitIssueBtn.click();
		return this;
	}

}
