package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeletePage extends PageObject {
	
	@FindBy(id = "wpConfirmB")
	protected WebElement deleteBtn;

	public DeletePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public DeletePage delete() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		deleteBtn.click();
		return new DeletePage(driver);
	}
	
	public String getSuccessMessage() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/p[1]")).getText();
	}

}
