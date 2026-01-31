package base;

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

    protected final static String install_url = "http://localhost:8989/admin/install.php";

    @Test
    public void install() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen", "--disable-gpu", "--headless=new", "--screen-info={1920x1080}");
        options.setBrowserVersion("127");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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
