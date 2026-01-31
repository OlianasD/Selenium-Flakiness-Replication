package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.JavascriptExecutor;

public class AddManufacturerPage {
	WebDriver driver;
	@FindBy(id = "manufacturer_name")
	WebElement name;

	public AddManufacturerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ManufacturerPage addManufacturer(String nameStr) {
		name.clear();
		name.sendKeys(nameStr);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement submitMn = driver.findElement(By.xpath("//*[@id=\"main-div\"]/div/div[1]/div/div[2]/div/form/div/div[2]/button"));
		new JavascriptExecutor(driver).scrollTo(submitMn);
		submitMn.click();
		return new ManufacturerPage(driver);
	}

	public AddManufacturerPage addEmptyManufacturer() {
		WebElement submitMn = driver.findElement(By.xpath("//*[@id=\"main-div\"]/div/div[1]/div/div[2]/div/form/div/div[2]/button"));
		new JavascriptExecutor(driver).scrollTo(submitMn);
		submitMn.click();
		return new AddManufacturerPage(driver);
	}

	public String getEmptyNameAlert() {
		return name.getAttribute("validationMessage");
	}
}
