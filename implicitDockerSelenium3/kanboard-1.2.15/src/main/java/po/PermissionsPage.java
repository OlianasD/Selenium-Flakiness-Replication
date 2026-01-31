package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PermissionsPage extends ProjectSidebar {
	
	@FindBy(xpath = "//*[@id=\"main\"]/section/div[2]/table/tbody/tr[2]/td[1]")
	protected WebElement firstAllowed;

	public PermissionsPage(WebDriver driver) {
		super(driver);
	}
	
	public String getFirstAllowedUser() {
		return firstAllowed.getText();
	}

}
