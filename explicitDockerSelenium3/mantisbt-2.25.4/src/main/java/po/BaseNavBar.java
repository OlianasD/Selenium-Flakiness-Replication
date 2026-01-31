package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Strings;
import utils.Wait;

public class BaseNavBar {
	
	public WebDriver driver;
	
	@FindBy(className = "user-info")
	protected WebElement logout;
	
	@FindBy(linkText = Strings.newIssue)
	protected WebElement reportIssue;
	
	protected Wait wait;
	
	public BaseNavBar(WebDriver driver) {
		this.driver = driver;
		wait = new Wait(driver);
		PageFactory.initElements(driver, this);
	}
	
	public ManageNavBar manage() {
		/*try {
			wait.waitClickabilityRefreshed(By.linkText(Strings.manage)).click();
		} catch(WebDriverException e) {
			wait.waitClickabilityRefreshed(By.linkText(Strings.manage)).click();
		}*/
		wait.waitClickabilityRefreshed(By.linkText(Strings.manage)).click();
		return new ManageNavBar(driver);
	}
	
	public ReportIssuePage reportIssue() {
		wait.waitClickability(reportIssue);
		reportIssue.click();
		return new ReportIssuePage(driver);
	}
	
	public ViewIssuesPage viewIssues() {
		/*try {
			wait.waitClickabilityRefreshed(By.linkText(Strings.viewIssues)).click();
		} catch(WebDriverException e) {
			wait.waitClickabilityRefreshed(By.linkText(Strings.viewIssues)).click();
		}*/
		wait.waitClickabilityRefreshed(By.linkText(Strings.viewIssues)).click();
		return new ViewIssuesPage(driver);
	}
	
	public LoginPage logout() {
		wait.waitClickability(logout);
		logout.click();
		wait.waitClickability(By.xpath("//*[@id=\"navbar-container\"]/div[2]/ul/li[3]/ul/li[4]/a"));
		driver.findElement(By.xpath("//*[@id=\"navbar-container\"]/div[2]/ul/li[3]/ul/li[4]/a")).click();
		return new LoginPage(driver);
	}
}
