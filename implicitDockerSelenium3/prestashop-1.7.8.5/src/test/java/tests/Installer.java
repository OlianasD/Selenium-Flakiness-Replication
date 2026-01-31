package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Installer {
	
	protected WebDriver driver;

	public void getRemoteWebdriver() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--no-sandbox", "--headless=new", "--disable-gpu","--lang=it", "--screen-info={1920x1080}");
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*public void getNativeBrowser() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-search-engine-choice-screen", "--disable-gpu", "--headless=new", "--lang=it", "--screen-info={1920x1080}");
		options.setBrowserVersion("127");
		driver = new ChromeDriver(options);
	}*/

	public void setupNativeBrowserNoSeleniumManager() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/User/Downloads/chromedriver-win64-chrome127/chromedriver-win64/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-search-engine-choice-screen", "--headless=new", "--disable-gpu", "--screen-info={1920x1080}", "--lang=it");
		options.setBinary("C:\\Users\\User\\chrome\\win64-127.0.6533.119\\chrome-win64\\chrome.exe");
		driver = new ChromeDriver(options);
	}

	@Test
	public void install() throws InterruptedException {
		getRemoteWebdriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//remember to change the URL: localhost does not work inside Selenium Standalone Chrome
		driver.get("http://localhost:8080/install/");
		new Select(driver.findElement(By.id("langList"))).selectByVisibleText("English (English)");
		driver.findElement(By.id("btNext")).click();
		driver.findElement(By.id("set_license")).click();
		driver.findElement(By.id("btNext")).click();
		driver.findElement(By.id("infosShop")).sendKeys("E2E Web Testing store");
		driver.findElement(By.id("infosActivity_chosen")).click();
		driver.findElement(By.xpath("//*[@id=\"infosActivity_chosen\"]/div/div/input")).sendKeys("Computer");
		driver.findElement(By.xpath("//*[@id=\"infosActivity_chosen\"]/div/div/input")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("infosFirstname")).sendKeys("Dario");
		driver.findElement(By.id("infosName")).sendKeys("Olianas");
		driver.findElement(By.id("infosEmail")).sendKeys("admin@prestashop.com");
		driver.findElement(By.id("infosPassword")).sendKeys("e2eW3Bt3s71nGB3nchM4rK");
		driver.findElement(By.id("infosPasswordRepeat")).sendKeys("e2eW3Bt3s71nGB3nchM4rK");
		driver.findElement(By.id("btNext")).click();
		driver.findElement(By.id("dbServer")).clear();
		driver.findElement(By.id("dbServer")).sendKeys("some-mysql");
		driver.findElement(By.id("dbPassword")).sendKeys("admin");
		driver.findElement(By.id("btTestDB")).click();
		Thread.sleep(7000);
		driver.findElement(By.id("btCreateDB")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("btNext")).click();

		boolean success = new WebDriverWait(driver, 180).until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"install_process_success\"]/div/h2"), "Your installation is finished!"));
		if(success) {
			System.out.println("Setup complete. Now: \n1) access the container using docker exec -it some-prestashop bash\n 2) remove directory \"install\"\n 3) rename \"admin\" directory to \"administrator\" ");
		}
		else {
			System.out.println("!! POSSIBLY an error occurred during the installation. Check you application");
		}
		
		System.out.println("Setup complete.");
		driver.quit();
	}

}
