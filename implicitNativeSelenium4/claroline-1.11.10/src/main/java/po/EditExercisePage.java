package po;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditExercisePage extends ClarolinePage{
	private WebDriver driver;
	@FindBy(id="title")
	private WebElement title;
	@FindBy(css="input[type='submit']")
	private WebElement confirm;
	@FindBy(linkText="New question")
	private WebElement newQuestionLink;
	@FindBy(linkText="Exercise 001")
	private WebElement exerciseLink;
	

	public EditExercisePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public EditExercisePage addExercise(String tit) throws InterruptedException{
		title.sendKeys(tit);
		confirm.click();
		return new EditExercisePage(driver);
	}
	
	public EditQuestionPage newQuestion(){
		newQuestionLink.click();
		EditQuestionPage page = new EditQuestionPage(driver);
		return page;
	}
	
	public ExercisePage goToExercisePage(){
		exerciseLink.click();
		ExercisePage page = new ExercisePage(driver);
		return page;
	}
	
	public String getQuestionTitle(int i){
		return driver.findElement(By.xpath(".//*[@id='courseRightContent']/table/tbody/tr["+i+"]/td[2]")).getText();
	}
	
	public String getQuestionKind(int i){
		return driver.findElement(By.xpath(".//*[@id='courseRightContent']/table/tbody/tr["+i+"]/td[4]")).getText();
	}
	
	public EditExercisePage removeQuestion(int i) throws InterruptedException{
		WebElement remove = driver.findElement(By.cssSelector("img[alt='Delete']"));
		remove.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.navigate().refresh();
		return new EditExercisePage(driver);
	}

}
