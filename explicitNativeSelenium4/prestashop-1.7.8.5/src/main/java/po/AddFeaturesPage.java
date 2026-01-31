package po;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Wait;

public class AddFeaturesPage {
	WebDriver driver;

	@FindBy(id = "page-header-desc-feature-new_feature")
	WebElement addFeature;
	@FindBy(id = "name_1")
	WebElement name;
	@FindBy(id = "feature_form_submit_btn")
	WebElement submitFeature;

	@FindBy(className = "alert-danger")
	protected WebElement alertMessage;

	protected Wait wait;

	public AddFeaturesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new Wait(driver);
	}

	public void clickAddFeature() {
		addFeature.click();
	}

	public AddFeaturesPage addName(String nameStr) {
		name.sendKeys(nameStr);
		return this;
	}

	public FeaturesPage submitFeature() {
		submitFeature.click();
		return new FeaturesPage(driver);
	}
	
	public AddFeaturesPage submitError() {
		submitFeature.click();
		return new AddFeaturesPage(driver);
	}

	public String getAlertMessage() {
		wait.waitVisibility(alertMessage);
		return alertMessage.getText();
	}

	public boolean waitForAlertMessageToBe(String expected) {
		return wait.waitForTextToBe(By.className("alert-danger"), expected);
	}
}
