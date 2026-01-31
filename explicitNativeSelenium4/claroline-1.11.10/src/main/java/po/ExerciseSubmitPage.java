package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Wait;

public class ExerciseSubmitPage extends ClarolinePage{
	@FindBy(name="cmdOk")
	private WebElement okButton;
	@FindBy(xpath="html/body/div[1]/div[2]/div[2]/div[3]/div[2]/form/div[1]/div/strong")
	private WebElement getResultMsg;
	
	protected Wait wait;
	
	public ExerciseSubmitPage(WebDriver driver){
		super(driver);
		wait = new Wait(driver);
		PageFactory.initElements(driver, this);
	}
	
	public ExerciseSubmitPage doExercise(int a, int b, int c) {
		WebElement ans1 = wait.waitClickability(By.xpath("html/body/div[1]/div[2]/div[2]/div[3]/div[2]/form/table/tbody[1]/tr/td/table/tbody/tr[1]/td[1]/input"));
		WebElement ans2 = wait.waitClickability(By.xpath("html/body/div[1]/div[2]/div[2]/div[3]/div[2]/form/table/tbody[2]/tr/td/table/tbody/tr[1]/td[1]/input"));
		WebElement ans3 = wait.waitClickability(By.xpath("html/body/div[1]/div[2]/div[2]/div[3]/div[2]/form/table/tbody[3]/tr/td/table/tbody/tr[1]/td[1]/input"));
		ans1.click();
		ans2.click();
		ans3.click();
		wait.waitClickability(okButton);
		okButton.click();
		return new ExerciseSubmitPage(driver);
	}
	
	public ExerciseSubmitPage doExerciseN(int a, int b, int c) {
		WebElement ans1 = wait.waitClickability(By.xpath("html/body/div[1]/div[2]/div[2]/div[3]/div[2]/form/table/tbody[1]/tr/td/table/tbody/tr["+a+"]/td[1]/input"));
		WebElement ans2 = wait.waitClickability(By.xpath("html/body/div[1]/div[2]/div[2]/div[3]/div[2]/form/table/tbody[2]/tr/td/table/tbody/tr["+b+"]/td[1]/input"));
		WebElement ans3 = wait.waitClickability(By.xpath("html/body/div[1]/div[2]/div[2]/div[3]/div[2]/form/table/tbody[3]/tr/td/table/tbody/tr["+c+"]/td[1]/input"));
		ans1.click();
		ans2.click();
		ans3.click();
		wait.waitClickability(okButton);
		okButton.click();
		return new ExerciseSubmitPage(driver);
	}
	
	public String getResult(){
		wait.waitVisibility(getResultMsg);
		return getResultMsg.getText();
	}
	
}
