package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {
	
	protected WebDriverWait wait;
	
	public Wait(WebDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public Wait(WebDriver driver, long seconds) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
	}
	
	public void waitVisibility(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public WebElement waitVisibility(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void waitClickability(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public WebElement waitClickability(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public boolean waitForTextToBe(By locator, String text) {
		return wait.until(ExpectedConditions.textToBe(locator, text));
	}
	
	public boolean waitForTextToBeContained(By locator, String text) {
		return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}
	
	public boolean waitForTextToDisappear(By locator, String text) {
		return wait.until(ExpectedConditions.invisibilityOfElementWithText(locator, text));
	}
	
	public void waitClickabilityRefreshed(By locator) {
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(locator)));
	}
	
	public void waitStaleness(WebElement element) {
		wait.until(ExpectedConditions.stalenessOf(element));
	}
	
}
