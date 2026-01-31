package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FeaturesPage extends AdminSidebar {
	
	@FindBy(id = "subtab-AdminFeatures")
	protected WebElement featuresTab;
	
	@FindBy(id = "page-header-desc-feature-new_feature")
    protected WebElement addFeature;
	
	@FindBy(className = "alert-success")
	protected WebElement tagMessage;

	public FeaturesPage(WebDriver driver) {
		super(driver);
	}
	
	public FeaturesPage goToFeaturesTab() {
		featuresTab.click();
		return new FeaturesPage(driver);
	}
	
	public AddFeaturesPage clickAddFeature() {
    	addFeature.click();
    	return new AddFeaturesPage(driver);
    }
	
	public String getSuccessMessage() {
		wait.waitVisibility(By.className("alert-success"));
		return tagMessage.getText();
	}

	public boolean waitForAlertToContainText(String expected) {
		return wait.waitForTextToBeContained(By.className("alert-success"), expected);
	}

}
