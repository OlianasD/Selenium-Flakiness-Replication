package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Wait;

public class AddManufacturerPage {
	WebDriver driver;
	@FindBy(id = "page-header-desc-address-new_manufacturer")
	WebElement addManufacturer;
	@FindBy(id = "manufacturer_name")
	WebElement name;
	@FindBy(xpath = "//*[@id=\"main-div\"]/div/div[1]/div/div[2]/div/form/div/div[2]/button")
	WebElement submitManufacturer;
	
	protected Wait wait;

	public AddManufacturerPage(WebDriver driver) {
		this.driver = driver;
		wait = new Wait(driver);
		PageFactory.initElements(driver, this);
	}

	public ManufacturerPage addManufacturer(String nameStr) {
		wait.waitClickability(name);
		name.clear();
		name.sendKeys(nameStr);
		submitManufacturer.click();
		return new ManufacturerPage(driver);
	}

	public AddManufacturerPage addEmptyManufacturer() {
		submitManufacturer.click();
		return new AddManufacturerPage(driver);
	}

	public String getEmptyNameAlert() {
		return name.getAttribute("validationMessage");
	}
}
