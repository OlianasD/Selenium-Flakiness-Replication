package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Wait;

public class BlockUserPage extends PageObject {
	
	@FindBy(name = "wpAutoBlock")
	protected WebElement ipBlock;
	
	@FindBy(name = "wpTarget")
	protected WebElement target;
	
	@FindBy(name = "wpExpiry-other")
	protected WebElement expiry;
	
	@FindBy(xpath = "//*[@id=\"ooui-php-27\"]/button")
	protected WebElement blockBtn;

	protected Wait wait;

	public BlockUserPage(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	
	public BlockUserPage setUsername(String usr) {
		target.sendKeys(usr);
		return this;
	}
	
	public BlockUserPage ipBlock() {
		ipBlock.click();
		return this;
	}
	
	public BlockUserPage selectExpiry(String exp) {
		expiry.sendKeys(exp);
		return this;
	}
	
	public BlockUserPage block() {
		blockBtn.click();
		return new BlockUserPage(driver);
	}
	
	public String getMessage() {
		return driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/p")).getText();
	}

	public boolean waitForMessageToContain(String expected) {
		return wait.waitForTextToBeContained(By.xpath("//*[@id=\"mw-content-text\"]/p"), expected);
	}
	
	
	
	

}
