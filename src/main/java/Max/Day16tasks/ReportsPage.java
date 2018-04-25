import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ReportsPage {
	
	public static void enterSuspLastName(WebDriver driver, String suspLastName, String suspLastNameXpath) {
		//enter suspect's last name
		WebElement suspLastNameField = driver.findElement(By.xpath(suspLastNameXpath));
		suspLastNameField.sendKeys(suspLastName);
    	System.out.print("TEST CASE Enter suspect's last name: ");
        if (suspLastNameField.getAttribute("value").equals(suspLastName)) {
        	System.out.println("PASS");
        }else {
        	System.out.println("FAIL");
        }    
	}

	public static void enterSuspFirstName(WebDriver driver, String suspFirstName, String suspFirstNameXpath) {
		//enter suspect's first name
		WebElement suspFirstNameField = driver.findElement(By.xpath(suspFirstNameXpath));
		suspFirstNameField.sendKeys(suspFirstName);
    	System.out.print("TEST CASE Enter suspect's first name: ");
        if (suspFirstNameField.getAttribute("value").equals(suspFirstName)) {
        	System.out.println("PASS");
        }else {
        	System.out.println("FAIL");
        }    
	}

	public static void enterCaseId(WebDriver driver, String caseId, String caseIdXpath) {
		//enter a Case ID number
		WebElement caseIdField = driver.findElement(By.xpath(caseIdXpath));
		caseIdField.sendKeys(caseId);
    	System.out.print("TEST CASE Enter a case id: ");
        if (caseIdField.getAttribute("value").equals(caseId)) {
        	System.out.println("PASS");
        }else {
        	System.out.println("FAIL");
        }    
	}
	
	public static void chooseSuspType(WebDriver driver, String suspType, String suspTypeXpath) {
		//enter suspect type
		WebElement suspTypeDropdown = driver.findElement(By.xpath(suspTypeXpath));
		Select suspTypeDropdownSelect = new Select(suspTypeDropdown);
		suspTypeDropdownSelect.selectByVisibleText(suspType);
    	System.out.print("TEST CASE Enter a suspect type: ");
        if (suspTypeDropdown.getAttribute("value").equals(suspType)) {
        	System.out.println("PASS");
        }else {
        	System.out.println("FAIL");
        }    
	}
	
	public static void togglePubCheckbox(WebDriver driver, String publishedCheckboxXpath) {
		//toggle Published On checkbox
		WebElement publishedCheckbox = driver.findElement(By.xpath(publishedCheckboxXpath));
		publishedCheckbox.click();
	}
	
	public static void enterContainsText(WebDriver driver, String containsText, String containsTextXpath) {
		//enter suspect's last name
		WebElement containsTextField = driver.findElement(By.xpath(containsTextXpath));
		containsTextField.sendKeys(containsText);
    	System.out.print("TEST CASE Enter contains text: ");
        if (containsTextField.getAttribute("value").equals(containsText)) {
        	System.out.println("PASS");
        }else {
        	System.out.println("FAIL");
        }    
	}

	public static void clickClearFilter(WebDriver driver, String clearFiltersXpath, String suspLastNameXpath, String suspFirstNameXpath, String caseIdXpath, String suspTypeXpath, String publishedCheckboxXpath, String containsTextXpath) {
		WebElement clearFilterButton = driver.findElement(By.xpath(clearFiltersXpath));
		WebElement suspLastNameField = driver.findElement(By.xpath(suspLastNameXpath));
		WebElement suspFirstNameField = driver.findElement(By.xpath(suspFirstNameXpath));
		WebElement caseIdField = driver.findElement(By.xpath(caseIdXpath));
		WebElement suspTypeDropdown = driver.findElement(By.xpath(suspTypeXpath));
		WebElement containsTextField = driver.findElement(By.xpath(containsTextXpath));

		clearFilterButton.click();
	
    	System.out.print("TEST CASE Clear all filters: ");
        if (suspLastNameField.getAttribute("value").equals("") && 
        	suspFirstNameField.getAttribute("value").equals("") && 
        	caseIdField.getAttribute("value").equals("") && 
        	containsTextField.getAttribute("value").equals("") && 
            suspTypeDropdown.getAttribute("value").equals("")) {
        	System.out.println("PASS");
        }else {
        	System.out.println("FAIL");
        }   
	}
	
	//public static void enterPubStartDate(WebDriver driver, String pubStartDate, String pubStartXpath) {
		//enter the Published day start 
	//	WebElement pubStartField = driver.findElement(By.xpath(pubStartXpath));
	//	pubStartField.click();
	//}

}
