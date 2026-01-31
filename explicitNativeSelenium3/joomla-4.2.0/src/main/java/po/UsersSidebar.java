package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

public class UsersSidebar extends SiteAdminHome {
	
	@FindBy(xpath = "//*[@id=\"collapse4\"]/li[2]/a")
	protected WebElement groups;
	
	protected Wait wait;
	
	public UsersSidebar(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public ManageGroupsPage groups() {
		wait.waitClickability(groups);
		groups.click();
		return new ManageGroupsPage(driver);
	}
	
	

}
