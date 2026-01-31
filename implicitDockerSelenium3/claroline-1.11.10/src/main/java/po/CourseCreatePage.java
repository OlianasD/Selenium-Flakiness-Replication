package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CourseCreatePage extends ClarolinePage {
	private WebDriver driver;
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
	
	public CourseCreatePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public CourseCreatePage addAllowedCourse(String title, String code, String cat1, String cat2) throws InterruptedException{
		courseTitle.sendKeys(title);
		courseCode.sendKeys(code);
		new Select(addCategoryList).selectByVisibleText(cat1);
		addCategoryButton.click();
		new Select(addCategoryList).selectByVisibleText(cat2);
		addCategoryButton.click();
		allowed.click();
		public_access.click();
		confirm.click();
		return new CourseCreatePage(driver);
	}
	
	public CourseCreatePage addPasswordCourse(String title, String code, String cat1, String pass) throws InterruptedException{
		courseTitle.sendKeys(title);
		courseCode.sendKeys(code);
		new Select(addCategoryList).selectByVisibleText(cat1);
		addCategoryButton.click();
		reserved.click();
		password.sendKeys(pass);
		public_access.click();
		confirm.click();
		return new CourseCreatePage(driver);
	}
	
	public CourseCreatePage addDeniedCourse(String title, String code, String cat1) throws InterruptedException{
		courseTitle.sendKeys(title);
		courseCode.sendKeys(code);
		new Select(addCategoryList).selectByVisibleText(cat1);
		addCategoryButton.click();
		denied.click();
		confirm.click();
		return new CourseCreatePage(driver);
	}
	
	public CourseCreatePage addEmptyCourse() throws InterruptedException{
		confirm.click();
		return new CourseCreatePage(driver);
	}
	
	public AdminPage goToAdminPage(){
		continueLink.click();
		AdminPage page = new AdminPage(driver);
		return page;
	}
	
	public String getErrorMsg(int i){
		WebElement msg = driver.findElement(By.xpath(".//*[@id='claroBody']/div[2]/div/span["+i+"]"));
		return msg.getText();		
	}
	
}
