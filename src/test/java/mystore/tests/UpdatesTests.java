package mystore.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mystore.pageobjects.AuthenticationPage;
import mystore.pageobjects.MyAccountPage;
import mystore.pageobjects.MyAddressesPage;
import mystore.pageobjects.MyStorePage;
import mystore.pageobjects.YourAddressesPage;
import utilities.AllureAttachment;

public class UpdatesTests extends BaseTests {

	@Test(description = "update address")
	@Description("update address")
	@Severity(SeverityLevel.CRITICAL)
	public void tc01_UpdateAddress() {
		MyStorePage mysp = new MyStorePage(driver);
		mysp.singIn();
		AuthenticationPage ap = new AuthenticationPage(driver);
		ap.registeredCreatedAccount("ItzjakCohen@gmail.com", "12345");
		MyAccountPage myap = new MyAccountPage(driver);
		myap.toMyAddressesPage();
		MyAddressesPage myad = new MyAddressesPage(driver);
		myad.updateInfo();
		YourAddressesPage yap = new YourAddressesPage(driver);
		String actual = yap.getModAddressMsg();
		String expected = "Modify address \"Itzik Cohen Alias\"";
		Assert.assertEquals(actual, expected);
		AllureAttachment.attachText("Message test1: " + actual);
		yap.backToMyAddressessPage();
		myad.backToMyStorePage();
	}

	@Test(description = "update home phone number")
	@Description("update home phone number")
	@Severity(SeverityLevel.CRITICAL)
	public void tc02_UpdatePhone() {
		// Login
		MyStorePage mysp = new MyStorePage(driver);
		mysp.signOut();
		mysp.singIn();
		AuthenticationPage ap = new AuthenticationPage(driver);
		ap.registeredCreatedAccount("ItzjakCohen@gmail.com", "12345");
		// Go to My Account Page
		MyAccountPage myap = new MyAccountPage(driver);
		myap.toMyAddressesPage();
		MyAddressesPage myad = new MyAddressesPage(driver);
		// Update Info
		myad.updateInfo();
		YourAddressesPage yap = new YourAddressesPage(driver);
		yap.updatePhoneInfo("1234567");
		String actual = myad.getAddressPhone();
		String expected = "1234567";
		Assert.assertEquals(actual, expected);
		AllureAttachment.attachText("the update phone number: " + actual);
		myad.backToMyStorePage();

	}

	@Test(description = "update mobile phone number")
	@Description("update mobile phone number")
	@Severity(SeverityLevel.CRITICAL)

	public void tc03_UpdateMobilePhone() {
		// Login
		MyStorePage mysp = new MyStorePage(driver);
		mysp.signOut();
		mysp.singIn();
		AuthenticationPage ap = new AuthenticationPage(driver);
		ap.registeredCreatedAccount("HaimCohen@gmail.com", "12345");
		// Go to My account Page
		MyAccountPage myap = new MyAccountPage(driver);
		// Go to My Addresses Page
		myap.toMyAddressesPage();
		MyAddressesPage myad = new MyAddressesPage(driver);
		// Update Info
		myad.updateInfo();
		YourAddressesPage yap = new YourAddressesPage(driver);
		yap.updatemobilInfo("0501234567");
		String actual = myad.getAddressMobile();
		String expected = "0501234567";
		Assert.assertEquals(actual, expected);
		AllureAttachment.attachText("the update mobile number: " + actual);
		myad.backToMyStorePage();
	}

	@Test(description = "add a new Address")
	@Description("add a new Address")
	@Severity(SeverityLevel.CRITICAL)

	public void tc04_addNewAddress() {
		// Login
		MyStorePage mysp = new MyStorePage(driver);
		mysp.signOut();
		mysp.singIn();
		AuthenticationPage ap = new AuthenticationPage(driver);
		ap.registeredCreatedAccount("HaimCohen@gmail.com", "12345");
		// Go to My account Page
		MyAccountPage myap = new MyAccountPage(driver);
		// Go to My Addresses Page
		myap.toMyAddressesPage();
		MyAddressesPage myad = new MyAddressesPage(driver);
		myad.addNewAddress();
		YourAddressesPage yap = new YourAddressesPage(driver);
		yap.fillpersonalAddress("NewPlace1", "NewPlace2", "Chicago", "13", "98765", "9999999", "00000000", "alias",
				"a new address!!!");
		// String actual1 = myad.getAlternBlockAddress().trim();
		String actual = myad.getAlternBlockAddress().replaceAll("[^A-Za-z0-9]", "");
		String expected = "ALIASHaimCohenCohenNewPlace1NewPlace2ChicagoIllinois98765UnitedStates999999900000000UpdateDelete";
		AllureAttachment.attachText(actual);
		AllureAttachment.attachText(expected);

		Assert.assertEquals(actual, expected);
		myad.backToMyStorePage();
	}

	@Test(description = "delete the address")
	@Description("delete the address")
	@Severity(SeverityLevel.CRITICAL)

	public void tc05_deleteNewAddress() {
		// Login
		MyStorePage mysp = new MyStorePage(driver);
		mysp.signOut();
		mysp.singIn();
		AuthenticationPage ap = new AuthenticationPage(driver);
		ap.registeredCreatedAccount("HaimCohen@gmail.com", "12345");
		// Go to My account Page
		MyAccountPage myap = new MyAccountPage(driver);
		myap.toMyAddressesPage();
		// Go to My Addresses Page
		MyAddressesPage myad = new MyAddressesPage(driver);
		myad.deleteAddress();
		boolean noAddress = myad.notExistsElement();
		Assert.assertTrue(noAddress, "The added address shouldn't be display but is display!!!!");
		myad.backToMyStorePage();

	}

}
