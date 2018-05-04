package serega.Day21;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeTestTest {
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
		
		String iluha = driver.findElement(By.xpath("//span[text()='ili']")).getText(); //this is the name on the upper right corner
	//how to know what text I got from getText method
		//how to compare what I get and expected text
		if(iluha.equals("ili")) {
			System.out.println("You are logged in!");
		}
		else {
			System.out.println("You are not logged in");
		}
		
			//String s = "ili";
			//Assert.assertEquals(s, iluha, "You are logged in");
		
	}
	
//	@AfterTest
//	public void closeBrowser() {
//		driver.quit();
//	}
	
	
}
