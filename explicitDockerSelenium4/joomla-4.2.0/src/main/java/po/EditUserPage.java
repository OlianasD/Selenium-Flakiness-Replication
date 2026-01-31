package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Wait;

public class EditUserPage extends PageObject {
	
	@FindBy(xpath = "//*[@id=\"myTab\"]/div/button[2]")
	protected WebElement groups;

	protected Wait wait;
	
	public EditUserPage(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public AssignedGroupPage assignedGroups() {
		wait.waitClickability(groups);
		groups.click();
		return new AssignedGroupPage(driver);
	}
	
	
}
