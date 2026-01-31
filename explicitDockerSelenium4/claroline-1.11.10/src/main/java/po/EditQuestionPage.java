package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Wait;

public class EditQuestionPage {
	private WebDriver driver;
	@FindBy(id="title")
	private WebElement title;
	@FindBy(id="MCUA")
	private WebElement multipleCondUniqueAnswer;
	@FindBy(id="TF")
	private WebElement trueFalse;
	@FindBy(id="MCMA")
	private WebElement multipleCondMultipleAnswer;
	@FindBy(css="input[type='submit']")
	private WebElement confirm;	
	@FindBy(linkText="Exercise 001")
	private WebElement exerciseLink;
	@FindBy(linkText="New question")
	private WebElement newQuestionLink;
	
	protected Wait wait;

	public EditQuestionPage(WebDriver driver){
		this.driver = driver;
		wait = new Wait(driver);
		PageFactory.initElements(driver, this);
	}
	
	public EditAnswerPage addMCUAQuestion(String tit) {
		wait.waitClickability(title);
		title.sendKeys(tit);
		multipleCondUniqueAnswer.click();
		confirm.click();
		EditAnswerPage page = new EditAnswerPage(driver);
		return page;
	}
	
	public EditAnswerPage addMCMAQuestion(String tit) {
		wait.waitClickability(title);
		title.sendKeys(tit);
		multipleCondMultipleAnswer.click();
		confirm.click();
		EditAnswerPage page = new EditAnswerPage(driver);
		return page;
	}
	
	public EditAnswerPage addTFQuestion(String tit) {
		wait.waitClickability(title);
		title.sendKeys(tit);
		trueFalse.click();
		confirm.click();
		EditAnswerPage page = new EditAnswerPage(driver);
		return page;
	}
	
	public EditExercisePage goToEditExercisePage(){
		wait.waitClickability(exerciseLink);
		exerciseLink.click();
		EditExercisePage page = new EditExercisePage(driver);
		return page;
	}
	
	public EditQuestionPage newQuestion() {
		wait.waitClickability(newQuestionLink);
		newQuestionLink.click();
		return new EditQuestionPage(driver);
	}

}
