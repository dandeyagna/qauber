package Max.Day18tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

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
	
	//Entities page variables
	private static String entitiesUrl = "http://fits.qauber.com/#/app/entities";
	private static String addEntityXpath = ".//*[@class='pull-right btn btn-info btn-sm mt-sm ng-binding']";
	private static String afterAddEntityUrl = "http://fits.qauber.com/#/app/initial-wizard/";
	private static String firstEntityXpath = ".//*[@class='ng-binding']";
	private static String assPermissionsXpath = ".//*[@title='Assign permissions']"; 
	private static String assPermCloseXpath = ".//*[@class='ngdialog-close']";
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
	
	//Add Report page variables
	private static String addReportUrl = "http://fits.qauber.com/#/app/add-report-form";
	private static int tab1 = 11;
	private static String tab1name = "Entity";
	private static int tab2 = 12;
	private static String tab2name = "Subject Information";
	private static int tab3 = 13;
	private static String tab3name = "Identifiers";
	private static int tab4 = 14;
	private static String tab4name = "ID Information";
	private static int tab5 = 15;
	private static String tab5name = "Distribution";
	private static int tab6 = 16;
	private static String tab6name = "Vehicle";
	private static int tab7 = 17;
	private static String tab7name = "Photos";
	private static int tab8 = 18;
	private static String tab8name = "SubmitPage";
	private static String siDriverType = "Passenger";
	private static String siDriverTypeXpath = "//*[@class='col-md-3']/div/label/";
	private static String dobXpath = ".//*[@ng-model='wizard.report.dob']";
	private static String DOB = "01/01/1960";
	private static String diType = "Narco";
	private static String diTypeXpath = "//*[@class='checkbox c-checkbox needsclick']/label/";
	
	
	
	//main method
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("\n-----BEGIN TEST SUITE-----\n");
		//WebDriver initialization 
		//System.setProperty("webdriver.gecko.driver","/Users/max/Desktop/geckodriver");

		WebDriver driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	    driver.manage().window().setPosition(new Point(200,100));
	    driver.manage().window().setSize(new Dimension(1600,1200));

	    
		//LOGIN PAGE
		System.out.println("\n-----BEGIN LOGIN PAGE TESTS-----\n");	
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
	    LoginPage.submitLogin(driver, loginButtonXpath, reportsUrl);
	
	    //REPORTS PAGE
		System.out.println("\n-----BEGIN REPORTS PAGE TESTS-----\n");	
		ReportsPage.enterSuspLastName(driver, suspLastName, suspLastNameXpath);
		ReportsPage.enterSuspFirstName(driver, suspFirstName, suspFirstNameXpath);	
		ReportsPage.enterCaseId(driver, caseId, caseIdXpath);
		ReportsPage.chooseSuspType(driver, suspType, suspTypeXpath);
		ReportsPage.enterContainsText(driver, containsText, containsTextXpath);
		ReportsPage.enterPubStartDate(driver, pubStartDate, pubStartXpath);
		ReportsPage.togglePubCheckbox(driver, publishedCheckboxXpath);
		//Thread.sleep(4000);
		ReportsPage.clickClearFilter(driver, clearFiltersXpath, suspLastNameXpath, suspFirstNameXpath, caseIdXpath, suspTypeXpath, publishedCheckboxXpath, containsTextXpath);

		
		//ENTITIES PAGE 
		System.out.println("\n-----BEGIN ENTITIES PAGE TESTS-----\n");	
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
		//quickEntitiesPage.deleteEntity(driver, deleteEntityXpath, deleteCancelXpath);
		
		System.out.println("\n-----BEGIN ADD REPORT PAGE TESTS-----\n");
		
	    driver.get(addReportUrl);
		AddReport.selectRadioButton(driver);
		
	    AddReport.switchTabs(driver, tab2, tab2name, 1); // 1
//		Thread.sleep(1000);
	    //AddReport.switchTabs(driver, tab3, tab3name, 2); // 2
		//Thread.sleep(1000);
	    //AddReport.switchTabs(driver, tab4,tab4name, 3); // 3, 4, 5, 6
		//Thread.sleep(1000);
	   // AddReport.switchTabs(driver, tab5,tab5name, 7); // 7, 8, 9, 10, 11
		//Thread.sleep(1000);
	   // AddReport.switchTabs(driver, tab6,tab6name, 12); 
		//Thread.sleep(1000);
	    //AddReport.switchTabs(driver, tab7,tab7name, 13);
		//Thread.sleep(1000);
	    //AddReport.switchTabs(driver, tab8,tab8name, 14);
		//Thread.sleep(1000);	
	   // AddReport.switchTabs(driver, tab1,tab1name, 0); // 0
		//Thread.sleep(1000);
	    
		HashMap<String, String> easyFields = new HashMap<String, String>();
		easyFields.put("caseNumber", "C001");
		easyFields.put("lastName", "Zinovskiy");
		easyFields.put("firstName", "Max");
		easyFields.put("middleName", "V");
		easyFields.put("Nickname", "Maksim");
		easyFields.put("Age", "30");
		easyFields.put("Height", "5.11");
		easyFields.put("Weight", "195.0");
		easyFields.put("primary-language", "English");
		easyFields.put("street-address", "1234 Fake St.");
		easyFields.put("city", "abcd1234");
		easyFields.put("zip", "abcd1234");
		easyFields.put("phone", "abcd1234");
		easyFields.put("email", "abcd1234@aol.com");
		
		HashMap<String, String> dropDowns = new HashMap<String, String>();
		dropDowns.put("suspectType", "Suspect");
		dropDowns.put("sex", "M");
		dropDowns.put("race", "Caucasian");
		dropDowns.put("build", "M");
		dropDowns.put("hairColor", "BLO");
		dropDowns.put("hairLength", "Short");
		dropDowns.put("hairStyle", "Straight");
		dropDowns.put("eyeColor", "BLU");
		dropDowns.put("complexion", "Light");
		dropDowns.put("teeth", "Gold");
		dropDowns.put("handPreference", "Right");
		dropDowns.put("country", "US");
		//dropDowns.put(".//*[@name='state']", "abcd1234"); // becomes activated later as a dropdown once you pick country
		
		AddReport.enterSubjectInformation(driver, easyFields, dropDowns, siDriverTypeXpath, siDriverType, dobXpath, DOB);
		AddReport.switchTabs(driver, tab5,tab5name, 7);
		AddReport.fifthTabActions(driver, diTypeXpath, diType);
		
		System.out.println("\n-----END OF TEST SUITE-----\n");
	}

}
