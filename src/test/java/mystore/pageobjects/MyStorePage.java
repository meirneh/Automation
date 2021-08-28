package mystore.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class MyStorePage extends BasePage {

	@FindBy(css = ".header_user_info>a")
	private WebElement singinBtn;
	@FindBy(css = ".header_user_info>a>span")
	private WebElement nameowneraccount;
	@FindBy(css = ".header_user_info a.logout")
	private WebElement signout;
	@FindBy(css = ".product_list.grid.row.homefeatured.tab-pane.active a.product-name")
	private List<WebElement> list;
	@FindBy(css = ".row.homefeatured .ajax_add_to_cart_button")
	private WebElement addBtn;
	@FindBy(css = ".product_list.grid.row.homefeatured.tab-pane.active [title='Add to cart'] ")
	private WebElement checkoutBtn;
	@FindBy(css = "[title='Continue shopping']")
	private WebElement continueBtn;
	@FindBy(css = ".layer_cart_product h2")
	private WebElement successaddMsg;
	@FindBy(css = "[title='My addresses']")
	private WebElement myAddresseslnk;
	@FindBy(css = "h2 .ajax_cart_product_txt_s.unvisible")
	private WebElement itemsInCart;
	@FindBy(css = ".shopping_cart>a")
	private WebElement cartIcon;

	public MyStorePage(WebDriver driver) {
		super(driver);

	}

	// actions
	public void singIn() {
		explicitWaitClickable(singinBtn);
		click(singinBtn);
	}

	public void signOut() {
		explicitWaitClickable(signout);
		click(signout);
	}

	// Choose Product and pass to the Product Page of the chosen product
	@Step("Choose Product: {0}")
	public void chooseProducts(String name) {
		for (WebElement el : list) {
			if (getText(el).equalsIgnoreCase(name)) {
				click(el);
				break;
			}
		}
	}

	// Choose and Purchase Product direct of the My Store Page
	public void addToCartProducts(String name) {
		for (WebElement el : list) {
			if (getText(el).equalsIgnoreCase(name)) {
				sleep(3000);
				moveTo(el);
				sleep(5000);
				moveTo(addBtn);
				// explicitWaitClickable(addBtn);
				click(addBtn);
				break;
			}
		}
	}

//Click to the checkout button
	public void checkout() {
		// sleep(2000);
		explicitWaitClickable(checkoutBtn);
		click(checkoutBtn);
	}

//Click the Continue shopping button
	public void shopping() {
		// sleep(5000);
		implicitWait(5000);
		click(continueBtn);
	}

	// Redirect to My Addresses Page
	public void toMyAddressesPage() {
		click(myAddresseslnk);
	}

	// Validations
	public String getOwnerAccount() {
		return getText(nameowneraccount);

	}

	// Validate the sign out
	public boolean isSignOut() {
		if (getText(signout).equalsIgnoreCase("Sign out")) {
			return true;
		}
		return false;
	}

	// Get Message Success
	public String getInnSuccessAddMsg() {
		return getInnerText(successaddMsg);

	}

	// Get Message items in the cart
	public String getMessageItemsInCart() {
		return getText(itemsInCart);
	}

	// Validation Cart
	public String getCart() {
		return getText(cartIcon);
	}
//get add button

	public String getaddBtn() {

		return getText(addBtn);
	}
}
