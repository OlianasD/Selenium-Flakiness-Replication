package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

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
		wait.waitClickability(facebook);
		facebook.sendKeys(fb);
		return this;
	}
	
	public SocialNetworksPage setIg(String ig) {
		wait.waitClickability(instagram);
		instagram.sendKeys(ig);
		return this;
	}
	
	public UsersPage save() {
		wait.waitClickability(saveBtn);
		saveBtn.click();
		return new UsersPage(driver);
	}
	
	public String getFb() {
		wait.waitVisibility(facebook);
		return facebook.getAttribute("value");
	}
	
	public String getIg() {
		wait.waitVisibility(instagram);
		return instagram.getAttribute("value");
	}
	
	
	
	

}
