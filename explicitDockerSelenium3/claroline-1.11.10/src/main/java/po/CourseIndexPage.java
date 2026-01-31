package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Wait;

public class CourseIndexPage {
	private WebDriver driver;
	@FindBy(id="CLQWZ")
	private WebElement exerciseButton;
	@FindBy(id="CLCAL")
	private WebElement agendaButton;
	@FindBy(id="CLUSR")
	private WebElement usersButton;

	protected Wait wait;

	public CourseIndexPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
	}
	
	public ExercisePage goToExercisePage() {
		wait.waitClickability(exerciseButton);
		exerciseButton.click();
		ExercisePage page = new ExercisePage(driver);
		return page;
	}
	
	public CalendarAgendaPage goToCalendarAgendaPage() {
		wait.waitClickability(agendaButton);
		agendaButton.click();
		CalendarAgendaPage page = new CalendarAgendaPage(driver);
		return page;
	}
	
	public UserPage goToUsersPage() {
		wait.waitClickability(usersButton);
		usersButton.click();
		UserPage page = new UserPage(driver);
		return page;
	}
}
