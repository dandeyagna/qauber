import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestPages {
	//Login page variables
	private static String url = "http://fits.qauber.com/#/page/login";
	private static String email = "max8987@gmail.com";
	private static String emailFieldXpath = ".//*[@id='exampleInputEmail1']";
	private static String password = "stargate";
	private static String passwordFieldXpath = ".//*[@id='exampleInputPassword1']";
	private static String loginButtonXpath = ".//*[@class='btn btn-block btn-primary mt-lg']";
	private static String forgotPassXpath = ".//*[@class='text-muted']";
	private static String registerNowXpath = ".//*[@class='btn btn-block btn-default']";
	private static String registerPageUrl = "http://fits.qauber.com/#/page/register-sa";
	private static String forgotPassUrl = "http://fits.qauber.com/#/page/recover";
	private static String homePageUrl = "http://fits.qauber.com/#/app/reports";
	
	//Entities page variables
	private static String entitiesUrl = "http://fits.qauber.com/#/app/entities";
	private static String addEntityXpath = ".//*[@class='pull-right btn btn-info btn-sm mt-sm ng-binding']";
	private static String afterAddEntityUrl = "http://fits.qauber.com/#/app/initial-wizard/";
	private static String firstEntityXpath = ".//*[@class='ng-binding']";
	private static String assPermissionsXpath = ".//*[@title='Assign permissions']"; 
	private static String assPermCloseXpath = ".//*[@class='ngdialog ngdialog-theme-default ng-scope']/div[2]/div[2]";
	private static String editEntityXpath = ".//*[@title='Edit']";
	private static String deleteEntityXpath = ".//*[@title='Delete']";
	private static String deleteCancelXpath = ".//*[@id='ngdialog2']/div[2]/div/button[2]";
	private static String editEntityUrl = "http://fits.qauber.com/#/app/org/991";
	
	//Reports page variables
	private static String reportsUrl = "http://fits.qauber.com/#/app/reports";
	private static String clearButtonXpath = ".//*[@class='btn btn-labeled btn-primary btn-sm mt']";
	private static String suspLastNameXpath = ".//*[@ng-model='slnSearchKey']";
	private static String suspFirstNameXpath = ".//*[@ng-model='sfnSearchKey']";
	private static String caseIdXpath = ".//*[@ng-model='ciSearchKey']";
	private static String suspTypeXpath = ".//*[@ng-model='stSearchKey']";
	private static String publishedCheckboxXpath = ".//*[@class='fa fa-check']";
	private static String pubStartXpath = ".//input[@placeholder='Date From ...']";
	private static String pubEndXpath = ".//input[@placeholder='Date To ...']";
	private static String containsTextXpath = ".//*[@ng-model='ctSearchKey']";
	private static String clearFiltersXpath = ".//button[@ng-click='clearFilter()']";
	
	//Reports page search variables
	private static String suspLastName = "Smith";
	private static String suspFirstName = "John";
	private static String caseId = "1234";
	private static String suspType = "Suspect";
	private static String pubStartDate = "04202018";
	private static String pubEndDate = "04302018";
	private static String createStartDate = "04202018";
	private static String createEndDate = "04302018";
	private static String containsText = "3163";

	//main method
	public static void main(String[] args) throws InterruptedException {
		System.out.print("-----BEGIN TEST SUITE-----");
		//WebDriver initialization 
		WebDriver driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

		//LOGIN PAGE
		System.out.print("-----BEGIN LOGIN PAGE TESTS-----");	
		//Go to the url
	    driver.get(url);
	    //Activate the register() test case method in LoginPage
		LoginPage.register(driver, registerNowXpath, registerPageUrl);
		
		//Go to the url
	    driver.get(url);
	    //Activate the forgotPassString() test case method in LoginPage
	    LoginPage.forgotPassString(driver, forgotPassXpath, forgotPassUrl);
		
		//Go to the url
	    driver.get(url);
	    
	    //enterEmail(), enterPassword(), and submitLogin()
	    LoginPage.enterEmail(driver, email, emailFieldXpath);
	    LoginPage.enterPassword(driver, password, passwordFieldXpath);
	    LoginPage.submitLogin(driver, loginButtonXpath, homePageUrl);
	
	    //REPORTS PAGE
		System.out.print("-----BEGIN REPORTS PAGE TESTS-----");	
		//driver.get(reportsUrl);
		ReportsPage.enterSuspLastName(driver, suspLastName, suspLastNameXpath);
		ReportsPage.enterSuspFirstName(driver, suspFirstName, suspFirstNameXpath);	
		ReportsPage.enterCaseId(driver, caseId, caseIdXpath);
		ReportsPage.chooseSuspType(driver, suspType, suspTypeXpath);
		ReportsPage.togglePubCheckbox(driver, publishedCheckboxXpath);
		ReportsPage.enterContainsText(driver, containsText, containsTextXpath);
		ReportsPage.clickClearFilter(driver, clearFiltersXpath, suspLastNameXpath, suspFirstNameXpath, caseIdXpath, suspTypeXpath, publishedCheckboxXpath, containsTextXpath);
		//ReportsPage.enterPubStartDate(driver, pubStartDate, pubStartXpath);
		
		//ENTITIES PAGE 
		System.out.print("-----BEGIN ENTITIES PAGE TESTS-----");	
		driver.get(entitiesUrl);
		EntitiesPage.clickAddEntity(driver, addEntityXpath, afterAddEntityUrl);
	
		//driver.get(entitiesUrl);
		//EntitiesPage.clickFirstEntity(driver, firstEntityXpath);
		
		//Go to the url
		driver.get(entitiesUrl);
		//click the Edit Entity button
		EntitiesPage.clickEditEntity(driver, editEntityXpath, editEntityUrl);
		
		//Go to the url
		driver.get(entitiesUrl);
		//Click the Assign Permissions button
		EntitiesPage.clickAssPermissions(driver, assPermissionsXpath, assPermCloseXpath);
		
		//driver.get(entitiesUrl);
		//EntitiesPage.deleteEntity(driver, deleteEntityXpath, deleteCancelXpath);
		
		System.out.println("-----END OF TEST SUITE-----");
	}

}
