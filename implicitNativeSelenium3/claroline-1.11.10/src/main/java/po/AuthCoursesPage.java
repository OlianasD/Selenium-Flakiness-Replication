package po;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthCoursesPage extends ClarolinePage{
	private WebDriver driver;
	@FindBy(id="coursesearchbox_keyword")
	private WebElement searchBox;
	@FindBy(css="button[type='submit']")
	private WebElement searchButton;
	@FindBy(css="img.enrolment")
	private WebElement enrolButton;
	@FindBy(css="img.enrolment")
	private WebElement removeEnrolButton;
	@FindBy(css="img[alt='Locked']")
	private WebElement lockedButton;
	@FindBy(name="registrationKey")
	private WebElement coursePsw;
	@FindBy(css="input[type='submit']")
	private WebElement submitPsw;
	@FindBy(xpath=".//*[@id='claroBody']/div[1]/div[1]")
	private WebElement errorMsg;
	
	public AuthCoursesPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public AuthCoursesPage searchCourse(String course) throws InterruptedException{
		searchBox.sendKeys(course);
		searchButton.click();
		return this;
	}
	
	public AuthCoursesPage enrol() throws InterruptedException{
		enrolButton.click();
		return this;
	}
	
	public AuthCoursesPage enrolPassword(String password) throws InterruptedException{
		enrolButton.click();
		coursePsw.sendKeys(password);
		submitPsw.click();
		return this;
	}
	
	public AuthCoursesPage enrolDenied() throws InterruptedException{
		enrolButton.click();
		return this;
	}
	
	public AuthCoursesPage removeEnrol() throws InterruptedException{
		removeEnrolButton.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return this;
	}
	
	public String getErrorMsg(){
		return errorMsg.getText();
	}
	
	
}
