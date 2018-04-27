package Max.Day7tasks;

//class for Login page
public class LoginPage {
	//attributes of login page derived from web elements of page
	private String url;
	private String email;
	private String password;
	private String loginButtonXpath;
	private String forgotPassXpath;
	private String registerNowXpath;
	//constructor to initialize attributes
	public LoginPage(String url, String email, String password, String loginButtonXpath, String forgotPassXpath, String registerNowXpath) {
		this.url = url;
		this.email = email;
		this.password = password;
		this.loginButtonXpath = loginButtonXpath;
		this.forgotPassXpath = forgotPassXpath;
		this.registerNowXpath = registerNowXpath;	
	}
	
	//methods for actual behavior, taking the attributes as arguments
	public void enterEmail(String email) {
		//enter email
	}
	
	public void enterPassword(String password) {
		//enter password
	}
	
	public void submitLogin(String loginButtonXpath) {
		//click submit button
	}
	
	public void forgotPassString (String forgotPassXpath) {
		//click on forgot your password link
	}
	
	public void register(String registerNowXpath) {
		//click Register Now button
	}
	
}
