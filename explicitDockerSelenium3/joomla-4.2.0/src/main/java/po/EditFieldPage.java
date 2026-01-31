package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utils.Wait;

public class EditFieldPage extends PageObject {
	
	@FindBy(id = "jform_title")
	protected WebElement title;
	
	@FindBy(xpath = "//*[@id=\"save-group-children-save\"]/button")
	protected WebElement saveAndCloseBtn;
	
	@FindBy(id = "jform_group_id")
	protected WebElement groupSelect;
	
	@FindBy(xpath = "//*[@id=\"jform_title-lbl\"]/span[2]")
	protected WebElement emptyTitleAlert;
	
	protected Wait wait;
	
	public EditFieldPage(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public EditFieldPage setTitle(String ttl) {
		wait.waitClickability(title);
		title.sendKeys(ttl);
		return this;
	}
	
	public EditFieldPage selectGroup(String group) {
		wait.waitClickability(groupSelect);
		new Select(groupSelect).selectByVisibleText(group);
		return this;
	}
	
	public ManageFieldsPage saveAndClose() {
		wait.waitClickability(saveAndCloseBtn);
		saveAndCloseBtn.click();
		return new ManageFieldsPage(driver);
	}
	
	public EditFieldPage saveError() {
		wait.waitClickability(saveAndCloseBtn);
		saveAndCloseBtn.click();
		return new EditFieldPage(driver);
	}
	
	public String getEmptyTitleAlert() {
		wait.waitVisibility(emptyTitleAlert);
		return emptyTitleAlert.getText();
	}
	
	

}
