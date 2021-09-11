package mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartSummaryPage extends BasePage {

	public ShoppingCartSummaryPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(css = ".standard-checkout>span")
	private WebElement checkoutBtn;
	@FindBy(css = ".icon-plus")
	WebElement plusBtn;
	@FindBy(css = ".icon-minus")
	private WebElement minusBtn;
	@FindBy(css = ".cart_quantity.text-center [type='text']")
	private WebElement quantity;
	@FindBy(css = ".cart_quantity_delete")
	WebElement deleteBtn;
	@FindBy(css = ".alert.alert-warning")
	WebElement emptyMsg;
	@FindBy(css = ".icon-home")
	WebElement homeBtn;
	@FindBy(css = ".cart_product>a")
	WebElement imgBtn;
	@FindBy(css = ".step_current.first")
	WebElement summaryTitle;

	// Actions
	// Click on proceed to checkout
	public void toAdresses() {
		explicitWaitClickable(checkoutBtn);
		click(checkoutBtn);
	}

	// back to My Store page
	public void toMyStore() {
		explicitWaitClickable(homeBtn);
		click(homeBtn);
	}

	// Increase quantity of the chosen product
	public void IncreaseQuantity() {
		explicitWaitClickable(plusBtn);
		click(plusBtn);
	}

	// Reduce quantity of the chosen product
	public void reduceQuantity() {
		explicitWaitClickable(minusBtn);
		click(minusBtn);
	}

	// Get the quantity of the product
	public int getQuantity() {
		sleep(1000);
		String number = getAttribute(quantity);
		int num = Integer.parseInt(number);
		sleep(1000);
		return num;

	}

	// Delete the chosen product
	public void DeleteProduct() {
		sleep(1000);
		click(deleteBtn);
	}

	// Go to product page by image of chosen product
	public void goToProdPageByImage() {
		explicitWaitClickable(imgBtn);
		click(imgBtn);
	}

	// Validations

	// get title stage
	public String getStageTitle() {
		return getText(summaryTitle);
	}

	// get empty cart message
	public String getEmptyMsg() {
		sleep(1000);
		return getText(emptyMsg);
	}
}
