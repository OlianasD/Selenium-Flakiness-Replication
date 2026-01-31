package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

public class MenuPage extends AdminSidebar {
	
	@FindBy(id = "newNavMenu")
	protected WebElement name;
	
	@FindBy(id = "newNavLink")
	protected WebElement link;
	
	@FindBy(id = "settings-menu-new")
	protected WebElement addMenuBtn;
	
	@FindBy(className = "alert-success")
	protected WebElement alertSuccess;
	
	protected Wait wait;

	public MenuPage(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public MenuPage setName(String mName) {
		name.sendKeys(mName);
		return this;
	}
	
	public MenuPage setLink(String mLink) {
		link.sendKeys(mLink);
		return this;
	}
	
	public MenuPage addMenu() {
		addMenuBtn.click();
		return this;
	}
	
	public String getAlertText() {
		wait.waitVisibility(alertSuccess);
		return alertSuccess.getText();
	}

}
