package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Wait;

public class EditAnswerPage {
	private WebDriver driver;
	@FindBy(name="cmdOk")
	private WebElement okButton;
	@FindBy(id="correct_1")
	private WebElement correct1;
	@FindBy(id="trueCorrect")
	private WebElement correctTF;
	@FindBy(name="grade_1")
	private WebElement grade1;
	@FindBy(name="grade_2")
	private WebElement grade2;
	@FindBy(name="grade_3")
	private WebElement grade3;
	@FindBy(name="trueGrade")
	private WebElement trueGrade;
	@FindBy(name="falseGrade")
	private WebElement falseGrade;
	@FindBy(name="cmdAddAnsw")
	private WebElement addAnswer;	
	
	protected Wait wait;

	public EditAnswerPage(WebDriver driver){
		this.driver = driver;
		wait = new Wait(driver);
		PageFactory.initElements(driver, this);
	}
	
	public EditQuestionPage addMCUA(String gr1, String gr2) throws InterruptedException{
		wait.waitClickability(correct1);
		correct1.click();
		grade1.clear();
		grade1.sendKeys(gr1);
		grade2.clear();
		grade2.sendKeys(gr2);
		okButton.click();
		EditQuestionPage page = new EditQuestionPage(driver);
		return page;
	}
	
	public EditQuestionPage addMCMA(String gr1, String gr2, String gr3) throws InterruptedException{
		wait.waitClickability(addAnswer);
		addAnswer.click();
		//Thread.sleep(500);
		WebElement correct1reloaded = wait.waitClickability(By.id("correct_1"));
		correct1reloaded.click();
		grade1.clear();
		grade1.sendKeys(gr1);
		grade2.clear();
		grade2.sendKeys(gr2);
		grade3.clear();
		grade3.sendKeys(gr3);
		okButton.click();
		EditQuestionPage page = new EditQuestionPage(driver);
		return page;
	}
	
	public EditQuestionPage addTFA(String gr1, String gr2) throws InterruptedException{
		wait.waitClickability(correctTF);
		correctTF.click();
		trueGrade.clear();
		trueGrade.sendKeys(gr1);
		falseGrade.clear();
		falseGrade.sendKeys(gr2);
		okButton.click();
		EditQuestionPage page = new EditQuestionPage(driver);
		return page;
	}
}
