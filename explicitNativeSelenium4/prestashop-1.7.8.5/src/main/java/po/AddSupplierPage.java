package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddSupplierPage {
	WebDriver driver;
	@FindBy(id = "page-header-desc-supplier-new_supplier")
	WebElement addSupplier;
	@FindBy(id = "supplier_name")
	WebElement name;
	@FindBy(id = "supplier_address")
	WebElement address;
	@FindBy(id = "supplier_city")
	WebElement city;
	@FindBy(id = "id_country")
	WebElement country;
	@FindBy(xpath = "//*[@id=\"main-div\"]/div/div/div/div[2]/div/form/div/div[2]/button")
	WebElement submitSupplier;
	@FindBy(xpath = "//*[@id=\"content\"]/div[4]/div")
	WebElement alertMsg;

	public AddSupplierPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public SupplierPage addSupplier(String nameStr, String addressStr, String cityStr) {
		name.sendKeys(nameStr);
		address.sendKeys(addressStr);
		city.sendKeys(cityStr);
		submitSupplier.click();
		return new SupplierPage(driver);
	}

	public AddSupplierPage addEmptySupplier() {
		submitSupplier.click();
		return new AddSupplierPage(driver);
	}

	public String getEmptyNameAlert() {
		return name.getAttribute("validationMessage");
	}

	public String getAlertMessage() {
		return alertMsg.getText();
	}

}
