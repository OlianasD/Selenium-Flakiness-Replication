package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class GeneralSettingsAbstractPage extends AdminSidebar {
	
	@FindBy(id = "nav-general-tab")
	protected WebElement general;
	
	@FindBy(id = "nav-advanced-tab")
	protected WebElement advanced;
	
	@FindBy(id = "nav-social-tab")
	protected WebElement socials;
	
	@FindBy(id = "nav-language-tab")
	protected WebElement language;
	
	@FindBy(xpath = "//*[@id=\"jsform\"]/div[1]/div/button")
	protected WebElement saveBtn;

	public GeneralSettingsAbstractPage(WebDriver driver) {
		super(driver);
	}
	
	public GeneralSettingsPage general() {
		general.click();
		return new GeneralSettingsPage(driver);
	}
	
	public AdvancedSettingsPage advanced() {
		advanced.click();
		return new AdvancedSettingsPage(driver);
	}
	
	public SiteSocialsPage socials() {
		socials.click();
		return new SiteSocialsPage(driver);
	}
	
	public LanguagePage language() {
		language.click();
		return new LanguagePage(driver);
	}

}
