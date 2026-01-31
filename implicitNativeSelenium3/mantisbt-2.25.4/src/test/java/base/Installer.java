package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import po.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Installer {

    public static WebDriver driver;
    protected final static String install_url = "http://localhost:8989/admin/install.php";

    /*public void setupNativeBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen", "--lang=en", "--disable-gpu", "--headless=new", "--screen-info={1920x1080}");
        options.setBrowserVersion("127");
        driver = new ChromeDriver(options);
    }*/

    public void setupRemoteWebdriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox", "--headless=new", "--lang=en", "--disable-gpu", "--screen-info={1920x1080}");
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
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
    public void install() throws InterruptedException {
        setupNativeBrowserNoSeleniumManager();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(install_url);
        driver.findElement(By.id("hostname")).clear();
        driver.findElement(By.id("hostname")).sendKeys("mysql");
        Thread.sleep(1000);
        driver.findElement(By.id("db_username")).clear();
        driver.findElement(By.id("db_username")).sendKeys("mantisbt");
        Thread.sleep(1000);
        driver.findElement(By.id("db_password")).clear();
        driver.findElement(By.id("db_password")).sendKeys("mantisbt");
        Thread.sleep(1000);
        driver.findElement(By.id("admin_username")).clear();
        driver.findElement(By.id("admin_username")).sendKeys("root");
        Thread.sleep(1000);
        driver.findElement(By.id("admin_password")).clear();
        driver.findElement(By.id("admin_password")).sendKeys("e2eW3Bt3s71nGB3nchM4rK");
        Thread.sleep(1000);
        driver.findElement(By.name("go")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Continue")).click();
        Thread.sleep(1000);
        new LoginPage(driver).setUsername("administrator").setPassword("root").login();
        Thread.sleep(1000);
        driver.findElement(By.id("password-current")).sendKeys("root");
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys("e2eW3Bt3s71nGB3nchM4rK");
        Thread.sleep(1000);
        driver.findElement(By.id("password-confirm")).sendKeys("e2eW3Bt3s71nGB3nchM4rK");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"account-update-form\"]/div/div[2]/div[2]/input")).click();
        driver.quit();
        System.out.println("Installation completed.");
    }
}
