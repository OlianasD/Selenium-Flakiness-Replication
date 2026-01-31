package po;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.Wait;

public class CalendarAgendaPage extends ClarolinePage{
	@FindBy(linkText="Add an event")
	private WebElement add;
	@FindBy(id="title")
	private WebElement title;
	@FindBy(id="fday")
	private WebElement day;
	@FindBy(id="fmonth")
	private WebElement month;
	@FindBy(id="fyear")
	private WebElement year;
	@FindBy(id="location")
	private WebElement location;
	@FindBy(name="submitEvent")
	private WebElement confirm;
	@FindBy(linkText="Clear up event list")
	private WebElement removeEventLink;
	@FindBy(linkText="My desktop")
	private WebElement desktopLink;

	protected Wait wait;
	
	public CalendarAgendaPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
	}
	
	public CalendarAgendaPage addEvent(String tit, String dd, String mm, String yy, String loc) {
		wait.waitClickability(add);
		add.click();
		wait.waitClickability(title);
		title.sendKeys(tit);
		wait.waitClickability(day);
		new Select(day).selectByVisibleText(dd);
		wait.waitClickability(month);
		new Select(month).selectByVisibleText(mm);
		wait.waitClickability(year);
		new Select(year).selectByVisibleText(yy);
		wait.waitClickability(location);
		location.sendKeys(loc);
		wait.waitClickability(confirm);
		confirm.click();
		return new CalendarAgendaPage(driver);
	}
	
	public CalendarAgendaPage removeEvent() {
		wait.waitClickability(removeEventLink);
		removeEventLink.click();
		wait.waitAlert();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return new CalendarAgendaPage(driver);
	}
	
}
