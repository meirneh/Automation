package mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class YourAddressesPage extends BasePage {

	public YourAddressesPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(css = ".info-title")
	WebElement addNwAddressMsg;
	@FindBy(css = "#address1")
	WebElement address1Field;
	@FindBy(css = "#address2")
	WebElement address2Field;
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
	private WebElement mobileField;
	@FindBy(css = "#alias")
	private WebElement aliasField;
	@FindBy(css = "#submitAddress")
	private WebElement saveBtn;
	@FindBy(css = ".center_column > ul > li > a > span")
	private WebElement backToYouraddressesBtn;

	// action
	// Update phone number
	@Step("fill phone field:{0}")
	public void updatePhoneInfo(String phonenum) {
		sleep(500);
		fillText(phoneField, phonenum);
		explicitWaitClickable(saveBtn);
		click(saveBtn);
	}

	@Step("fill mobile phone field:{0}")
	public void updatemobilInfo(String mobilenum) {
		fillText(mobileField, mobilenum);
		explicitWaitClickable(saveBtn);
		click(saveBtn);
	}

	@Step("fill address field:{0},address2 field:{1},fill city field:{2},select state,"
			+ "{3},fill post code field:{4},fill phone field:{5},"
			+ "fill mobile field:{6},fill alias field:{7},fill add info box text:{8}")
	public void fillpersonalAddress(String addrss1, String addrss2, String city, String stnum, String postcode,
			String phonenum, String mobilenum, String alias, String addinfo) {
		fillText(address1Field, addrss1);
		fillText(address2Field, addrss2);
		fillText(cityField, city);
		selectByValue(stateSelect, stnum);
		sleep(500);
		fillText(postField, postcode);
		fillText(phoneField, phonenum);
		fillText(mobileField, mobilenum);
		fillText(aliasField, alias);
		fillText(addInfoField, addinfo);
		explicitWaitClickable(saveBtn);
		click(saveBtn);
	}

	// Back to my addresses page
	public void backToMyAddressessPage() {
		explicitWaitClickable(backToYouraddressesBtn);
		click(backToYouraddressesBtn);
	}

	// validation

	public String getModAddressMsg() {
		sleep(2000);
		return getText(addNwAddressMsg);

	}

	public String getaddNwAddressMsg() {
		return getText(addNwAddressMsg);

	}

}
