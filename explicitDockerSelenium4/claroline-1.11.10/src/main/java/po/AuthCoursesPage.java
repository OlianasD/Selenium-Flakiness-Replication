package po;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Wait;

public class AuthCoursesPage extends ClarolinePage{
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
	
	protected Wait wait;
	
	public AuthCoursesPage(WebDriver driver){
		super(driver);
		wait = new Wait(driver);
		PageFactory.initElements(driver, this);
	}
	
	public AuthCoursesPage searchCourse(String course)  {
		wait.waitClickability(searchBox);
		searchBox.sendKeys(course);
		wait.waitClickability(searchButton);
		searchButton.click();
		return this;
	}
	
	public AuthCoursesPage enrol() {
		wait.waitClickability(enrolButton);
		enrolButton.click();
		return this;
	}
	
	public AuthCoursesPage enrolPassword(String password) {
		wait.waitClickability(enrolButton);
		enrolButton.click();
		wait.waitClickability(coursePsw);
		coursePsw.sendKeys(password);
		wait.waitClickability(submitPsw);
		submitPsw.click();
		return this;
	}
	
	public AuthCoursesPage removeEnrol() {
		wait.waitClickability(removeEnrolButton);
		removeEnrolButton.click();
		wait.waitAlert();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return this;
	}
	
	public String getErrorMsg(){
		wait.waitVisibility(errorMsg);
		return errorMsg.getText();
	}
	
	
}
