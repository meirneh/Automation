package mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class AuthenticationPage extends BasePage {

	@FindBy(css = "#email_create")
	private WebElement emailField;
	@FindBy(css = "#SubmitCreate")
	private WebElement createBtn;
	@FindBy(css = "#email")
	private WebElement EmailField;
	@FindBy(css = "#passwd")
	private WebElement PasswordField;
	@FindBy(css = "#SubmitLogin")
	private WebElement signinBtn;
	@FindBy(css = ".icon-home")
	private WebElement homeBtn;
	@FindBy(css = "#create_account_error")
	private WebElement msgCreateAccError;
	@FindBy(css = ".lost_password.form-group>a")
	private WebElement forgtpsswd;
	@FindBy(css = ".alert-danger>ol>li")
	private WebElement errorMsg;

	public AuthenticationPage(WebDriver driver) {
		super(driver);
	}

	// Actions
	// Create Account
	@Step("fill  email: {0}")
	public void createAnAccount(String email) {
		fillText(emailField, email);
	explicitWaitClickable(createBtn);
		click(createBtn);
		sleep(2500);
	}

	// Registration with a Created Account
	@Step("fill email: {0},fill password:{1}")
	public void registeredCreatedAccount(String email, String psswd) {
		fillText(EmailField, email);
		fillText(PasswordField, psswd);
		explicitWaitClickable(signinBtn);
		click(signinBtn);

	}

	

	// Click the Forgot Your Password
	public void forgotYourPsswd() {
	explicitWaitClickable(forgtpsswd);
		click(forgtpsswd);
	}

	// Directing to the My Store page
	public void toMyStorePage() {
		explicitWaitClickable(homeBtn);
		// sleep(500);
		click(homeBtn);
	}

	// Validation
	// Get Error Message about created account
	public String getMsgAccCreatedError() {
		return getInnerText(msgCreateAccError);
	}

	// Get Error Message
	public String getErrorMsg() {
		return getText(errorMsg);
	}

}
