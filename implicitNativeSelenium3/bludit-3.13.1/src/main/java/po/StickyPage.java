package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StickyPage extends AdminSidebar {
	
	@FindBy(xpath = "//*[@id=\"sticky\"]/table/tbody/tr/td[1]/div[1]/a")
	protected WebElement firstStickyTitle;
	
	public StickyPage(WebDriver driver) {
		super(driver);
	}
	
	public String getFirstStickyTitle() {
		return firstStickyTitle.getText();
	}

}
