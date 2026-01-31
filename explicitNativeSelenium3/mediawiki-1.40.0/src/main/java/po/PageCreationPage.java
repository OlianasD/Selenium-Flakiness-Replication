package po;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

public class PageCreationPage extends PageObject {
	
	@FindBy(xpath = "//*[@id=\"bodyContent\"]/div[5]/div[1]/div[1]")
	protected WebElement textArea;
	
	@FindBy(xpath = "//*[@id=\"ca-edit\"]/a")
	protected WebElement createSourceBtn;
	
	@FindBy(id = "wpTextbox1")
	protected WebElement sourceTextArea;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/div/div[3]/div/div[1]/div[1]/div[4]/div/span/a/span[3]")
	protected WebElement saveBtn;
	
	@FindBy(id = "wpSave")
	protected WebElement saveSourceBtn;
	
	@FindBy(xpath = "//*[@id=\"bodyContent\"]/div[6]/div[1]/div[1]")
	protected WebElement editTextArea;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/div/div[3]/div/div[1]/div[1]/div[2]/span")
	protected WebElement options;
	
	@FindBy(id = "mw-blankarticle")
	protected WebElement blankPageWarning;
	
	protected Wait wait;
	
	public PageCreationPage(WebDriver driver) {
		super(driver);
		wait = new Wait(driver);
	}
	
	public boolean isInitialPopupVisible() {
		By locator = By.xpath("/html/body/div[5]/div/div/div[1]/div[2]/div[3]/div/span[2]/a");
		wait.waitClickability(locator);
		return driver.findElement(locator).isDisplayed();
	}
	
	public PageCreationPage closeInitialPopup() {
		wait.waitClickability(By.xpath("/html/body/div[5]/div/div/div[1]/div[2]/div[3]/div/span[2]/a")).click();
		return new PageCreationPage(driver);
	}
	
	public PageCreationPage closePopups() {
		By locator = By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[3]/div/div[2]/div[2]/div[1]/div[1]/span[3]/a/span[1]");
		wait.waitClickability(locator);
		driver.findElement(locator).click();
		return new PageCreationPage(driver);
	}
	
	
	public PageCreationPage setText(String text) {
		textArea.click();
		textArea.click();
		textArea.sendKeys(text);
		return this;
	}
	
	public PageCreationPage setSourceText(String text) {
		sourceTextArea.sendKeys(text);
		return this;
	}
	
	public PageCreationPage editText(String text) {
		String keysCtrlEnd = Keys.chord(Keys.CONTROL, Keys.END);
		wait.waitClickability(editTextArea);
		editTextArea.sendKeys(keysCtrlEnd);
		editTextArea.sendKeys(text);
		return this;
	}
	
	public PageCreationPage addLink(String link) {
		textArea.sendKeys("[[");
		By locator = By.xpath("//*[@id=\"ooui-3\"]/div/div/div/div/div/div[1]/div/input");
		wait.waitClickability(locator);
		driver.findElement(locator).sendKeys(link);
		driver.findElement(By.xpath("//*[@id=\"bodyContent\"]/div[5]/div[2]/div[4]/div[1]/div[2]/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/span/a/span[2]")).click();
		textArea.click();
		return this;
	}
	
	
	public PageCreationPage setChangeDescription(String change) {
		driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/textarea")).sendKeys(change);
		return this;
	}
	
	public WikiPage confirmSave() {
		driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div[2]/div[1]/div/div[1]/span/a/span[2]")).click();
		return new WikiPage(driver);
	}
	
	public PageCreationPage save() {
		wait.waitClickability(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[3]/div/div[1]/div[1]/div[4]/div/span/a/span[3]")).click();
		//wait.waitClickability(By.xpath("//span[contains(text(), 'Save changes…')]")).click();
		return new PageCreationPage(driver);
	}
	
	public WikiPage saveSource() {
		saveSourceBtn.click();
		return new WikiPage(driver);
	}
	
	public EditSourcePage createSource() {
		createSourceBtn.click();
		return new EditSourcePage(driver);
	}
	
	public PageCreationPage options() {
		wait.waitClickability(options);
		options.click();
		return this;
	}
	
	public AddCategoryPage categories() {
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[3]/div/div[2]/div[3]/span[2]/a")).click();
		return new AddCategoryPage(driver);
	}
	
	public String getWarning() {
		//By locator = By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/p");
		return wait.waitVisibility(By.xpath("//div[@class='ve-ui-mwNoticesPopupTool-item']/p")).getText();
	}
	
	public String getPermissionErrors() {
		return driver.findElement(By.className("permissions-errors")).getText();
	}

	public boolean waitForPermissionToBe(String expected) {
		return wait.waitForTextToBeContained(By.className("permissions-errors"), expected);
	}
	
	public String getBlankPageWarning() {
		wait.waitVisibility(blankPageWarning);
		return blankPageWarning.getText();
	}
	
	public PageCreationPage saveEmpty() {
		saveSourceBtn.click();
		return new PageCreationPage(driver);
	}
	

}
