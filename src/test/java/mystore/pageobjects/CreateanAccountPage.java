package mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class CreateanAccountPage extends BasePage {

	@FindBy(css = ".icon-home")
	private WebElement returnhomeBtn;
	@FindBy(css = "#uniform-id_gender1")
	private WebElement MrBtn;
	@FindBy(css = "#uniform-id_gender2")
	private WebElement MrsBtn;
	@FindBy(css = "#customer_firstname")
	private WebElement firstnameField;
	@FindBy(css = "#customer_lastname")
	private WebElement lastnameField;
	@FindBy(css = "#passwd")
	private WebElement passwordField;
	@FindBy(css = "#days")
	private WebElement daySelect;
	@FindBy(css = "#months")
	private WebElement monthSelect;
	@FindBy(css = "#years")
	private WebElement yearSelect;
	@FindBy(css = "#newsletter")
	private WebElement nwsltrCbx;
	@FindBy(css = "#optin")
	private WebElement spofertsCbx;
	@FindBy(css = "#firstname")
	private WebElement nameField;
	@FindBy(css = "#lastname")
	private WebElement lastNameField;
	@FindBy(css = "#company")
	private WebElement companyField;
	@FindBy(css = "#address1")
	private WebElement addressField;
	@FindBy(css = "#address2")
	private WebElement addressField2;
	@FindBy(css = "#city")
	private WebElement cityField;
	@FindBy(css = "#id_state")
	private WebElement stateSelect;
	@FindBy(css = "#postcode")
	private WebElement postField;
	@FindBy(css = "#other")
	private WebElement addInfoField;
	@FindBy(css = "#phone")
	private WebElement phoneField;
	@FindBy(css = "#phone_mobile")
	private WebElement phonemobileField;
	@FindBy(css = "#alias")
	private WebElement aliasField;
	@FindBy(css = "#submitAccount")
	private WebElement registerBtn;
	public CreateanAccountPage(WebDriver driver) {
		super(driver);
	}
	// actions
	// Fill personal information
	@Step("fill firstname: {0},fill lastname:{1},fill password:{2},select day{3],select month{4},select year{5}")
	public void fillPersonalInfo(String fname, String lname, String psswrd, String dnum, String mnum, String ynum) {
		//explicitWaitClickable(MrBtn);
		sleep(3000);
		click(MrBtn);
		sleep(3000);
		fillText(firstnameField, fname);
		sleep(500);
		fillText(lastnameField, lname);
		sleep(500);
		fillText(passwordField, psswrd);
		sleep(5000);
		selectByValue(daySelect, dnum);
		sleep(5000);
		selectByValue(monthSelect, mnum);
		sleep(5000);
		selectByValue(yearSelect, ynum);
		//explicitWaitClickable(nwsltrCbx);
		sleep(500);
		click(nwsltrCbx);
		//explicitWaitClickable(spofertsCbx);
		sleep(500);
		click(spofertsCbx);
	}

	// Fill personal address information
	@Step("fill company name:{0},fill address:{1},fill address2:{2},fill city name:{3},select the state:{4},fill the postcode:{5},add info:{6}")
	public void fillPersonalAddress(String comp, String addrss, String addrss2, String city, String stnum,
			String postcode, String addinfo) {
		fillText(companyField, comp);
		fillText(addressField, addrss);
		fillText(addressField2, addrss2);
		fillText(cityField, city);
		selectByValue(stateSelect, stnum);
		sleep(500);
		fillText(postField, postcode);
		fillText(addInfoField, addinfo);
	}

	// Fill personal phone information
	@Step("fill the home phone field:{0},fill th mobile phonr field:{1},fill the alias name field:{2}")
	public void fillPhoneDetails(String phonnum, String mobilenum, String alias) {
		fillText(phoneField, phonnum);
		fillText(phonemobileField, mobilenum);
		fillText(aliasField, alias);
	}

	// Click on the register button
	public void registerAccount() {
		click(registerBtn);
	}

}
