package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AttributesPage extends AdminSidebar {
	
	@FindBy(id = "page-header-desc-attribute_group-new_attribute_group")
    protected WebElement addAttribute;
	
	@FindBy(className = "alert-success")
	protected WebElement tagMessage;

	public AttributesPage(WebDriver driver) {
		super(driver);
	}
	
	public AddAttributePage clickAddAttribute() {
    	addAttribute.click();
    	return new AddAttributePage(driver);
    }
	
	public String getSuccessMessage() {
		wait.waitVisibility(By.className("alert-success"));
		return tagMessage.getText();
	}

	public boolean waitForAlertToContainText(String expected) {
		return wait.waitForTextToBeContained(By.className("alert-success"), expected);
	}

}
