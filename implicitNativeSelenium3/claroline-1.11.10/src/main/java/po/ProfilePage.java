package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
	private WebDriver driver;
	@FindBy(xpath=".//*[@id='claroBody']/div[1]/table/tbody/tr/td[2]/ul/li/a")
	private WebElement statistics;
	
	
	public ProfilePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public TrackUserReportPage viewStats() throws InterruptedException{
		statistics.click();
		TrackUserReportPage page = new TrackUserReportPage(driver);
		return page;
	}
}
