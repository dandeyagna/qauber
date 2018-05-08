package serega;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class newTest {
	private WebDriver driver;
	@BeforeTest
	public void setUp() {
	System.setProperty("webdriver.chrome.driver", "/Users/serega/Desktop/chromedriver");
    driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	driver.get("http://fits.qauber.com/#/page/login");
	}
	
	@Test
	public void login() throws InterruptedException {
		
		WebElement e = driver.findElement(By.xpath("//*[@id='exampleInputEmail1']"));
		e.sendKeys(new String[] { "iluhaspirid25@yahoo.com" });

		e = driver.findElement(By.xpath("//*[@id='exampleInputPassword1']"));
		e.sendKeys(new String[] { "123456" });

		Thread.sleep(5000);

		e = driver.findElement(By.xpath("//button[text()='Login']"));
		e.click();
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
