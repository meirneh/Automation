package mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressesPage extends BasePage {
	@FindBy(css = "p>button>span")
	private WebElement checkoutBtn;
	@FindBy(css = ".step_current.third")
	private WebElement stepAddressed;

	public AddressesPage(WebDriver driver) {
		super(driver);

	}

	// Actions
	// Shipping the Product
	public void toShipping() {
		explicitWaitClickable(checkoutBtn);
		click(checkoutBtn);
	}

	// Validations
	// Get the text of the Third step validation
	public String getThirdStep() {
		return getText(stepAddressed);

	}
}
