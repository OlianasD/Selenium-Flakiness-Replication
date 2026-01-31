package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Strings;

public class BaseNavBar {
	
	public WebDriver driver;
	
	@FindBy(linkText = Strings.viewIssues)
	protected WebElement viewIssues;
	
	@FindBy(linkText = Strings.manage)
	protected WebElement manage;
	
	@FindBy(className = "user-info")
	protected WebElement logout;
	
	@FindBy(linkText = Strings.newIssue)
	protected WebElement reportIssue;
	
	public BaseNavBar(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public ManageNavBar manage() {
		manage.click();
		return new ManageNavBar(driver);
	}
	
	public ReportIssuePage reportIssue() {
		reportIssue.click();
		return new ReportIssuePage(driver);
	}
	
	public ViewIssuesPage viewIssues() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		viewIssues.click();
		return new ViewIssuesPage(driver);
	}
	
	public LoginPage logout() {
		logout.click();
		driver.findElement(By.xpath("//*[@id=\"navbar-container\"]/div[2]/ul/li[3]/ul/li[4]/a")).click();
		return new LoginPage(driver);
	}
}
