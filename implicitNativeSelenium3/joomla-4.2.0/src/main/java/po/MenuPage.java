package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends PageObject {
	
	@FindBy(linkText = "All Menu Items")
	public WebElement menuItems;
	
	public MenuPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public MenuItemsPage menuItems() {
		menuItems.click();
		return new MenuItemsPage(driver);
	}
	


}
