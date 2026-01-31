package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

public class ContentSidebar extends SiteAdminHome {
	
	@FindBy(xpath = "//*[@id=\"collapse1\"]/li[5]/a")
	protected WebElement fields;
	
	@FindBy(xpath = "//*[@id=\"collapse1\"]/li[6]/a/span")
	protected WebElement fieldGroups;
	
	protected Wait wait;
	
	public ContentSidebar(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public ManageFieldsPage fields() {
		wait.waitClickability(fields);
		fields.click();
		return new ManageFieldsPage(driver);
	}
	
	public ManageFieldGroupsPage fieldGroups() {
		wait.waitClickability(fieldGroups);
		fieldGroups.click();
		return new ManageFieldGroupsPage(driver);
	}

}
