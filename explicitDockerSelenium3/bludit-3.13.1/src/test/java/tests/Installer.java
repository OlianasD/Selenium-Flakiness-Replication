package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import po.AdminLogin;
import po.UsersPage;

import static org.junit.Assert.assertEquals;

public class Installer extends BaseTest {
	
	@Test
	public void install() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("jspassword")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
	}
	
}
