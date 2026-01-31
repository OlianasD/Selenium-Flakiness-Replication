package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
	
	
	public AdminSidebar(WebDriver driver) {
		super(driver);
	}
	
	public ProductsPage goToProducts() {
   	    catalog.click();
   	    product.click();
   	    return new ProductsPage(driver);
    }
	
	public StatesPage goToStates() {
		international.click();
		locations.click();
    	return new StatesPage(driver);
	}
	
	public FeaturesPage goToFeatures() {
		catalog.click();
		features.click();
    	return new FeaturesPage(driver);
    }
	
	public AttributesPage goToAttributes() {
		catalog.click();
		features.click();
    	return new AttributesPage(driver);
    }
	
	public AddressesPage goToAddresses() {
    	customers.click();
    	address.click();
    	return new AddressesPage(driver);
    }
	
	public CategoriesPage goToCategories() {
    	catalog.click();
    	category.click();
    	return new CategoriesPage(driver);
    }
	
	public ManufacturerPage goToManufacturer() {
    	catalog.click();
    	manufacturer.click();
    	return new ManufacturerPage(driver);
    }
	
	public EmployeesPage goToEmployees() {
    	administration.click();
    	employees.click();
    	return new EmployeesPage(driver);
    }
	
	public OrdersPage goToOrders() {
		orders.click();
		ordersSubtab.click();
		return new OrdersPage(driver);
	}
	
	public TagsPage goToTags() {
		shopParams.click();
    	shopParamsSearch.click();
    	tags.click();
    	return new TagsPage(driver);
    }
	
	public CurrencyPage goToCurrency() {
		international.click();
    	localization.click();
    	currency.click();
    	return new CurrencyPage(driver);
    }
	
	

}
