package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utils.JavascriptExecutor;
import utils.Wait;

public class AddProductPage {
	WebDriver driver;
	@FindBy(id = "page-header-desc-product-new_product")
	WebElement addNewProduct;
	@FindBy(id = "form_step1_name_1")
	WebElement nameOfProduct;
	@FindBy(id = "submit")
	WebElement submitProduct;
	@FindBy(id = "priceTE")
	WebElement preTaxRetail;
	@FindBy(id = "priceTI")
	WebElement retailPriceWithTax;
	@FindBy(id = "tab_step2")
	WebElement pricesTab;
	@FindBy(id = "id_tax_rules_group")
	WebElement taxRules;
	@FindBy(id = "link-Features")
	WebElement featuresTab;
	@FindBy(xpath = "//*[@id=\"form_step1_name\"]/div/div[1]/ul")
	WebElement alertMsg;
	@FindBy(id = "product_form_save_go_to_catalog_btn")
	WebElement backToCatalogBtn;
	
	protected Wait wait;

	public AddProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
	}

	public void chooseTaxRules10() {
		taxRules.sendKeys("IT Reduced Rate (10%)");
	}

	public AddProductPage submitProduct() {
		submitProduct.click();
		return new AddProductPage(driver);
	}

	public AddProductPage submitError() {
		new JavascriptExecutor(driver).scrollTo(submitProduct);
		submitProduct.click();
		return new AddProductPage(driver);
	}

	public AddProductPage setPretaxRetail(String pretaxPrice) {
		pricesTab.click();
		preTaxRetail.clear();
		preTaxRetail.sendKeys(pretaxPrice);
		return this;
	}

	public AddProductPage addNameOfProduct(String name) {
		nameOfProduct.clear();
		nameOfProduct.sendKeys(name);
		return this;
	}


	public PricesPage prices() {
		pricesTab.click();
		return new PricesPage(driver);
	}

	public String getAlertMessage() {
		wait.waitVisibility(alertMsg);
		return alertMsg.getText();
	}

	public boolean waitForAlertMessageToBe(String expected) {
		return wait.waitForTextToBe(By.xpath("//*[@id=\"form_step1_name\"]/div/div[1]/ul"), expected);
	}

	public ProductsPage backToCatalog() {
		wait.waitClickability(backToCatalogBtn);
		backToCatalogBtn.click();
		return new ProductsPage(driver);
	}
}
