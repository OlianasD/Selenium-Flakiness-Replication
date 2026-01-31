package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

public class AdminSidebar extends PageObject {
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/nav/div/ul[1]/li[6]/a[2]")
	protected WebElement newUserBtn;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/nav/div/ul[1]/li[6]/a[1]")
	protected WebElement users;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/nav/div/ul[3]/li/a")
	protected WebElement logout;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/nav/div/ul[1]/li[2]/a")
	protected WebElement dashboard;
	
	@FindBy(xpath ="//*[@id=\"container\"]/div/nav/div/ul[1]/li[3]/a[2]")
	protected WebElement newProductBtn;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/nav/div/ul[1]/li[3]/a[1]")
	protected WebElement products;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/nav/div/ul[2]/li[4]/a")
	protected WebElement discountCodes;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/nav/div/ul[2]/li[2]/a")
	protected WebElement menu;
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/nav/div/ul[1]/li[8]/a")
	protected WebElement reviews;
	
	@FindBy(className = "alert-danger")
	protected WebElement alert;
	
	protected Wait wait;

	
	public AdminSidebar(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public NewUserPage newUser() {
		wait.waitClickability(newUserBtn);
		newUserBtn.click();
		return new NewUserPage(driver);
	}
	
	public UsersPage users() {
		wait.waitClickability(users);
		users.click();
		return new UsersPage(driver);
	}
	
	public AdminLoginPage logout() {
		wait.waitClickability(logout);
		logout.click();
		return new AdminLoginPage(driver);
	}
	
	public String getDashboardText() {
		wait.waitVisibility(dashboard);
		return dashboard.getText();
	}
	
	public String getAlertText() {
		wait.waitVisibility(alert);
		return alert.getText();
	}
	
	public NewProductPage newProduct() {
		wait.waitClickability(newProductBtn);
		newProductBtn.click();
		return new NewProductPage(driver);
	}
	
	public ProductsPage products() {
		wait.waitClickability(products);
		products.click();
		return new ProductsPage(driver);
	}
	
	public DiscountCodesPage discountCodes() {
		wait.waitClickability(discountCodes);
		discountCodes.click();
		return new DiscountCodesPage(driver);
	}
	
	public MenuPage menu() {
		wait.waitClickability(menu);
		menu.click();
		return new MenuPage(driver);
	}
	
	public ReviewsPage reviews() {
		wait.waitClickability(reviews);
		reviews.click();
		return new ReviewsPage(driver);
	}
	
	
	

}
