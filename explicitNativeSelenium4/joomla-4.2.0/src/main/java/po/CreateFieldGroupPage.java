package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Wait;

public class CreateFieldGroupPage extends PageObject {
	
	@FindBy(id = "jform_title")
	protected WebElement title;
	
	@FindBy(xpath = "//*[@id=\"save-group-children-save\"]/button")
	protected WebElement saveAndCloseBtn;
	
	@FindBy(xpath = "//*[@id=\"jform_title-lbl\"]/span[2]")
	protected WebElement emptyTitleAlert;

	protected Wait wait;
	
	public CreateFieldGroupPage(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public CreateFieldGroupPage setTitle(String ttl) {
		wait.waitClickability(title);
		title.sendKeys(ttl);
		return this;
	}
	
	public ManageFieldGroupsPage saveAndClose() {
		wait.waitClickability(saveAndCloseBtn);
		saveAndCloseBtn.click();
		return new ManageFieldGroupsPage(driver);
	}
	
	public CreateFieldGroupPage saveError() {
		wait.waitClickability(saveAndCloseBtn);
		saveAndCloseBtn.click();
		return new CreateFieldGroupPage(driver);
	}
	
	public String getEmptyTitleAlert() {
		wait.waitVisibility(emptyTitleAlert);
		return emptyTitleAlert.getText();
	}

}
