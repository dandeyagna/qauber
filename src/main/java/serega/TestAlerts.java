package serega;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAlerts {
	private WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "/Users/serega/Desktop/geckodriver");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/v4");
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

		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		if (text.equals("User or Password is not valid")) {
			System.out.println("Test Case Pass");
		}
		else {
			System.out.println("Test case failed");
		}
		alert.accept();
	}

}
