package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Wait;

public class DesktopPage extends ClarolinePage{
	@FindBy(linkText="Platform administration")
	private WebElement platformAdminLink;
	@FindBy(xpath=".//*[@id='userProfileBox']/h3/span")
	private WebElement userProfile;
	@FindBy(linkText="Enrol on a new course")
	private WebElement enrolLink;
	@FindBy(linkText="Remove course enrolment")
	private WebElement removeEnrolLink;
	@FindBy(linkText="001 - Course001")
	private WebElement course001;
	@FindBy(linkText=">>")
	private WebElement nextMonthAgendaLink;
	@FindBy(linkText="Manage my account")
	private WebElement userAccountLink;
	private Wait wait;
	
	public DesktopPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
	}
	
	public AdminPage goToAdminPage(){
		wait.waitClickability(platformAdminLink);
		platformAdminLink.click();
		AdminPage page = new AdminPage(driver);
		return page;
	}
	
	public String getUserProfile(){
		wait.waitVisibility(userProfile);
		return userProfile.getText();
	}
	
	public AuthCoursesPage enrolToCourse(){
		wait.waitClickability(enrolLink);
		enrolLink.click();
		AuthCoursesPage page = new AuthCoursesPage(driver);
		return page;
	}
	
	public AuthCoursesPage removeEnrolFromCourse(){
		wait.waitClickability(removeEnrolLink);
		removeEnrolLink.click();
		AuthCoursesPage page = new AuthCoursesPage(driver);
		return page;
	}
	
	public CourseIndexPage goInsideCourse() throws InterruptedException{
		wait.waitClickability(course001);
		course001.click();
		CourseIndexPage page = new CourseIndexPage(driver);
		return page;
	}

	
	public ProfilePage goToMyUserAccount(){
		wait.waitClickability(userAccountLink);
		userAccountLink.click();
		ProfilePage page = new ProfilePage(driver);
		return page;
	}
	
}
