package mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	@FindBy(css = ".icon-home")
	private WebElement rtnhomeBtn;
	@FindBy(css = ".info-account")
	private WebElement msgCreatedAccount;
	@FindBy(css = "#center_column > ul >li a > span")
	private WebElement rtnBtn;
	@FindBy(css = ".icon-building")
	private WebElement toMyAddressessBtn;

	public MyAccountPage(WebDriver driver) {
		super(driver);

	}

	// actions
	// Return to the Home Page
	public void returnToMyStorePage() {
		explicitWaitClickable(rtnBtn);
		click(rtnBtn);
	}

	// Directing to addresses page
	public void toMyAddressesPage() {
		explicitWaitClickable(toMyAddressessBtn);
		click(toMyAddressessBtn);
	}

	// Return to the Home Page
	public void returntoMyStorePageByIcon() {
		explicitWaitClickable(rtnhomeBtn);
		click(rtnhomeBtn);
	}

	// Validation
	// Get Message Success about a created account
	public String getMsgAccountCreated() {

		return getText(msgCreatedAccount);

	}

}
