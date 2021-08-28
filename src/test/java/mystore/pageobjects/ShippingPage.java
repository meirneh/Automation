package mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingPage extends BasePage {
	@FindBy(css = " #uniform-cgv")
	private WebElement agreeChckBx;
	@FindBy(css = ".standard-checkout.button-medium>span")
	private WebElement chekoutBtn;
	@FindBy(css = ".step_current.four")
	private WebElement stepShipping;

	public ShippingPage(WebDriver driver) {
		super(driver);

	}

	// Actions
	// payment the bill
	public void toPayment() {
		explicitWaitClickable(agreeChckBx);
		click(agreeChckBx);
		explicitWaitClickable(chekoutBtn);
		click(chekoutBtn);
	}

	// Validation
	// Get the text of the Four step validation
	public String getFourStep() {
		return getText(stepShipping);

	}
}
