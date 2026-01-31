package po;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

	public AddFeaturesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
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
		return alertMessage.getText();
	}
}
