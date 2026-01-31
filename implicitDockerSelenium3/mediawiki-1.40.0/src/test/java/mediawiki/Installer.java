package mediawiki;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Installer {
	
	protected WebDriver driver;
	//remember to change the URL: localhost does not work inside Selenium Standalone Chrome
	protected final static String app_url = "http://localhost:8080";

	/*protected void setupNativeBrowser() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-search-engine-choice-screen", "--headless=new", "--disable-gpu", "--screen-info={1920x1080}", "--lang=en");
		options.setBrowserVersion("127");
		driver = new ChromeDriver(options);
	}*/

	protected void setupRemoteWebDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox", "--headless=new", "--disable-gpu", "--screen-info={1920x1080}", "--lang=en");
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setupNativeBrowserNoSeleniumManager() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/User/Downloads/chromedriver-win64-chrome127/chromedriver-win64/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-search-engine-choice-screen", "--headless=new", "--disable-gpu", "--screen-info={1920x1080}", "--lang=en");
		options.setBinary("C:\\Users\\User\\chrome\\win64-127.0.6533.119\\chrome-win64\\chrome.exe");
		driver = new ChromeDriver(options);
	}

	@Test
	public void install() {
		setupRemoteWebDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(app_url);
		driver.findElement(By.linkText("set up the wiki")).click();
		new Select(driver.findElement(By.id("uselang"))).selectByVisibleText("en - English");
		new Select(driver.findElement(By.id("ContLang"))).selectByVisibleText("en - English");
		driver.findElement(By.xpath(("//*[@id=\"bodyContent\"]/div/div[1]/div[2]/form/div[3]/input[2]"))).click();
		driver.findElement(By.xpath("//*[@id=\"bodyContent\"]/div/div[1]/div[8]/form/div/input[3]")).click();
		driver.findElement(By.id("mysql_wgDBserver")).clear();
		driver.findElement(By.id("mysql_wgDBserver")).sendKeys("database");
		driver.findElement(By.id("mysql__InstallUser")).clear();
		driver.findElement(By.id("mysql__InstallUser")).sendKeys("wikiuser");
		driver.findElement(By.id("mysql__InstallPassword")).sendKeys("example");
		driver.findElement(By.xpath("//*[@id=\"bodyContent\"]/div/div[1]/div[2]/form/div[6]/input[3]")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		driver.findElement(By.xpath("//*[@id=\"bodyContent\"]/div/div[1]/div[2]/form/div/input[3]")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		driver.findElement(By.id("config_wgSitename")).sendKeys("E2E Web Testing wiki");
		driver.findElement(By.id("config__AdminName")).sendKeys("admin");
		driver.findElement(By.id("config__AdminPassword")).sendKeys("e2eW3Bt3s71nGB3nchM4rK");
		driver.findElement(By.id("config__AdminPasswordConfirm")).sendKeys("e2eW3Bt3s71nGB3nchM4rK");
		driver.findElement(By.id("config__AdminEmail")).sendKeys("admin@wiki.example");
		driver.findElement(By.id("config_wgPingback")).click();
		driver.findElement(By.xpath("//*[@id=\"bodyContent\"]/div/div[1]/div[2]/form/div[7]/input[3]")).click();
		driver.findElement(By.id("config__RightsProfile_fishbowl")).click();
		WebElement disableEmail = driver.findElement(By.id("config_wgEnableEmail"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", disableEmail);
		disableEmail.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement visualEditor = driver.findElement(By.id("config_ext-VisualEditor"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", visualEditor);
		driver.findElement(By.id("config_ext-CiteThisPage")).click();
		driver.findElement(By.id("config_ext-Echo")).click();
		driver.findElement(By.id("config_ext-Interwiki")).click();
		driver.findElement(By.id("config_ext-Linter")).click();
		driver.findElement(By.id("config_ext-Nuke")).click();
		driver.findElement(By.id("config_ext-ReplaceText")).click();
		driver.findElement(By.id("config_ext-WikiEditor")).click();
		driver.findElement(By.id("config_ext-VisualEditor")).click();
		driver.findElement(By.id("config_ext-CodeEditor")).click();
		driver.findElement(By.id("config__MainCacheType_none")).click();
		driver.findElement(By.xpath("//*[@id=\"bodyContent\"]/div/div[1]/div[2]/form/div[7]/input[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"bodyContent\"]/div/div[1]/div[2]/form/div[3]/input[3]")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id=\"bodyContent\"]/div/div[1]/div[2]/form/div/input[2]")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Setup complete. Now copy the LocalSettings.php into the container");
		driver.quit();
	}

}
