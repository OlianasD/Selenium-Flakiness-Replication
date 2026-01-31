package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.Wait;

public class TrackUserReportPage extends ClarolinePage{

	@FindBy(id="cidReq")
	private WebElement chooseCourse;
	@FindBy(xpath=".//*[@id='leftContent']/div[4]/div[1]/table/tbody/tr[1]/td[1]/a")
	private WebElement exeName;
	@FindBy(xpath=".//*[@id='leftContent']/div[4]/div[1]/table/tbody/tr[1]/td[3]")
	private WebElement exeResult;

	protected Wait wait;

	public TrackUserReportPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
	}
	
	public TrackUserReportPage selectCourseStatistics(String course) {
		wait.waitClickability(chooseCourse);
		new Select(chooseCourse).selectByVisibleText(course);
		return new TrackUserReportPage(driver);
	}
	
	public String getExeName(){
		wait.waitVisibility(exeName);
		return exeName.getText();
	}
	
	public String getExeResult(){
		wait.waitVisibility(exeResult);
		return exeResult.getText();
	}
	
}
