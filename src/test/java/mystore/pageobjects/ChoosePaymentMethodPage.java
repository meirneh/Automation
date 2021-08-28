package mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChoosePaymentMethodPage extends BasePage {
	@FindBy(css = ".bankwire")
	private WebElement bankwireBtn;
	@FindBy(css = ".cheque")
	private WebElement checkBtn;
    @FindBy(css =".step_current.last")
    private WebElement stepPayment;
	public ChoosePaymentMethodPage(WebDriver driver) {
		super(driver);

	}
    //Actions
	// Payment by Bank wire
	public void payByBankwire() {
		explicitWaitClickable(bankwireBtn);
		click(bankwireBtn);
	}

	// Payment by check
	public void payByCheck() {
		explicitWaitClickable(checkBtn);
		click(checkBtn);
	}
   //Validations
	// Get the text of the Fifth step validation
		public String getFifthStep() {
			return getText(stepPayment);

		}
}
