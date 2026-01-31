package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Wait;

public class ProfilePage {
	private WebDriver driver;
	@FindBy(xpath=".//*[@id='claroBody']/div[1]/table/tbody/tr/td[2]/ul/li/a")
	private WebElement statistics;
	
	protected Wait wait;

	public ProfilePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
	}
	
	public TrackUserReportPage viewStats()  {
		wait.waitClickability(statistics);
		statistics.click();
		TrackUserReportPage page = new TrackUserReportPage(driver);
		return page;
	}
}
