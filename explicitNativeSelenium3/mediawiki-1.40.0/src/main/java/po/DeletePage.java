package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Wait;

public class DeletePage extends PageObject {
	
	@FindBy(id = "wpConfirmB")
	protected WebElement deleteBtn;

	protected Wait wait;

	public DeletePage(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public DeletePage delete() {
		deleteBtn.click();
		return new DeletePage(driver);
	}

	public boolean waitForSuccessMessageToBe(String expected) {
		return wait.waitForTextToBe(By.xpath("//*[@id=\"mw-content-text\"]/p[1]"), expected);
	}

}
