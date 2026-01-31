package po;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Wait;

public class AdminCoursesPage extends ClarolinePage{

	@FindBy(xpath=".//*[@id='claroBody']/table[2]/tbody/tr/td[2]")
	private WebElement courseName;
	@FindBy(xpath=".//*[@id='L0']")
	private WebElement courseCode;
	
	protected Wait wait;
	
	public AdminCoursesPage(WebDriver driver){
		super(driver);
		wait = new Wait(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String getCourseName(){
		wait.waitVisibility(courseName);
		return courseName.getText();
	}
	
	public String getCourseCode(){
		wait.waitVisibility(courseCode);
		return courseCode.getText();
	}
		
	public AdminCoursesPage removeCourse() throws InterruptedException{
		WebElement removeButton = wait.waitClickability(By.cssSelector("img[alt='Delete']"));
		removeButton.click();
		wait.waitAlert();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return new AdminCoursesPage(driver);
	}
	
}
