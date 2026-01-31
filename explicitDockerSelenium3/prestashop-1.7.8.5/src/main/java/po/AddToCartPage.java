package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Wait;

public class AddToCartPage {
	WebDriver driver;
	@FindBy(id = "customer-search-input")
	WebElement customerSearch;
	@FindBy(xpath = "//*[@id=\"customer-search-block\"]/div/div[4]/div/div/div/div/div[3]/button[1]")
	WebElement choose;
	@FindBy(id = "product-search")
	WebElement product;
	@FindBy(id = "add-product-to-cart-btn")
	WebElement submitaddToProduct;
	@FindBy(id = "quantity-input")
	WebElement qty;
	@FindBy(id = "js-cart-error-block")
	public WebElement tagMessage;
	@FindBy(xpath = "//*[@id=\"form-supplier\"]/div/div[2]/table/tbody/tr/td[6]/div/div/button")
	WebElement dropDownMeny;
	@FindBy(xpath = "//*[@id=\"form-supplier\"]/div/div[2]/table/tbody/tr/td[6]/div/div/ul/li[3]/a")
	WebElement remove;
	
	protected Wait wait;

	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
	}

	public AddToCartPage addCustomerName(String nameStr) {
		customerSearch.sendKeys(nameStr);
		return this;
	}

	public AddToCartPage clickOnChooseCustomer() {
		wait.waitClickability(choose);
		choose.click();
		return new AddToCartPage(driver);
	}

	public AddToCartPage addProductName(String productName) {
		wait.waitClickability(product);
		product.sendKeys(productName);
		return this;
	}

	public AddToCartPage addQuantity(String qtyNo) {
		wait.waitClickability(qty);
		qty.clear();
		qty.sendKeys(qtyNo);
		return this;
	}

	public AddToCartPage submitProductAndFail() {
		submitaddToProduct.click();
		return new AddToCartPage(driver);
	}

	public String getErrorMessage() {
		wait.waitVisibility(tagMessage);
		return tagMessage.getText();
	}

	public boolean waitForErrorMessageToContain(String expected) {
		return wait.waitForTextToBeContained(By.id("js-cart-error-block"), expected);
	}
}
