package po;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Wait;

public class SiteAdminPageObject extends PageObject {
	
	
	//@FindBy(xpath = "//*[@id=\"header\"]/div[2]/div[2]/div[3]/div/button/div[2]")
	@FindBy(xpath = "//*[@id=\"header\"]/div[2]/div[2]/div[2]/div/button/div[2]")
	protected WebElement dropDownToggle;

	protected Wait wait;

	public SiteAdminPageObject(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public void logout() {
		wait.waitClickability(dropDownToggle);
		dropDownToggle.click();
		wait.waitClickability(By.linkText("Log out")).click();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.close();
	    driver = driver.switchTo().window(tabs2.get(0));
	    LoggedNavBar bar = new LoggedNavBar(driver);
	    bar.adminLogout();
	}

}
