package mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmationPage extends BasePage {
	@FindBy(css = ".cheque-indent")
	private WebElement confirmationMsg;
	@FindBy(css = ".home")
	private WebElement returnIconHomeBtn;

	public OrderConfirmationPage(WebDriver driver) {
		super(driver);

	}
    //Actions
	//Click on return home page button
	public void toHomePage() {
		explicitWaitClickable(returnIconHomeBtn);
		click(returnIconHomeBtn);
	}
	// Validations
	// Get Confirmation Message
	public String getConfirMsg() {
		return getText(confirmationMsg);

	}

	// Get Confirmation Message from the inner text
	public String getConfirmInnMsg() {
		return getInnerText(confirmationMsg);

	}

}
