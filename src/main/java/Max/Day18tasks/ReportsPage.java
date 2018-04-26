import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ReportsPage {
	
	//enter suspect's last name
	public static void enterSuspLastName(WebDriver driver, String suspLastName, String suspLastNameXpath) {
		WebElement suspLastNameField = driver.findElement(By.xpath(suspLastNameXpath));
		suspLastNameField.sendKeys(suspLastName);
        if (suspLastNameField.getAttribute("value").equals(suspLastName)) {
        	System.out.println("PASS: Enter suspect's last name");
        }else {
        	System.out.println("FAIL: Enter suspect's last name");
        }    
	}

	//enter suspect's first name
	public static void enterSuspFirstName(WebDriver driver, String suspFirstName, String suspFirstNameXpath) {
		WebElement suspFirstNameField = driver.findElement(By.xpath(suspFirstNameXpath));
		suspFirstNameField.sendKeys(suspFirstName);
        if (suspFirstNameField.getAttribute("value").equals(suspFirstName)) {
        	System.out.println("PASS: Enter suspect's first name");
        }else {
        	System.out.println("FAIL: Enter suspect's first name");
        }    
	}

	//enter a Case ID number
	public static void enterCaseId(WebDriver driver, String caseId, String caseIdXpath) {
		WebElement caseIdField = driver.findElement(By.xpath(caseIdXpath));
		caseIdField.sendKeys(caseId);
        if (caseIdField.getAttribute("value").equals(caseId)) {
        	System.out.println("PASS: Enter a case id");
        }else {
        	System.out.println("FAIL: Enter a case id");
        } 
	}
	
	//enter suspect type
	public static void chooseSuspType(WebDriver driver, String suspType, String suspTypeXpath) {
		WebElement suspTypeDropdown = driver.findElement(By.xpath(suspTypeXpath));
		Select suspTypeDropdownSelect = new Select(suspTypeDropdown);
		suspTypeDropdownSelect.selectByVisibleText(suspType);  	
        if (suspTypeDropdown.getAttribute("value").equals(suspType)) {
        	System.out.println("PASS: Enter a suspect type");
        }else {
        	System.out.println("FAIL: Enter a suspect type");
        }    
	}
	
	//toggle Published On checkbox
	public static void togglePubCheckbox(WebDriver driver, String publishedCheckboxXpath) {
		driver.findElement(By.xpath(publishedCheckboxXpath)).click();
	}
	
	//enter suspect's last name
	public static void enterContainsText(WebDriver driver, String containsText, String containsTextXpath) {
		WebElement containsTextField = driver.findElement(By.xpath(containsTextXpath));
		containsTextField.sendKeys(containsText);
        if (containsTextField.getAttribute("value").equals(containsText)) {
        	System.out.println("PASS: Enter contains text");
        }else {
        	System.out.println("FAIL: Enter contains text");
        }    
	}

	//click the clear filters button
	public static void clickClearFilter(WebDriver driver, String clearFiltersXpath, String suspLastNameXpath, String suspFirstNameXpath, String caseIdXpath, String suspTypeXpath, String publishedCheckboxXpath, String containsTextXpath) {
		driver.findElement(By.xpath(clearFiltersXpath)).click();
        if (driver.findElement(By.xpath(suspLastNameXpath)).getAttribute("value").equals("") && 
        	driver.findElement(By.xpath(suspFirstNameXpath)).getAttribute("value").equals("") && 
        	driver.findElement(By.xpath(caseIdXpath)).getAttribute("value").equals("") && 
        	driver.findElement(By.xpath(containsTextXpath)).getAttribute("value").equals("") && 
        	driver.findElement(By.xpath(suspTypeXpath)).getAttribute("value").equals("")) {
        	System.out.println("PASS: Clear all filters");
        }else {
        	System.out.println("FAIL: Clear all filters");
        }   
	}
	
	//enter the Published day start 
	public static void enterPubStartDate(WebDriver driver, String pubStartDate, String pubStartXpath) throws InterruptedException {
		WebElement dateFrom = driver.findElement(By.xpath("//input[@placeholder='Date From ...']"));
		dateFrom.click();
		driver.findElements(By.xpath(".//*[@class='uib-day text-center ng-scope']")).get(5 + 5).click();
	    if (dateFrom.getAttribute("value").equals("04/05/2018")) {
        	System.out.println("PASS: Enter published from date");
        }else {
        	System.out.println("FAIL: Enter published from date");
        }    
		
		WebElement dateTo = driver.findElement(By.xpath("//input[@placeholder='Date To ...']"));
		dateTo.click();
		driver.findElements(By.xpath(".//*[@class='uib-day text-center ng-scope']")).get(25 + 5).click();
	    if (dateTo.getAttribute("value").equals("04/25/2018")) {
        	System.out.println("PASS: Enter published to date");
        }else {
        	System.out.println("FAIL: Enter published to date");
        }    
		
		WebElement createdFrom = driver.findElement(By.xpath("//input[@placeholder='Created From ...']"));
		createdFrom.click();
		driver.findElements(By.xpath(".//*[@class='uib-day text-center ng-scope']")).get(10 + 5).click();
	    if (createdFrom.getAttribute("value").equals("04/10/2018")) {
        	System.out.println("PASS: Enter created from date");
        }else {
        	System.out.println("FAIL: Enter created from date");
        }    
		
    	WebElement createdTo = driver.findElement(By.xpath("//input[@placeholder='Created To ...']"));
    	createdTo.click();
		driver.findElements(By.xpath(".//*[@class='uib-day text-center ng-scope']")).get(20 + 5).click();

	    if (createdTo.getAttribute("value").equals("04/20/2018")) {
        	System.out.println("PASS: Enter created to date");
        }else {
        	System.out.println("FAIL: Enter created to date");
        }    
	}

}
