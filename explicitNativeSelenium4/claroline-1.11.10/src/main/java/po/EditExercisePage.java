package po;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Wait;

public class EditExercisePage extends ClarolinePage{
	@FindBy(id="title")
	private WebElement title;
	@FindBy(css="input[type='submit']")
	private WebElement confirm;
	@FindBy(linkText="New question")
	private WebElement newQuestionLink;
	@FindBy(linkText="Exercise 001")
	private WebElement exerciseLink;

	protected Wait wait;

	public EditExercisePage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
	}
	
	public EditExercisePage addExercise(String tit) {
		wait.waitClickability(title);
		title.sendKeys(tit);
		wait.waitClickability(confirm);
		confirm.click();
		return new EditExercisePage(driver);
	}
	
	public EditQuestionPage newQuestion(){
		wait.waitClickability(newQuestionLink);
		newQuestionLink.click();
		EditQuestionPage page = new EditQuestionPage(driver);
		return page;
	}

	
	public String getQuestionTitle(int i){
		return wait.waitVisibility(By.xpath(".//*[@id='courseRightContent']/table/tbody/tr["+i+"]/td[2]")).getText();
	}
	
	public String getQuestionKind(int i){
		return wait.waitVisibility(By.xpath(".//*[@id='courseRightContent']/table/tbody/tr["+i+"]/td[4]")).getText();
	}
	
	public EditExercisePage removeQuestion(int i) throws InterruptedException{
		WebElement remove = wait.waitClickability(By.cssSelector("img[alt='Delete']"));
		remove.click();
		wait.waitAlert();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.navigate().refresh();
		return new EditExercisePage(driver);
	}

}
