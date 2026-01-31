package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

public class AdminSidebar extends PageObject {
	
	@FindBy(xpath = "//*[@id=\"subtab-AdminCatalog\"]/a")
    protected WebElement catalog;
	
	@FindBy(xpath = "//*[@id=\"subtab-AdminProducts\"]/a")
    protected WebElement product;
	
	@FindBy(xpath = "//*[@id=\"subtab-AdminInternational\"]/a/span")
	protected WebElement international;
	
	@FindBy(xpath = "//*[@id=\"subtab-AdminParentCountries\"]/a")
	protected WebElement locations;
	
	@FindBy(id = "subtab-AdminParentAttributesGroups")
	protected WebElement features;
	
	@FindBy(id = "subtab-AdminAttributesGroups")
    protected WebElement attributes;
	
	@FindBy(id = "subtab-AdminParentCustomer")
    protected WebElement customers; 
	
	@FindBy(id = "subtab-AdminAddresses")
    protected WebElement address;
	
	@FindBy(id = "subtab-AdminCategories")
    protected WebElement category;
	
	@FindBy(id = "subtab-AdminParentManufacturers")
    protected WebElement manufacturer;
	
    @FindBy(id = "subtab-AdminSuppliers")
    protected WebElement supplier;
    
    @FindBy(id = "subtab-AdminAdvancedParameters")
    protected WebElement administration;
    
    @FindBy(id = "subtab-AdminParentEmployees")
    protected WebElement employees;
    
    @FindBy(id = "subtab-AdminParentOrders")
    protected WebElement orders;
    
    @FindBy(id = "subtab-AdminOrders")
    protected WebElement ordersSubtab;
    
    @FindBy(id = "subtab-AdminTags")
    protected WebElement tags;
    
    @FindBy(id = "subtab-AdminLanguages")
    protected WebElement language;
    
    @FindBy(id = "subtab-AdminCurrencies")
    protected WebElement currency;
    
    @FindBy(id = "subtab-ShopParameters")
    protected WebElement shopParams;
	
    @FindBy(id = "subtab-AdminParentSearchConf")
	protected WebElement shopParamsSearch;
    
    @FindBy(id = "subtab-AdminParentLocalization")
    protected WebElement localization;
	
    protected Wait wait;
	
	public AdminSidebar(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public ProductsPage goToProducts() {
		wait.waitClickability(catalog);
   	    catalog.click();
		wait.waitVisibility(product);
   	    wait.waitClickability(product);
   	    product.click();
   	    return new ProductsPage(driver);
    }
	
	public StatesPage goToStates() {
		wait.waitClickability(international);
		international.click();
		wait.waitVisibility(locations);
		wait.waitClickability(locations);
		locations.click();
    	return new StatesPage(driver);
	}
	
	public FeaturesPage goToFeatures() {
		wait.waitClickability(catalog);
		catalog.click();
		wait.waitVisibility(features);
		wait.waitClickability(features);
		features.click();
    	return new FeaturesPage(driver);
    }
	
	public AttributesPage goToAttributes() {
		wait.waitClickability(catalog);
		catalog.click();
		wait.waitVisibility(features);
		wait.waitClickability(features);
		features.click();
    	return new AttributesPage(driver);
    }
	
	public AddressesPage goToAddresses() {
		wait.waitClickability(customers);
    	customers.click();
		wait.waitVisibility(address);
    	wait.waitClickability(address);
    	address.click();
    	return new AddressesPage(driver);
    }
	
	public CategoriesPage goToCategories() {
		wait.waitClickability(catalog);
    	catalog.click();
		wait.waitVisibility(category);
    	wait.waitClickability(category);
    	category.click();
    	return new CategoriesPage(driver);
    }
	
	public ManufacturerPage goToManufacturer() {
		wait.waitClickability(catalog);
    	catalog.click();
		wait.waitVisibility(manufacturer);
    	wait.waitClickability(manufacturer);
    	manufacturer.click();
    	return new ManufacturerPage(driver);
    }
	
	public EmployeesPage goToEmployees() {
		wait.waitClickability(administration);
    	administration.click();
		wait.waitVisibility(employees);
    	wait.waitClickability(employees);
    	employees.click();
    	return new EmployeesPage(driver);
    }
	
	public OrdersPage goToOrders() {
		wait.waitClickability(orders);
		orders.click();
		wait.waitVisibility(ordersSubtab);
		wait.waitClickability(ordersSubtab);
		ordersSubtab.click();
		return new OrdersPage(driver);
	}
	
	public TagsPage goToTags() {
		wait.waitClickability(shopParams);
		shopParams.click();
		wait.waitVisibility(shopParamsSearch);
		wait.waitClickability(shopParamsSearch);
    	shopParamsSearch.click();
    	tags.click();
    	return new TagsPage(driver);
    }
	
	public CurrencyPage goToCurrency() {
		wait.waitClickability(international);
		international.click();
		wait.waitVisibility(localization);
		wait.waitClickability(localization);
    	localization.click();
    	currency.click();
    	return new CurrencyPage(driver);
    }
	
	

}
