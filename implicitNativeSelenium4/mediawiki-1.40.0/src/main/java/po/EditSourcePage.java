package po;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSourcePage extends PageObject {
	
	@FindBy(id = "wpTextbox1")
	protected WebElement sourceTextArea;
	
	@FindBy(id = "wpSave")
	protected WebElement saveSourceBtn;

	public EditSourcePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public EditSourcePage closePopup() {
		driver.findElement(By.xpath("//*[@id=\"wikiEditor-ui-toolbar\"]/div[1]/div[1]/div[1]/div/div/div[1]/div[1]/span[3]/a/span[1]")).click();
		return this;
	}
	
	public EditSourcePage editStart(String text) {
		sourceTextArea.click();
		String keysCtrlHome = Keys.chord(Keys.CONTROL, Keys.HOME);
		sourceTextArea.sendKeys(keysCtrlHome);
		sourceTextArea.sendKeys(text);
		return this;
	}
	
	public EditSourcePage setSourceText(String text) {
		sourceTextArea.sendKeys(text);
		return this;
	}
	
	public WikiPage saveSource() {
		saveSourceBtn.click();
		return new WikiPage(driver);
	}

}
