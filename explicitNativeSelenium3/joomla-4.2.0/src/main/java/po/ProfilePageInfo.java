package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

public class ProfilePageInfo extends LoggedNavBar {
	
	@FindBy(xpath = "//*[@id=\"users-profile-core\"]/dl/dd[1]")
	protected WebElement name;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[3]/ul/li/a")
	protected WebElement editBtn;
	
	protected Wait wait;
	
	public ProfilePageInfo(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public String getName() {
		wait.waitVisibility(name);
		return name.getText();
	}
	
	public EditProfilePage editProfile() {
		wait.waitClickability(editBtn);
		editBtn.click();
		return new EditProfilePage(driver);
	}
	
	

}
