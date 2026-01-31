package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExerciseSubmitPage extends ClarolinePage{
	private WebDriver driver;
	@FindBy(name="cmdOk")
	private WebElement okButton;
	@FindBy(xpath="html/body/div[1]/div[2]/div[2]/div[3]/div[2]/form/div[1]/div/strong")
	private WebElement getResultMsg;
	
	public ExerciseSubmitPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public ExerciseSubmitPage doExercise() throws InterruptedException{
		WebElement ans1 = driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div[3]/div[2]/form/table/tbody[1]/tr/td/table/tbody/tr[1]/td[1]/input"));
		WebElement ans2 = driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div[3]/div[2]/form/table/tbody[2]/tr/td/table/tbody/tr[1]/td[1]/input"));
		WebElement ans3 = driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div[3]/div[2]/form/table/tbody[3]/tr/td/table/tbody/tr[1]/td[1]/input"));
		ans1.click();
		ans2.click();
		ans3.click();
		okButton.click();
		return new ExerciseSubmitPage(driver);
	}
	
	public ExerciseSubmitPage doExerciseN(int a, int b, int c) throws InterruptedException{
		WebElement ans1 = driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div[3]/div[2]/form/table/tbody[1]/tr/td/table/tbody/tr["+a+"]/td[1]/input"));
		WebElement ans2 = driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div[3]/div[2]/form/table/tbody[2]/tr/td/table/tbody/tr["+b+"]/td[1]/input"));
		WebElement ans3 = driver.findElement(By.xpath("html/body/div[1]/div[2]/div[2]/div[3]/div[2]/form/table/tbody[3]/tr/td/table/tbody/tr["+c+"]/td[1]/input"));
		ans1.click();
		ans2.click();
		ans3.click();
		okButton.click();
		return new ExerciseSubmitPage(driver);
	}
	
	public String getResult(){
		return getResultMsg.getText();
	}
	
}
