package po;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Wait;


public class ClarolinePage {
	@FindBy(xpath=".//*[@id='courseRightContent']/div[2]/div[1]")
	private WebElement courseMessage;

	private Wait wait;
	protected WebDriver driver;

	public ClarolinePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);

	}
	public void doLogout(){
		wait.waitClickability(By.linkText("Logout")).click();
	}
	
	public IndexPage doLogoutAndGoHome(){
		/*try {
			wait.waitClickabilityRefreshed(By.linkText("Logout")).click();
		} catch(WebDriverException e) {
			wait.waitClickability(By.linkText("Logout")).click();
		}*/
		wait.waitClickabilityRefreshed(By.linkText("Logout")).click();
		driver.get("http://localhost:3000/claroline11110/claroline/index.php");
		return new IndexPage(driver);
	}
	
	public String getBodyText(WebDriver driver){
		String bodyText = driver.findElement(By.tagName("body")).getText();
		return bodyText;
	}


	public boolean waitForMessageToBe(String expected) {
		return wait.waitForTextToBe(By.xpath(".//*[@id='claroBody']/div[2]/div[1]"), expected);
		/*try {
			return wait.waitForTextToBe(By.xpath(".//*[@id='claroBody']/div[2]/div[1]"), expected);
		} catch(WebDriverException e) {
			System.out.println("!!! CATCH reached in waitForMessageToBe");
			return wait.waitForTextToBe(By.xpath(".//*[@id='claroBody']/div[2]/div[1]"), expected);
		}*/
	}
	
	public String getCourseMessage(){
		/*try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		wait.waitVisibility(courseMessage);
		return courseMessage.getText();
	}
	
}
