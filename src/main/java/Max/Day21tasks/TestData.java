package Max.Day21tasks;

import org.testng.annotations.DataProvider;

public class TestData {
	//Login page variables
	private static String email = "max8987@gmail.com";
	private static String emailFieldXpath = ".//*[@id='exampleInputEmail1']";
	private static String password = "stargate";
	private static String passwordFieldXpath = ".//*[@id='exampleInputPassword1']";
	private static String loginButtonXpath = ".//*[@class='btn btn-block btn-primary mt-lg']";
	private static String forgotPassXpath = ".//*[@class='text-muted']";
	private static String registerNowXpath = ".//*[@class='btn btn-block btn-default']";
	private static String registerPageUrl = "http://fits.qauber.com/#/page/register-sa";
	private static String forgotPassUrl = "http://fits.qauber.com/#/page/recover";
	
	//Reports page variables
	private static String reportsUrl = "http://fits.qauber.com/#/app/reports";
	private static String suspLastNameXpath = ".//*[@ng-model='slnSearchKey']";
	private static String suspFirstNameXpath = ".//*[@ng-model='sfnSearchKey']";
	private static String caseIdXpath = ".//*[@ng-model='ciSearchKey']";
	private static String suspTypeXpath = ".//*[@ng-model='stSearchKey']";
	private static String publishedCheckboxXpath = ".//*[@class='fa fa-check']";
	private static String containsTextXpath = ".//*[@ng-model='ctSearchKey']";
	private static String clearFiltersXpath = ".//button[@ng-click='clearFilter()']";
	
	//Reports page search variables
	private static String suspLastName = "Smith";
	private static String suspFirstName = "John";
	private static String caseId = "1234";
	private static String suspType = "Suspect";
	private static String containsText = "3163";
	
	//Login data
	@DataProvider(name = "register")
	public static Object[][] register() {
	  return new Object[][] {new Object[] {registerNowXpath, registerPageUrl}};}
	@DataProvider(name = "forgotPass")
	public static Object[][] forgotPass() {
	  return new Object[][] {new Object[] {forgotPassXpath, forgotPassUrl}};}
	@DataProvider(name = "email")
	public static Object[][] email() {
	  return new Object[][] {new Object[] {email, emailFieldXpath}};}
	@DataProvider(name = "password")
	public static Object[][] password() {
	  return new Object[][] {new Object[] {password, passwordFieldXpath}};}
	@DataProvider(name = "submit")
	public static Object[][] submit() {
	  return new Object[][] {new Object[] {loginButtonXpath, reportsUrl}};}
	
	//Reports data
	@DataProvider(name = "suspLastName")
	public static Object[][] suspLastName() {
	  return new Object[][] {new Object[] {suspLastName, suspLastNameXpath}};}
	@DataProvider(name = "suspFirstName")
	public static Object[][] suspFirstName() {
	  return new Object[][] {new Object[] {suspFirstName, suspFirstNameXpath}};}
	@DataProvider(name = "caseId")
	public static Object[][] caseId() {
	  return new Object[][] {new Object[] {caseId, caseIdXpath}};}
	@DataProvider(name = "suspType")
	public static Object[][] suspType() {
	  return new Object[][] {new Object[] {suspType, suspTypeXpath}};}
	@DataProvider(name = "pubCheckbox")
	public static Object[][] pubCheckbox() {
	  return new Object[][] {new Object[] {publishedCheckboxXpath}};}
	@DataProvider(name = "contains")
	public static Object[][] contains() {
	  return new Object[][] {new Object[] {containsText, containsTextXpath}};}
	@DataProvider(name = "clearFilters")
	public static Object[][] clearFilters() {
	  return new Object[][] {new Object[] {clearFiltersXpath, suspLastNameXpath, suspFirstNameXpath, caseIdXpath, suspTypeXpath, publishedCheckboxXpath, containsTextXpath}};}
	
}
