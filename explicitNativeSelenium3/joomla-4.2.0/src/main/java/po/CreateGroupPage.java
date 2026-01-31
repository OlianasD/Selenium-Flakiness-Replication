package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

public class CreateGroupPage extends PageObject {
	
	@FindBy(id = "jform_title")
	protected WebElement groupTitle;
	
	@FindBy(xpath = "//*[@id=\"save-group-children-save\"]/button")
	protected WebElement saveAndCloseBtn;
	
	@FindBy(xpath = "//*[@id=\"jform_title-lbl\"]/span[2]")
	protected WebElement emptyTitleAlert;
	
	protected Wait wait;
	
	public CreateGroupPage(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public CreateGroupPage setTitle(String title) {
		wait.waitClickability(groupTitle);
		groupTitle.sendKeys(title);
		return this;
	}
	
	public ManageGroupsPage saveAndClose() {
		wait.waitClickability(saveAndCloseBtn);
		saveAndCloseBtn.click();
		return new ManageGroupsPage(driver);
	}
	
	public CreateGroupPage saveError() {
		wait.waitClickability(saveAndCloseBtn);
		saveAndCloseBtn.click();
		return new CreateGroupPage(driver);
	}
	
	public String getEmptyTitleAlert() {
		wait.waitVisibility(emptyTitleAlert);
		return emptyTitleAlert.getText();
	}

}
