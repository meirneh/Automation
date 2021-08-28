package mystore.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import mystore.pageobjects.AuthenticationPage;
import mystore.pageobjects.MyAccountPage;
import mystore.pageobjects.MyStorePage;
import utilities.AllureAttachment;

public class ChooseProductDirectTest extends BaseTests {

	// @Test
	public void tc01_Login() {
		MyStorePage mysp = new MyStorePage(driver);
		mysp.singIn();
		AuthenticationPage ap = new AuthenticationPage(driver);
		ap.registeredCreatedAccount("ItzjakCohen@gmail.com", "12345");
		MyAccountPage myap = new MyAccountPage(driver);
		String expected = "Welcome to your account. Here you can manage all of your personal information and orders.";
		String actual = myap.getMsgAccountCreated();
		Assert.assertEquals(actual, expected);
		AllureAttachment.attachText("message1: " + actual);
		myap.returnToMyStorePage();
	}

	// Purchase one and more than one product directly from the My store Page
	@Test(description = "choose a product direct from the home page")
	public void tc02_ChooseProductDirect() {
		MyStorePage mysp = new MyStorePage(driver);
		mysp.addToCartProducts("Blouse");
		String actual = mysp.getInnSuccessAddMsg().trim();
		String expected = "Product successfully added to your shopping cart";
		String addBtn = mysp.getaddBtn();
		Assert.assertEquals(actual, expected);
		AllureAttachment.attachText("message2: " + actual);
		System.out.println("add to cart: " + addBtn);
		mysp.shopping();

	}

//Purchase more than one product directly from the My store Page
	// @Test(description = "choose more than one product direct from the home page")
	public void tc03_ChoosemorethanOneProduct() {
		MyStorePage mysp = new MyStorePage(driver);
		mysp.addToCartProducts("Faded Short Sleeve T-shirts");
		mysp.shopping();
		mysp.addToCartProducts("Faded Short Sleeve T-shirts");
		mysp.shopping();
		String actual = mysp.getMessageItemsInCart();
		String expected = "There are 2 items in your cart.";
		Assert.assertEquals(actual, expected);
		AllureAttachment.attachText("choose more than one product msg: " + actual);

	}
}
