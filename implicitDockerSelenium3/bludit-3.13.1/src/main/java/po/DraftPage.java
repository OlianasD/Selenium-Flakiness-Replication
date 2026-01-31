package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DraftPage extends AdminSidebar {
	
	@FindBy(xpath = "//*[@id=\"draft\"]/table/tbody/tr/td[1]/div[1]/a")
	protected WebElement firstDraftTitle;
	
	public DraftPage(WebDriver driver) {
		super(driver);
	}
	
	public String getFirstDraftTitle() {
		return firstDraftTitle.getText();
	}

}
