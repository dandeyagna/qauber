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
	
	//main method
	public static void main(String[] args) throws InterruptedException {
		//WebDriver initialization 
		WebDriver driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

		//Creating Dynamic object for Login Page
		LoginPage lPage = new LoginPage(); 
		
		//Go to the url
	    driver.get(url);
	    //Activate the register() test case method in LoginPage
		lPage.register(driver, registerNowXpath, registerPageUrl);
		
		//Go to the url
	    driver.get(url);
	    //Activate the forgotPassString() test case method in LoginPage
		lPage.forgotPassString(driver, forgotPassXpath, forgotPassUrl);
		
		//Go to the url
	    driver.get(url);
	    
	    //enterEmail(), enterPassword(), and submitLogin()
		lPage.enterEmail(driver, email, emailFieldXpath);
		lPage.enterPassword(driver, password, passwordFieldXpath);
		lPage.submitLogin(driver, loginButtonXpath, homePageUrl);
	
		//Creating Dynamic object for Entities Page
		EntitiesPage ePage = new EntitiesPage();
		driver.get(entitiesUrl);
		ePage.clickAddEntity(driver, addEntityXpath, afterAddEntityUrl);
		
		//driver.get(entitiesUrl);
		//ePage.clickFirstEntity(driver, firstEntityXpath);
		
		//Go to the url
		driver.get(entitiesUrl);
		//click the Edit Entity button
		ePage.clickEditEntity(driver, editEntityXpath, editEntityUrl);
		
		//Go to the url
		driver.get(entitiesUrl);
		//Click the Assign Permissions button
		ePage.clickAssPermissions(driver, assPermissionsXpath, assPermCloseXpath);
		
		//driver.get(entitiesUrl);
		//ePage.deleteEntity(driver, deleteEntityXpath, deleteCancelXpath);
		
		System.out.println("-----END OF TESTS-----");
	}

}
