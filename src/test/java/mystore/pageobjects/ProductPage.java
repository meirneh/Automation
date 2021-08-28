package mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

	@FindBy(css = "#add_to_cart span")
	private WebElement addcartBtn;
	@FindBy(css = ".btn.btn-default.button.button-medium")
	private WebElement checkoutBtn;
	@FindBy(css = ".layer_cart_product h2")
	private WebElement successaddMsg;
	@FindBy(css = ".col-md-6 > h2 > span.ajax_cart_product_txt_s.unvisible")
	private WebElement successMsgMoreThanOne;
	@FindBy(css = ".button.exclusive-medium")
	private WebElement continueShoppingBtn;
	@FindBy(css = "#send_friend_button")
	private WebElement sentfriendBtn;
	@FindBy(css = ".print>a")
	private WebElement printBtn;
	@FindBy(css = ".cross")
	private WebElement closeXBtn;
	@FindBy(css = ".fancybox-inner .button")
	private WebElement okBtn;
	@FindBy(css = ".icon-home")
	private WebElement homeBtn;
	@FindBy(css = ".icon-plus")
	private WebElement plusBtn;
	@FindBy(css = ".icon-minus")
	private WebElement minusBtn;
	@FindBy(css = "#quantity_wanted_p [name='qty']")
	private WebElement quantityWindow;
	@FindBy(css = "[itemprop='name']")
	private WebElement productTittle;

	public ProductPage(WebDriver driver) {
		super(driver);

	}

	// Actions

	// Add quantity of the chosen product
	public void addQuantity() {
		explicitWaitClickable(plusBtn);
		click(plusBtn);
		// sleep(1000);
	}

	// Reduce quantity of the chosen product
	public void reduceQuantity() {
		explicitWaitClickable(minusBtn);
		click(minusBtn);
	}

	// Click Add to cart Button
	public void addToCart() {
		explicitWaitClickable(addcartBtn);
		click(addcartBtn);
		// sleep(500);

	}

	// Click checkout button
	public void toShoppingCart() {
		sleep(5000);
		// explicitWaitClickable(checkoutBtn);
		click(checkoutBtn);
	}

	// Click continue shopping button
	public void continueShopping() {
		explicitWaitClickable(continueShoppingBtn);
		click(continueShoppingBtn);
	}

	// Click send to friend button
	public void sendToFriend() {
		 sleep(1000);
		//explicitWaitClickable(sentfriendBtn);
		click(sentfriendBtn);
	}

	// Close the addCartPage
	public void closeAddCartPage() {
		sleep(2000);
		// explicitWaitClickable(closeXBtn);
		click(closeXBtn);
	}

	// return to MyStore page
	public void toMyStorePage() {
		click(homeBtn);
	}

	// Validations
	// Get Success Message about adding product to the cart
	public String getInnSuccessAddMsg() {
		return getInnerText(successaddMsg);
	}

	// Get Success Message about adding more than one product to the cart
	public String getMessageMoreThanOne() {
		return getText(successMsgMoreThanOne);
	}

	// Get the quantity of the product
	public long getQuantity() {
		sleep(1000);
		String number = getAttribute(quantityWindow);
		long num = Long.parseLong(number);
		sleep(1000);
		return num;

	}

	public String Quantity() {
		sleep(2000);
		return getAttribute(quantityWindow);

	}
    //get the name of the product
	public String getName() {
		return getText(productTittle);
	}

}
