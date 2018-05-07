package serega;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLoginPage {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/serega/Desktop/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		driver.get("http://fits.qauber.com/#/page/login");
		// String t = driver.getTitle();
		WebElement e = driver.findElement(By.xpath("//*[@id='exampleInputEmail1']"));
		e.sendKeys(new String[] { "iluhaspirid25@yahoo.com" });

		e = driver.findElement(By.xpath("//*[@id='exampleInputPassword1']"));
		e.sendKeys(new String[] { "123456" });

		Thread.sleep(5000);

		e = driver.findElementByXPath("//button[text()='Login']");
		e.click();

		Thread.sleep(5000);
		e = driver.findElement(By.xpath("//span[text()='Add Report']"));
		e.click();

		Thread.sleep(5000);
		e = driver.findElement(By.xpath("//div[@title='Subject Information']"));
		e.click();

		Thread.sleep(3000);
		e = driver.findElement(By.name("caseNumber"));
		e.sendKeys("98765");

		e = driver.findElement(By.name("lastName"));
		e.sendKeys("Kosh");

		e = driver.findElement(By.name("firstName"));
		e.sendKeys("Siroga");

		// Thread.sleep(5000);
		e = driver.findElement(By.xpath("//select[@ng-model='wizard.report.suspectType']/option[text()='Victim']"));
		e.click();

		// Thread.sleep(5000);
		e = driver.findElement(By.xpath("//select[@ng-model='wizard.report.sex']/option[text()='F']"));
		e.click();

		// Thread.sleep(5000);
		e = driver.findElement(By.xpath("//select[@ng-model='wizard.report.race']/option[text()='Cambodian']"));
		e.click();

		// Thread.sleep(5000);
		e = driver.findElement(By.xpath("//select[@ng-model='wizard.report.sex']/option[text()='F']"));
		e.click();

		// Thread.sleep(5000);
		e = driver.findElement(By.xpath("//select[@ng-model='wizard.report.build']/option[text()='Medium']"));
		e.click();

		// Thread.sleep(5000);
		e = driver.findElement(By.xpath("//select[@ng-model='wizard.report.hairColor']/option[text()='Green']"));
		e.click();

		// Thread.sleep(5000);
		e = driver.findElement(By.xpath("//select[@ng-model='wizard.report.hairLength']/option[text()='Shaved']"));
		e.click();

		// Thread.sleep(5000);
		e = driver.findElement(By.xpath("//select[@ng-model='wizard.report.hairStyle']/option[text()='Curly']"));
		e.click();

		// Thread.sleep(5000);
		e = driver.findElement(By.xpath("//select[@ng-model='wizard.report.eyeColor']/option[text()='Blue']"));
		e.click();

		// Thread.sleep(5000);
		e = driver.findElement(By.xpath("//select[@ng-model='wizard.report.complexion']/option[text()='Dark']"));
		e.click();

		// Thread.sleep(5000);
		e = driver.findElement(By.xpath("//select[@ng-model='wizard.report.teeth']/option[text()='Gold']"));
		e.click();

		e = driver.findElement(By.name("Height"));
		e.sendKeys("181");

		e = driver.findElement(By.name("Weight"));
		e.sendKeys("81");

		e = driver.findElement(By.name("street-address"));
		e.sendKeys("2045 California St");

		e = driver.findElement(By.xpath("//select[@ng-model='wizard.report.country']/option[text()='United States']"));
		e.click();

		e = driver.findElement(By.name("city"));
		e.sendKeys("Palo Alto");
		
		
		e = driver.findElement(By.xpath("//input[@ng-model='wizard.report.dob']"));
		e.clear();
		e.sendKeys("12302001");

		List<WebElement> eList = driver.findElementsByXPath("//*[@class='radio c-radio']//label");
		for (WebElement e1 : eList) {
			// WebElement t = e1.findElement(By.xpath("label"));
			String x = e1.getText();
			System.out.println(x);
			if (x.equals("Passenger")) {
				WebElement r = e1.findElement(By.xpath("span"));
				r.click();
			}
		}
		// e = driver.findElement(By.xpath("//*[@class='radio c-radio']/label/span"));
		// e.click();
		// String x = e.getText();
		// if(x.equals("Passenger")) {
		// WebElement r = e.findElement(By.xpath("span"));
		// r.click();

		Thread.sleep(10000);

		e = driver.findElement(By.xpath("//a[@ng-click='wizard.go(3)']"));
		e.click();

		e = driver.findElementByXPath("//div[@title='Gang Membership']");
		e.click();

		Thread.sleep(5000);

		/*
		 * List<WebElement> gangUnitCheckBoxes =
		 * driver.findElementsByXPath("//*[@class='col-md-2']//label"); for(WebElement
		 * e2 : gangUnitCheckBoxes){ String x2 = e.getText(); if(x2.equals("Robbery") ||
		 * x.equals("Narco")){ WebElement r2 = e.findElement(By.xpath("span"));
		 * e.click();
		 */

		e = driver.findElement(By.xpath("//input[@ng-model='wizard.report.sexCrimes']"));
		// + "/span[text()='Sex Crimes']"));
		e.click();

		e = driver.findElement(By.xpath("//input[@ng-model='wizard.report.viceIntel']"));
		e.click();
	}
	// driver.findElement(By.xpath("//select[@ng-model='wizard.report.suspectType']/option"));
	/*
	 * List<WebElement> eList =
	 * driver.findElementsByXPath("//select[@ng-model='wizard.report.suspectType']")
	 * ; for(WebElement e1 : eList ){ WebElement t =
	 * e.findElement(By.xpath("label")); String x = t.getText();
	 * System.out.println(x); if(x.equals("Victim")){ WebElement r =
	 * t.findElement(By.xpath("span")); r.click(); // WebElement t =
	 * e.findElement(By.xpath("label")); // String x = t.getText();
	 * //System.out.println(x); //if(x.equals("Victim")) { e.click();
	 */
}
