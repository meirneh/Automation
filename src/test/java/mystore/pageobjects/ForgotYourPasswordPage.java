package mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class ForgotYourPasswordPage extends BasePage {

	@FindBy(css = "#email")
	private WebElement emailfield;
	@FindBy(css = ".submit span")
	private WebElement retrieveBtn;
	@FindBy(css = "#center_column > div > p")
	private WebElement retrieveMsg;
	@FindBy(css = " #center_column > div > div > ol > li")
	private WebElement errorMsg;
	@FindBy(css = ".clearfix.footer_links>li>a")
	private WebElement backBtn;

	public ForgotYourPasswordPage(WebDriver driver) {
		super(driver);

	}

	// Actions
	// Retrieve the password
	@Step("fill the email field:{0}")
	public void retrievePsswd(String email) {
		fillText(emailfield, email);
		explicitWaitClickable(retrieveBtn);
		click(retrieveBtn);
		sleep(500);
	}

	// Back to Login Page
	public void backtoLogin() {
		explicitWaitClickable(backBtn);
		click(backBtn);
	}

	// Validations
	// Get Success Message about retrieve password
	public String getMsgSuccessRetrieve() {

		return getText(retrieveMsg);
	}

	// Get Success Message about retrieve password
	public String getInnerMsgSuccessRetrieve() {

		return getInnerText(retrieveMsg);

	}

	// Get Error Message
	public String getErrorMsg() {

		return getInnerText(errorMsg);

	}

}
