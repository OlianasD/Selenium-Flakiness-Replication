package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddAddressPage {
	WebDriver driver;

	@FindBy(id = "page-header-desc-address-new_address")
	WebElement addAddress;
	@FindBy(id = "customer_address_customer_email")
	WebElement email;
	@FindBy(id = "customer_address_alias")
	WebElement alias;
	@FindBy(id = "customer_address_first_name")
	WebElement firstname;
	@FindBy(id = "customer_address_last_name")
	WebElement lastname;
	@FindBy(id = "customer_address_address1")
	WebElement address1;
	@FindBy(id = "customer_address_postcode")
	WebElement postcode;
	@FindBy(id = "customer_address_city")
	WebElement city;
	@FindBy(id = "customer_address_phone")
	WebElement phone;
	@FindBy(id = "customer_address_phone_mobile")
	WebElement phone_mobile;
	@FindBy(name = "id_state")
	WebElement id_state;
	@FindBy(id = "save-button")
	WebElement submitAddress;

	public AddAddressPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickAddAddress() {
		addAddress.click();
	}

	public AddressesPage addAddress(String emailStr, String aliasStr, String firstStr, String lastStr,
			String addressStr, String postStr, String phoneStr, String mobileStr, String cityStr) {
		email.sendKeys(emailStr);
		alias.sendKeys(aliasStr);
		firstname.clear();
		firstname.sendKeys(firstStr);
		lastname.clear();
		lastname.sendKeys(lastStr);
		address1.sendKeys(addressStr);
		postcode.sendKeys(postStr);
		phone.sendKeys(phoneStr);
		phone_mobile.sendKeys(mobileStr);
		city.sendKeys(cityStr);
		submitAddress.click();
		return new AddressesPage(driver);
	}

	public AddAddressPage addEmptyAddress() {
		submitAddress.click();
		return new AddAddressPage(driver);
	}

	public AddressesPage editName(String name) {
		firstname.clear();
		firstname.sendKeys(name);
		submitAddress.click();
		return new AddressesPage(driver);
	}

	public String getEmailEmptyAlert() {
		return email.getAttribute("validationMessage");
	}

}
