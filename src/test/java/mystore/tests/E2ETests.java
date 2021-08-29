package mystore.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mystore.pageobjects.AddressesPage;
import mystore.pageobjects.AuthenticationPage;
import mystore.pageobjects.ChoosePaymentMethodPage;
import mystore.pageobjects.MyAccountPage;
import mystore.pageobjects.MyStorePage;
import mystore.pageobjects.OrderConfirmationPage;
import mystore.pageobjects.OrderSummaryPage;
import mystore.pageobjects.ProductPage;
import mystore.pageobjects.ShippingPage;
import mystore.pageobjects.ShoppingCartSummaryPage;
import utilities.AllureAttachment;

public class E2ETests extends BaseTests {
	// Perform login to the MyStore
	@Owner("Meir Nehemkin")
	@Test(description = "Perform Login ")
	@Description("Perform Login")
	@Severity(SeverityLevel.BLOCKER)
	public void tc01_Login() {
		MyStorePage mysp = new MyStorePage(driver);
		mysp.singIn();
		AuthenticationPage ap = new AuthenticationPage(driver);
		ap.registeredCreatedAccount("ItzjakCohen@gmail.com", "12345");
		MyAccountPage myap = new MyAccountPage(driver);
		String expected = "Welcome to your account. Here you can manage all of your personal information and orders.";
		String actual = myap.getMsgAccountCreated();
		Assert.assertEquals(actual, expected);
		AllureAttachment.attachText("message 1: " + actual);
		myap.returnToMyStorePage();
	}

	@Owner("Meir Nehemkin")
	@Test(description = "choose a product from the Page Product")
	@Description("choose a product from the Page Product")
	@Severity(SeverityLevel.BLOCKER)

	public void tc02_ChooseProduct() {
		MyStorePage mysp = new MyStorePage(driver);
		mysp.chooseProducts("Faded Short Sleeve T-shirts");
		ProductPage pp = new ProductPage(driver);
		pp.addToCart();
		String actual = pp.getInnSuccessAddMsg().trim();
		String expected = "Product successfully added to your shopping cart";
		Assert.assertEquals(actual, expected);
		AllureAttachment.attachText("message 2: " + actual);
		pp.toShoppingCart();
	}

	@Owner("Meir Nehemkin")
	@Test(description = "directing to addresses page")
	@Description("directing to addresses page")
	@Severity(SeverityLevel.BLOCKER)

	public void tc03_Addresses() {
		ShoppingCartSummaryPage scsp = new ShoppingCartSummaryPage(driver);
		scsp.toAdresses();
		AddressesPage addp = new AddressesPage(driver);
		String actual = addp.getThirdStep();
		String expected = "03. Address";
		Assert.assertEquals(actual, expected);
		AllureAttachment.attachText("message 3: " + actual);

	}

	@Owner("Meir Nehemkin")
	@Test(description = "directing to shipping page")
	@Description("directing to shipping page")
	@Severity(SeverityLevel.BLOCKER)

	public void tc04_Shipping() {
		AddressesPage addp = new AddressesPage(driver);
		addp.toShipping();
		ShippingPage sp = new ShippingPage(driver);
		String actual = sp.getFourStep();
		String expected = "04. Shipping";
		Assert.assertEquals(actual, expected);
		AllureAttachment.attachText("message 4: " + actual);
		sp.toPayment();
	}

	@Owner("Meir Nehemkin")
	@Test(description = "directing to choose payment page ", enabled = true)
	@Description("directing to choose payment page")
	@Severity(SeverityLevel.BLOCKER)

	public void tc05_PaymentByBankwire() {
		ChoosePaymentMethodPage cpmp = new ChoosePaymentMethodPage(driver);
		String actual = cpmp.getFifthStep();
		String expected = "05. Payment";
		Assert.assertEquals(actual, expected);
		AllureAttachment.attachText("message 5: " + actual);
		cpmp.payByBankwire();

	}

	@Owner("Meir Nehemkin")
	@Test(description = "directing to order summary page")
	@Description("directing to order summary page")
	@Severity(SeverityLevel.BLOCKER)

	public void tc06_PaymentConfirmation() {
		OrderSummaryPage osp = new OrderSummaryPage(driver);
		String actual = osp.getConfMessage();
		String expected = "You have chosen to pay by bank wire. Here is a short summary of your order:";
		Assert.assertEquals(actual, expected);
		AllureAttachment.attachText("message 6: " + actual);
		osp.confirmOrder();
	}

	@Owner("Meir Nehemkin")
	@Test(description = "directing to order confirmation page")
	@Description("directing to order confirmation page")
	@Severity(SeverityLevel.BLOCKER)

	public void tc07_OrderConfirmation() {
		OrderConfirmationPage ocp = new OrderConfirmationPage(driver);
		String actual = ocp.getConfirmInnMsg();
		String expected = "Your order on My Store is complete.";
		Assert.assertEquals(actual, expected);
		AllureAttachment.attachText("message 7: " + actual);
		ocp.toHomePage();

	}

	@Owner("Meir Nehemkin")
	@Test(description = "directing back to my store page")
	@Description("directing back to my store page")
	@Severity(SeverityLevel.BLOCKER)
	public void tc08_BacktoMyStorePage() {
		MyStorePage mysp = new MyStorePage(driver);
		String actual = mysp.getCart();
		String expected = "Cart (empty)";
		Assert.assertEquals(actual, expected, "cart should be empty but is not!!!!");
		AllureAttachment.attachText("message 8: " + actual);

	}
}
