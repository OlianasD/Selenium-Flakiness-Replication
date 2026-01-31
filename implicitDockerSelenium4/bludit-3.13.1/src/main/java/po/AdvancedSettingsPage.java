package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AdvancedSettingsPage extends GeneralSettingsAbstractPage {
	
	@FindBy(id = "select2-jshomepage-container")
	protected WebElement homeField;
	

	public AdvancedSettingsPage(WebDriver driver) {
		super(driver);
	}
	
	public AdvancedSettingsPage setHome(String home) {
		driver.findElement(By.xpath("//*[@id=\"advanced\"]/div[3]/div/span/span[1]/span")).click();
		driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys(home);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id=\"select2-jshomepage-results\"]/li")).click();
		return this;
	}
	
	public AdvancedSettingsPage save() {
		saveBtn.click();
		return new AdvancedSettingsPage(driver);
	}
	
	public AdvancedSettingsPage setPostsOrder(String order) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Select(driver.findElement(By.id("jsorderBy"))).selectByVisibleText(order);
		return this;
	}
	
	public String getPostsOrder() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Select(driver.findElement(By.id("jsorderBy"))).getFirstSelectedOption().getText();
	}
	
	public String getSelectedHome() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return driver.findElement(By.id("select2-jshomepage-container")).getAttribute("title");
	}
	
	

}
