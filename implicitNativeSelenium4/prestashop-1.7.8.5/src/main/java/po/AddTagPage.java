package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddTagPage {
	WebDriver driver;
	@FindBy(id = "page-header-desc-tag-new_tag")
	WebElement addTag;
	@FindBy(id = "name")
	WebElement name;
	@FindBy(id = "tag_form_submit_btn")
	WebElement submitTag;
	@FindBy(xpath = "//*[@id=\"form-supplier\"]/div/div[2]/table/tbody/tr/td[6]/div/div/ul/li[3]/a")
	WebElement remove;
	@FindBy(xpath = "//*[@id=\"content\"]/div[3]/div")
	WebElement alertMsg;
	
	public AddTagPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public TagsPage addTag(String nameStr) {
		name.sendKeys(nameStr);
		submitTag.click();
		return new TagsPage(driver);
	}
	
	public AddTagPage addEmptyTag() {
		submitTag.click();
		return new AddTagPage(driver);
	}
	
	public String getAlertMessage() {
		return alertMsg.getText();
	}

}
