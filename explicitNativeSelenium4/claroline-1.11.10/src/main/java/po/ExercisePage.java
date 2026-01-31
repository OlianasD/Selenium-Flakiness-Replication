package po;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Wait;

public class ExercisePage extends ClarolinePage{

	@FindBy(linkText="New exercise")
	private WebElement newExerciseButton;
	@FindBy(xpath="(//img[@alt='Delete'])[2]")
	private WebElement removeExerciseButton;
	@FindBy(xpath="(//img[@alt='Modify'])[2]")
	private WebElement editExerciseButton;
	@FindBy(xpath="(//img[@alt='Make visible'])[2]")
	private WebElement makeVisible;
	@FindBy(xpath=".//*[@id='courseRightContent']/table/tbody/tr[2]/td[4]/a/img")
	private WebElement visibility;
	@FindBy(linkText="Exercise 001")
	private WebElement exerciseLink;
	@FindBy(xpath="(//img[@alt='Statistics'])[2]")
	private WebElement exeStats;

	protected Wait wait;

	public ExercisePage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
	}
	
	public EditExercisePage newExercise(){
		wait.waitClickability(newExerciseButton);
		newExerciseButton.click();
		EditExercisePage page = new EditExercisePage(driver);
		return page;
	}
	
	public void removeExercise()  {
		wait.waitClickability(removeExerciseButton);
		removeExerciseButton.click();
		wait.waitAlert();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.navigate().refresh();
	}
	
	public EditExercisePage editExercise(){
		wait.waitClickability(editExerciseButton);
		editExerciseButton.click();
		EditExercisePage page = new EditExercisePage(driver);
		return page;
	}
	
	public ExercisePage  makeExerciseVisible() throws InterruptedException{
		wait.waitClickability(makeVisible);
		makeVisible.click();
		return new ExercisePage(driver);
	}
	
	public String getExerciseVisibilityTitle(){
		return wait.waitVisibility(visibility).getAttribute("alt");
	}
	
	public ExerciseSubmitPage goInsideExercise() {
		wait.waitClickability(exerciseLink);
		exerciseLink.click();
		ExerciseSubmitPage page = new ExerciseSubmitPage(driver);
		return page;
	}
	
	public TrackExercisePage viewStats() {
		wait.waitClickability(exeStats);
		exeStats.click();
		TrackExercisePage page = new TrackExercisePage(driver);
		return page;
	}
}
