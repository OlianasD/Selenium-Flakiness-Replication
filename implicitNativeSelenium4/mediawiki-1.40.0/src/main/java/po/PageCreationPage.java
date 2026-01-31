package po;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
	
	public PageCreationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isInitialPopupVisible() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div[2]/div[3]/div/span[2]/a")).isDisplayed();
	}
	
	public PageCreationPage closeInitialPopup() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/div[2]/div[3]/div/span[2]/a")).click();
		return new PageCreationPage(driver);
	}
	
	public PageCreationPage closePopups() {
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[3]/div/div[2]/div[2]/div[1]/div[1]/span[3]/a/span[1]")).click();
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
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String keysCtrlEnd = Keys.chord(Keys.CONTROL, Keys.END);
		editTextArea.sendKeys(keysCtrlEnd);
		editTextArea.sendKeys(text);
		return this;
	}
	
	public PageCreationPage addLink(String link) {
		textArea.sendKeys("[[");
		driver.findElement(By.xpath("//*[@id=\"ooui-3\"]/div/div/div/div/div/div[1]/div/input")).sendKeys(link);
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
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new WikiPage(driver);
	}
	
	public PageCreationPage save() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		saveBtn.click();
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
		options.click();
		return this;
	}
	
	public AddCategoryPage categories() {
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[3]/div/div[2]/div[3]/span[2]/a")).click();
		return new AddCategoryPage(driver);
	}
	
	public String getWarning() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/p")).getText();
	}
	
	public String getPermissionErrors() {
		return driver.findElement(By.className("permissions-errors")).getText();
	}
	
	public String getBlankPageWarning() {
		return blankPageWarning.getText();
	}
	
	public PageCreationPage saveEmpty() {
		saveSourceBtn.click();
		return new PageCreationPage(driver);
	}
	

}
