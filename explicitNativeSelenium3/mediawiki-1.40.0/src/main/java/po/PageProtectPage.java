package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Wait;

public class PageProtectPage extends PageObject {
	
	@FindBy(xpath = "//*[@id=\"mw-Protect-submit\"]/button")
	protected WebElement confirmBtn;

	protected Wait wait;
	
	public PageProtectPage(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public PageProtectPage selectProtectionLevel() {
		wait.waitClickability(By.xpath("//*[@id=\"mwProtect-level-edit\"]/div/span")).click();
		wait.waitClickability(By.xpath("/html/body/div[5]/div[1]/div[3]/span[3]")).click();
		return this;
	}
	
	public String getProtectionLevel() {
		return wait.waitVisibility(By.xpath("//*[@id=\"ooui-1\"]")).getText();
	}
	
	public WikiPage confirm() {
		wait.waitClickability(confirmBtn);
		confirmBtn.click();
		/*try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}*/
		return new WikiPage(driver);
	}
	

}
