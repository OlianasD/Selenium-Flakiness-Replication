package po;

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
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return tagMessage.getText();
	}

}
