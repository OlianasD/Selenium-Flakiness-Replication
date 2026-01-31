package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SocialNetworksPage extends EditUserPage {
	
	@FindBy(id = "jsfacebook")
	protected WebElement facebook;
	
	@FindBy(id = "jsinstagram")
	protected WebElement instagram;
	
	@FindBy(xpath = "//*[@id=\"jsform\"]/div[1]/div/button")
	protected WebElement saveBtn;

	public SocialNetworksPage(WebDriver driver) {
		super(driver);
	}
	
	public SocialNetworksPage setFb(String fb) {
		facebook.sendKeys(fb);
		return this;
	}
	
	public SocialNetworksPage setIg(String ig) {
		instagram.sendKeys(ig);
		return this;
	}
	
	public UsersPage save() {
		saveBtn.click();
		return new UsersPage(driver);
	}
	
	public String getFb() {
		return facebook.getAttribute("value");
	}
	
	public String getIg() {
		return instagram.getAttribute("value");
	}
	
	
	
	

}
