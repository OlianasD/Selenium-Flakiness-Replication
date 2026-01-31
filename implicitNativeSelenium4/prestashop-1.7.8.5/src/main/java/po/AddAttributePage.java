package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddAttributePage {
	WebDriver driver;

	@FindBy(id = "page-header-desc-attribute_group-new_attribute_group")
	WebElement addAttribute;
	@FindBy(id = "name_1")
	WebElement name;
	@FindBy(id = "public_name_1")
	WebElement public_name;
	@FindBy(id = "attribute_group_form_submit_btn")
	WebElement submitAttribute;
	@FindBy(className = "alert-danger")
	WebElement alertMsg;

	public AddAttributePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickAddAttribute() {
		addAttribute.click();
	}

	public AddAttributePage setName(String nameStr) {
		name.sendKeys(nameStr);
		return this;
	}

	public AddAttributePage setPublicName(String pubNameStr) {
		public_name.sendKeys(pubNameStr);
		return this;
	}

	public AttributesPage submitAttribute() {
		submitAttribute.click();
		return new AttributesPage(driver);
	}
	
	public AddAttributePage submitError() {
		submitAttribute.click();
		return new AddAttributePage(driver);
	}

	public String getAlertMessage() {
		return alertMsg.getText();
	}
}
