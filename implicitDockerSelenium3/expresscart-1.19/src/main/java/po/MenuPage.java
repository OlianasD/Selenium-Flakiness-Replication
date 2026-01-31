package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends AdminSidebar {
	
	@FindBy(id = "newNavMenu")
	protected WebElement name;
	
	@FindBy(id = "newNavLink")
	protected WebElement link;
	
	@FindBy(id = "settings-menu-new")
	protected WebElement addMenuBtn;

	public MenuPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
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
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver.findElement(By.className("alert-success")).getText();
	}

}
