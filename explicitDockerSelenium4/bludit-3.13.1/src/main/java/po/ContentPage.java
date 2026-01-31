package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.Wait;

public class ContentPage extends AdminSidebar {

	@FindBy(xpath = "//tr[1]/td[1]/div[1]/a")
	protected WebElement firstContentTitle;
	
	@FindBy(xpath = "//*[@id=\"pages\"]/table/tbody/tr[1]/td[3]/a[2]")
	protected WebElement firstContentEdit;
	
	@FindBy(xpath = "//*[@id=\"pages\"]/table/tbody/tr[1]/td[2]/a")
	protected WebElement firstElementUrl;
	
	@FindBy(id = "draft-tab")
	protected WebElement draftTab;
	
	@FindBy(id = "sticky-tab")
	protected WebElement stickyTab;
	
	@FindBy(xpath = "//*[@id=\"pages\"]/table/tbody/tr[3]/td[3]/a[2]")
	protected WebElement thirdContentEdit;
	
	@FindBy(xpath = "//*[@id=\"pages\"]/table/tbody/tr[3]/td[3]/a[3]")
	protected WebElement deleteThirdContent;
	
	@FindBy(xpath = "//*[@id=\"jsdeletePageModal\"]/div/div/div[2]/button[2]")
	protected WebElement deleteConfirmBtn;


	public ContentPage(WebDriver driver) {
		super(driver);
	}
	
	public String getFirstContentTitle(String title) {
		wait.waitVisibility(By.linkText(title));
		return driver.findElement(By.linkText(title)).getText();
	}

	public String getFirstContentTitle() {
		wait.waitVisibility(firstContentTitle);
		return firstContentTitle.getText();
	}
	
	public NewContentPage editFirstContent() {
		wait.waitClickability(firstContentEdit);
		firstContentEdit.click();
		return new NewContentPage(driver);
	}
	
	public NewContentPage editThirdContent() {
		wait.waitClickability(thirdContentEdit);
		thirdContentEdit.click();
		return new NewContentPage(driver);
	}
	
	public DraftPage drafts() {
		wait.waitClickability(draftTab);
		draftTab.click();
		return new DraftPage(driver);
	}
	
	public StickyPage sticky() {
		wait.waitClickability(stickyTab);
		stickyTab.click();
		return new StickyPage(driver);
	}
	
	
	public String getFirstElementUrl() {
		wait.waitVisibility(firstElementUrl);
		return firstElementUrl.getText();
	}
	
	public ContentPage deleteThirdElement() {
		wait.waitClickability(deleteThirdContent);
		deleteThirdContent.click();
		return this;
	}
	
	public ContentPage confirmDelete() {
		wait.waitClickability(deleteConfirmBtn);
		deleteConfirmBtn.click();
		return this;
	}
	
	public boolean containsElement(String elem) {
		wait.waitVisibility(driver.findElement(By.id("pages")));
		return driver.findElement(By.id("pages")).getText().contains(elem);
	}

}
