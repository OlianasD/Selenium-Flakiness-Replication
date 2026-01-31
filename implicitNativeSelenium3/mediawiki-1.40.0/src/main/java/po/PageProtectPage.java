package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageProtectPage extends PageObject {
	
	@FindBy(xpath = "//*[@id=\"mw-Protect-submit\"]/button")
	protected WebElement confirmBtn;
	
	public PageProtectPage(WebDriver driver) {
		super(driver);
	}
	
	public PageProtectPage selectProtectionLevel() {
		driver.findElement(By.xpath("//*[@id=\"mwProtect-level-edit\"]/div/span")).click();
		driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[3]/span[3]")).click();
		return this;
	}
	
	public String getProtectionLevel() {
		return driver.findElement(By.xpath("//*[@id=\"ooui-1\"]")).getText();
	}
	
	public WikiPage confirm() {
		confirmBtn.click();
		return new WikiPage(driver);
	}
	

}
