package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utils.Wait;

public class AdvancedSettingsPage extends GeneralSettingsAbstractPage {
	
	@FindBy(xpath = "//*[@id=\"advanced\"]/div[3]/div/span/span[1]/span")
	protected WebElement homeOuterSelect;
	
	@FindBy(xpath = "/html/body/span/span/span[1]/input")
	protected WebElement homeSearchField;
	
	@FindBy(xpath = "//*[@id=\"select2-jshomepage-results\"]/li")
	protected WebElement homeActualItem;
	
	@FindBy(name = "orderBy")
	protected WebElement orderSelect;
	

	public AdvancedSettingsPage(WebDriver driver) {
		super(driver);
	}
	
	public AdvancedSettingsPage setHome(String home) {
		wait.waitClickability(homeOuterSelect);
		homeOuterSelect.click();
		wait.waitClickability(homeSearchField);
		homeSearchField.sendKeys(home);
		wait.waitForTextToBe(By.xpath("//*[@id=\"select2-jshomepage-results\"]/li"), home);
		homeActualItem.click();
		return this;
	}
	
	public AdvancedSettingsPage save() {
		wait.waitClickability(saveBtn);
		saveBtn.click();
		return new AdvancedSettingsPage(driver);
	}
	
	public AdvancedSettingsPage setPostsOrder(String order) {
		wait.waitClickability(orderSelect);
		new Select(orderSelect).selectByVisibleText(order);
		return this;
	}
	
	public String getPostsOrder() {
		WebElement orderBy = wait.waitClickability(By.name("orderBy"));
		return new Select(orderBy).getFirstSelectedOption().getText();
	}
	
	public String getSelectedHome() {
		return wait.waitClickabilityRefreshed(By.id("select2-jshomepage-container")).getAttribute("title");
	}
	
	

}
