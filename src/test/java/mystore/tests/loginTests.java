package mystore.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mystore.pageobjects.AuthenticationPage;
import mystore.pageobjects.CreateanAccountPage;
import mystore.pageobjects.ForgotYourPasswordPage;
import mystore.pageobjects.MyAccountPage;
import mystore.pageobjects.MyStorePage;
import utilities.AllureAttachment;

public class loginTests extends BaseTests {

	@Test(description = "Login to a New Account", enabled = true)
	@Description("Login to a New Account")
	@Severity(SeverityLevel.BLOCKER)

	public void tc01_Login() {
		MyStorePage mysp = new MyStorePage(driver);
		mysp.singIn();
		AuthenticationPage ap = new AuthenticationPage(driver);
		String newemail = "MeniPerez@gmail.com";
		ap.createAnAccount(newemail);
		CreateanAccountPage cap = new CreateanAccountPage(driver);
		cap.fillPersonalInfo("Meni", "Perez", "12345", "22", "10", "1969");
		cap.fillPersonalAddress("Perez Company", " that Place 11", "that Place22", "Chicago", "13", "12345", "xxx");
		cap.fillPhoneDetails("123321", "987654", "MNz Alias");
		cap.registerAccount();
		MyAccountPage myap = new MyAccountPage(driver);
		String expected = "Welcome to your account. Here you can manage all of your personal information and orders.";
		String actual = myap.getMsgAccountCreated();
		Assert.assertEquals(actual, expected);
		AllureAttachment.attachText(myap.getMsgAccountCreated());
		myap.returnToMyStorePage();
	}

	@Test(description = "check if display the name of the owner account")
	@Description("check if display the name of the owner account")
	@Severity(SeverityLevel.NORMAL)

	public void tc02_DisplayOwnerAccount() {
		MyStorePage mysp = new MyStorePage(driver);
		mysp.signOut();
		mysp.singIn();
		AuthenticationPage ap = new AuthenticationPage(driver);
		ap.registeredCreatedAccount("ItzjakCohen@gmail.com", "12345");
		String ownername = mysp.getOwnerAccount();
		Assert.assertTrue(mysp.isSignOut(), "The Sign Out display");
		AllureAttachment.attachText(ownername);
		ap.toMyStorePage();

	}

	@Test(description = "login a registered account")
	@Description("login a registered account")
	@Severity(SeverityLevel.CRITICAL)

	public void tc03_LogintoRegisteredAccount() {
		MyStorePage mysp = new MyStorePage(driver);
		mysp.signOut();
		mysp.singIn();
		AuthenticationPage ap = new AuthenticationPage(driver);
		ap.registeredCreatedAccount("ItzjakCohen@gmail.com", "12345");
		MyAccountPage myap = new MyAccountPage(driver);
		String expected = "Welcome to your account. Here you can manage all of your personal information and orders.";
		String actual = myap.getMsgAccountCreated();
		Assert.assertEquals(actual, expected);
		AllureAttachment.attachText(myap.getMsgAccountCreated());
		myap.returnToMyStorePage();

	}

	@Test(description = "Login to a created account")
	@Description("login a created account")
	@Severity(SeverityLevel.BLOCKER)

	public void tc04_LoginCreatedAccount() {
		MyStorePage mysp = new MyStorePage(driver);
		mysp.signOut();
		mysp.singIn();
		AuthenticationPage ap = new AuthenticationPage(driver);
		ap.createAnAccount("ItzjakCohen@gmail.com");
		String actual = ap.getMsgAccCreatedError();
		String expected = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
		Assert.assertEquals(actual, expected);
		AllureAttachment.attachText(actual);
		ap.toMyStorePage();

	}

	@Test(description = "check the forgot your password feature")
	@Description("check the forgot your password feature")
	@Severity(SeverityLevel.CRITICAL)

	public void tc05__LoginForgotYourPassword() {
		MyStorePage mysp = new MyStorePage(driver);
		mysp.singIn();
		AuthenticationPage ap = new AuthenticationPage(driver);
		ap.forgotYourPsswd();
		ForgotYourPasswordPage fypp = new ForgotYourPasswordPage(driver);
		String email = "asi@gmail.com";
		fypp.retrievePsswd(email);
		String actual = fypp.getInnerMsgSuccessRetrieve();
		String expected = "A confirmation email has been sent to your address: " + email;
		Assert.assertEquals(actual, expected);
		AllureAttachment.attachText("Message tc05: " + actual);
		fypp.backtoLogin();

	}

	@Test(description = "retrieve password with a not registered email address")
	@Description("retrieve password with a not registered email address")
	@Severity(SeverityLevel.CRITICAL)
	// retrieve with an email address that is not belongs to a registered account
	public void tc06_LoginForgotYourPassword() {

		AuthenticationPage ap = new AuthenticationPage(driver);
		ap.forgotYourPsswd();
		ForgotYourPasswordPage fypp = new ForgotYourPasswordPage(driver);
		String email = "evaperon@gmail.com";
		fypp.retrievePsswd(email);
		String actual = fypp.getErrorMsg();
		String expected = "There is no account registered for this email address.";
		Assert.assertEquals(actual, expected);
		AllureAttachment.attachText("Message tc06: " + actual);

		fypp.backtoLogin();

	}

	@Test(dataProvider = "getData", description = "incorrect login")
	@Description("perform login with not valids and wrongs inputs values")
	@Severity(SeverityLevel.BLOCKER)
	// perform login with wrong and not valid input values
	public void tc07_LoginFailed(String user, String password, String message) {
		MyStorePage mysp = new MyStorePage(driver);
		mysp.singIn();
		AuthenticationPage ap = new AuthenticationPage(driver);
		ap.registeredCreatedAccount(user, password);

		String actualError = ap.getErrorMsg();
		AllureAttachment.attachText(actualError);
		Assert.assertEquals(actualError, message);
		ap.toMyStorePage();
		//
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] myData = { { "", "", "An email address required." },
				{ "asi@gmail.com", " ", "Password is required." }, { "", "12345", "An email address required." },
				{ "evaperon@gmail.com", "12345", "Authentication failed." },
				{ "evaperon", "12345", "Invalid email address." } };

		return myData;

	}

}
