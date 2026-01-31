package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.Wait;

public class TrackExercisePage {
	private WebDriver driver;

	protected Wait wait;

	public TrackExercisePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
	}
	
	public String getUserName(int i){
		WebElement name = wait.waitVisibility(By.xpath(".//*[@id='courseRightContent']/table[1]/tbody/tr["+(i+2)+"]/td[1]/a"));
		return name.getText();
	}
	
	public String getUserResult(int i){
		WebElement result = wait.waitVisibility(By.xpath(".//*[@id='courseRightContent']/table[1]/tbody/tr["+(i+2)+"]/td[2]"));
		return result.getText();
	}
}
