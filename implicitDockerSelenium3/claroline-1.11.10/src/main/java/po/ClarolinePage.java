package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ClarolinePage {

	private final String app_url = "http://localhost:3000/claroline11110/claroline/index.php";
	@FindBy(linkText="Logout")
	private WebElement logout;
	@FindBy(xpath=".//*[@id='claroBody']/div[2]/div[1]")
	private WebElement message;
	@FindBy(xpath=".//*[@id='courseRightContent']/div[2]/div[1]")
	private WebElement courseMessage;
	
	public void doLogout(){
		logout.click();
	}
	
	public IndexPage doLogoutAndGoHome(WebDriver driver){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logout.click();
		driver.get(app_url);
		return new IndexPage(driver);
	}
	
	public String getBodyText(WebDriver driver){
		String bodyText = driver.findElement(By.tagName("body")).getText();
		return bodyText;
	}
	
	public String getMessage(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return message.getText();
	}
	
	public String getCourseMessage(){
		return courseMessage.getText();
	}
	
}
