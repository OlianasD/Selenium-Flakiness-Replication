package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.Wait;

public class CourseCreatePage extends ClarolinePage {
	@FindBy(id="course_title")
	private WebElement courseTitle;
	@FindBy(id="course_officialCode")
	private WebElement courseCode;
	@FindBy(id="mslist2")
	private WebElement addCategoryList;
	@FindBy(css="a.msremove > img")
	private WebElement addCategoryButton;
	@FindBy(id="registration_true")
	private WebElement allowed;
	@FindBy(id="access_public")
	private WebElement public_access;
	@FindBy(name="changeProperties")
	private WebElement confirm;
	@FindBy(linkText="Continue")
	private WebElement continueLink;
	@FindBy(id="registration_key")
	private WebElement reserved;
	@FindBy(id="registration_false")
	private WebElement denied;
	@FindBy(id="course_registrationKey")
	private WebElement password;
	
	protected Wait wait;
	
	public CourseCreatePage(WebDriver driver){
		super(driver);
		wait = new Wait(driver);
		PageFactory.initElements(driver, this);
	}
	
	public CourseCreatePage addAllowedCourse(String title, String code, String cat1, String cat2) throws InterruptedException{
		wait.waitClickability(courseTitle);
		courseTitle.sendKeys(title);
		wait.waitClickability(courseCode);
		courseCode.sendKeys(code);
		wait.waitClickability(addCategoryList);
		new Select(addCategoryList).selectByVisibleText(cat1);
		wait.waitClickability(addCategoryButton);
		addCategoryButton.click();
		wait.waitClickability(addCategoryList);
		new Select(addCategoryList).selectByVisibleText(cat2);
		wait.waitClickability(addCategoryButton);
		addCategoryButton.click();
		wait.waitClickability(allowed);
		allowed.click();
		wait.waitClickability(public_access);
		public_access.click();
		wait.waitClickability(confirm);
		confirm.click();
		return new CourseCreatePage(driver);
	}
	
	public CourseCreatePage addPasswordCourse(String title, String code, String cat1, String pass) {
		wait.waitClickability(courseTitle);
		courseTitle.sendKeys(title);
		wait.waitClickability(courseCode);
		courseCode.sendKeys(code);
		wait.waitClickability(addCategoryList);
		new Select(addCategoryList).selectByVisibleText(cat1);
		wait.waitClickability(addCategoryButton);
		addCategoryButton.click();
		wait.waitClickability(reserved);
		reserved.click();
		wait.waitClickability(password);
		password.sendKeys(pass);
		wait.waitClickability(public_access);
		public_access.click();
		wait.waitClickability(confirm);
		confirm.click();
		return new CourseCreatePage(driver);
	}
	
	public CourseCreatePage addDeniedCourse(String title, String code, String cat1) {
		wait.waitClickability(courseTitle);
		courseTitle.sendKeys(title);
		wait.waitClickability(courseCode);
		courseCode.sendKeys(code);
		wait.waitClickability(addCategoryList);
		new Select(addCategoryList).selectByVisibleText(cat1);
		wait.waitClickability(addCategoryButton);
		addCategoryButton.click();
		wait.waitClickability(denied);
		denied.click();
		wait.waitClickability(confirm);
		confirm.click();
		return new CourseCreatePage(driver);
	}
	
	public CourseCreatePage addEmptyCourse() {
		wait.waitClickability(confirm);
		confirm.click();
		return new CourseCreatePage(driver);
	}
	
	public AdminPage goToAdminPage(){
		wait.waitClickability(continueLink);
		continueLink.click();
		AdminPage page = new AdminPage(driver);
		return page;
	}
	
	public String getErrorMsg(int i){
		wait.waitVisibility(By.xpath(".//*[@id='claroBody']/div[2]/div/span["+i+"]"));
		WebElement msg = driver.findElement(By.xpath(".//*[@id='claroBody']/div[2]/div/span["+i+"]"));
		return msg.getText();		
	}
	
}
