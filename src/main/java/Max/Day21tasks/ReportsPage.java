package Max.Day21tasks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReportsPage {
	static WebDriver driver = new FirefoxDriver();
	
	@BeforeTest
	public static void setUp() throws InterruptedException {
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	    driver.manage().window().setPosition(new Point(200,100));
	    driver.manage().window().setSize(new Dimension(1600,1200));
	    driver.get("http://fits.qauber.com/#/page/login");
	    Thread.sleep(5000); 
	}
	
	//enter email address
	@Test(description= "Enter email address", groups= {"Quicklook", "Login"}, dataProvider= "email", dataProviderClass= TestData.class)
	public static void enterEmail(String email, String emailFieldXpath) {
		WebElement emailField = driver.findElement(By.xpath(emailFieldXpath));
        emailField.sendKeys(email);
        Assert.assertEquals(email, emailField.getAttribute("value"), "Failed to enter email.");
	}
	
	//enter password
	@Test(groups= {"Quicklook", "Login"}, dependsOnMethods= {"enterEmail"}, dataProvider = "password", dataProviderClass= TestData.class)
	public static void enterPassword(String password, String passwordFieldXpath) {
		WebElement passwordField = driver.findElement(By.xpath(passwordFieldXpath));
		passwordField.sendKeys(password);
		Assert.assertEquals(password, passwordField.getAttribute("value"), "Failed to enter password.");
	}
	
	//click submit button
	@Test(groups= {"Quicklook", "Login"}, dependsOnMethods= {"enterEmail", "enterPassword"}, dataProvider= "submit", dataProviderClass= TestData.class)
	public static void submitLogin(String loginButtonXpath, String homePageUrl) throws InterruptedException {
		Thread.sleep(1500);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(loginButtonXpath))).click();
		wait.until(ExpectedConditions.urlToBe(homePageUrl));
		Assert.assertEquals(homePageUrl, driver.getCurrentUrl(), "Failed to login into the Reports page");
	}	
	
	//enter suspect's last name
	@Test(groups= {"Quicklook", "Reports"}, dependsOnMethods= {"submitLogin"}, dataProvider= "suspLastName", dataProviderClass= TestData.class)
	public static void enterSuspLastName(String suspLastName, String suspLastNameXpath) {
		WebElement suspLastNameField = driver.findElement(By.xpath(suspLastNameXpath));
		suspLastNameField.sendKeys(suspLastName);
		Assert.assertEquals(suspLastName, suspLastNameField.getAttribute("value"), "Failed to enter suspect's last name");
	}

	//enter suspect's first name
	@Test(groups= {"Quicklook", "Reports"}, dependsOnMethods= {"submitLogin"}, dataProvider= "suspFirstName", dataProviderClass= TestData.class)
	public static void enterSuspFirstName(String suspFirstName, String suspFirstNameXpath) {
		WebElement suspFirstNameField = driver.findElement(By.xpath(suspFirstNameXpath));
		suspFirstNameField.sendKeys(suspFirstName);
		Assert.assertEquals(suspFirstName, suspFirstNameField.getAttribute("value"), "Failed to enter suspect's first name");
	}

	//enter a Case ID number
	@Test(groups= {"Quicklook", "Reports"}, dependsOnMethods= {"submitLogin"}, dataProvider= "caseId", dataProviderClass= TestData.class)
	public static void enterCaseId(String caseId, String caseIdXpath) {
		WebElement caseIdField = driver.findElement(By.xpath(caseIdXpath));
		caseIdField.sendKeys(caseId);
		Assert.assertEquals(caseId, caseIdField.getAttribute("value"), "Failed to enter Case ID");
	}
	
	//enter suspect type
	@Test(groups= {"Quicklook", "Reports"}, dependsOnMethods= {"submitLogin"}, dataProvider= "suspType", dataProviderClass= TestData.class)
	public static void chooseSuspType(String suspType, String suspTypeXpath) {
		WebElement suspTypeDropdown = driver.findElement(By.xpath(suspTypeXpath));
		Select suspTypeDropdownSelect = new Select(suspTypeDropdown);
		suspTypeDropdownSelect.selectByVisibleText(suspType);  	
		Assert.assertEquals(suspType, suspTypeDropdown.getAttribute("value"), "Failed to select a suspect type");
	}
	
	//toggle Published On CheckBox
	@Test(groups= {"Quicklook", "Reports"}, dependsOnMethods= {"submitLogin"}, dataProvider= "pubCheckbox", dataProviderClass= TestData.class)
	public static void togglePubCheckbox(String publishedCheckboxXpath) {
		driver.findElement(By.xpath(publishedCheckboxXpath)).click();
	}
	
	//enter contains text
	@Test(groups= {"Quicklook", "Reports"}, dependsOnMethods= {"submitLogin"}, dataProvider= "contains", dataProviderClass= TestData.class)
	public static void enterContainsText(String containsText, String containsTextXpath) {
		WebElement containsTextField = driver.findElement(By.xpath(containsTextXpath));
		containsTextField.sendKeys(containsText);
		Assert.assertEquals(containsText, containsTextField.getAttribute("value"), "Failed to enter 'contains text' field");
	}
	
	//enter the Published days
	@Test(groups= {"Quicklook", "Reports"}, dependsOnMethods= {"submitLogin"})
	public static void enterPubStartDate() {
		WebElement dateFrom = driver.findElement(By.xpath("//input[@placeholder='Date From ...']"));
		dateFrom.click();
		driver.findElements(By.xpath(".//*[@class='uib-day text-center ng-scope']")).get(5 + 5).click();
		Assert.assertEquals("04/05/2018", dateFrom.getAttribute("value"), "Failed to set 'published from' date");
		
		WebElement dateTo = driver.findElement(By.xpath("//input[@placeholder='Date To ...']"));
		dateTo.click();
		driver.findElements(By.xpath(".//*[@class='uib-day text-center ng-scope']")).get(25 + 5).click();
		Assert.assertEquals("04/25/2018", dateTo.getAttribute("value"), "Failed to set 'published until' date");

		WebElement createdFrom = driver.findElement(By.xpath("//input[@placeholder='Created From ...']"));
		createdFrom.click();
		driver.findElements(By.xpath(".//*[@class='uib-day text-center ng-scope']")).get(10 + 5).click();
		Assert.assertEquals("04/10/2018", createdFrom.getAttribute("value"), "Failed to set 'created from' date");
		
    	WebElement createdTo = driver.findElement(By.xpath("//input[@placeholder='Created To ...']"));
    	createdTo.click();
		driver.findElements(By.xpath(".//*[@class='uib-day text-center ng-scope']")).get(20 + 5).click();
		Assert.assertEquals("04/20/2018", createdTo.getAttribute("value"), "Failed to set 'created until' date");
	}
	
	//clear the filters
	@Test(groups= {"Quicklook", "Reports"}, dependsOnMethods= {"enterSuspLastName", "submitLogin" }, dataProvider= "clearFilters", dataProviderClass= TestData.class)
	public static void clickClearFilter(String clearFiltersXpath, String suspLastNameXpath, String suspFirstNameXpath, String caseIdXpath, 
						String suspTypeXpath, String publishedCheckboxXpath, String containsTextXpath) throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath(clearFiltersXpath)).click();
		Assert.assertEquals("", driver.findElement(By.xpath(suspLastNameXpath)).getAttribute("value"), "Failed to clear 'suspect's last name' field");
		Assert.assertEquals("", driver.findElement(By.xpath(suspFirstNameXpath)).getAttribute("value"), "Failed to clear 'suspect's first name' field");
		Assert.assertEquals("", driver.findElement(By.xpath(caseIdXpath)).getAttribute("value"), "Failed to clear 'case ID' field");
		Assert.assertEquals("", driver.findElement(By.xpath(containsTextXpath)).getAttribute("value"), "Failed to clear 'contains text' field");
		Assert.assertEquals("", driver.findElement(By.xpath(suspTypeXpath)).getAttribute("value"), "Failed to clear 'suspect type' field");
	}

}
