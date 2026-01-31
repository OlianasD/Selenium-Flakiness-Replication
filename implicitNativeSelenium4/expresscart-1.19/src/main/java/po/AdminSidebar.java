package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

	
	public AdminSidebar(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public NewUserPage newUser() {
		newUserBtn.click();
		return new NewUserPage(driver);
	}
	
	public UsersPage users() {
		users.click();
		return new UsersPage(driver);
	}
	
	public AdminLoginPage logout() {
		logout.click();
		return new AdminLoginPage(driver);
	}
	
	public String getDashboardText() {
		return dashboard.getText();
	}
	
	public String getAlertText() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver.findElement(By.className("alert-danger")).getText();
	}
	
	public NewProductPage newProduct() {
		newProductBtn.click();
		return new NewProductPage(driver);
	}
	
	public ProductsPage products() {
		products.click();
		return new ProductsPage(driver);
	}
	
	public DiscountCodesPage discountCodes() {
		discountCodes.click();
		return new DiscountCodesPage(driver);
	}
	
	public MenuPage menu() {
		menu.click();
		return new MenuPage(driver);
	}
	
	public ReviewsPage reviews() {
		reviews.click();
		return new ReviewsPage(driver);
	}
	
	
	

}
