package mystore.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mystore.pageobjects.MyStorePage;
import mystore.pageobjects.ProductPage;
import mystore.pageobjects.ShoppingCartSummaryPage;
import utilities.AllureAttachment;

public class CartSummaryPageTests extends BaseTests {
	@Owner("Meir Nehemkin")
	@Test(description = "directing to shopping cart summary page")
	@Description("directing to The Shopping Cart Summary Page")
	@Severity(SeverityLevel.BLOCKER)
	public void tc01DirectingToShoppingCartSummaryTest() {
		AllureAttachment.attachText("Start test01");
		MyStorePage mysp = new MyStorePage(driver);
		mysp.chooseProducts("Faded Short Sleeve T-shirts");
		ProductPage pp = new ProductPage(driver);
		pp.addToCart();
		pp.toShoppingCart();
		ShoppingCartSummaryPage scsp = new ShoppingCartSummaryPage(driver);
		String actual = scsp.getStageTitle();
		String expected = "01. Summary";
		System.out.println("Title: " + actual);
		Assert.assertEquals(actual, expected);
		scsp.DeleteProduct();
		scsp.toMyStore();

	}

	@Owner("Meir Nehemkin")
	@Test(description = "increase the quantity of the chosen product")
	@Description("increase the quantity of the chosen product")
	@Severity(SeverityLevel.NORMAL)
	public void tc02IncreaseQuantityProduct() {
		MyStorePage mysp = new MyStorePage(driver);
		mysp.chooseProducts("Printed Dress");
		ProductPage pp = new ProductPage(driver);
		pp.addToCart();
		pp.toShoppingCart();
		ShoppingCartSummaryPage scsp = new ShoppingCartSummaryPage(driver);
		int beforequantity = scsp.getQuantity();
		AllureAttachment.attachText("The quantity is: " + beforequantity);
		scsp.IncreaseQuantity();
		int afterquantity = scsp.getQuantity();
		AllureAttachment.attachText("The quantity is: " + afterquantity);
		System.out.println("QUANTITY: " + afterquantity);
		Assert.assertEquals(afterquantity, beforequantity + 1);
		scsp.DeleteProduct();
		scsp.toMyStore();

	}

	@Owner("Meir Nehemkin")
	@Test(description = "decrease the quantity of the chosen product")
	@Description("decrease the quantity of the chosen product")
	@Severity(SeverityLevel.NORMAL)

	public void tc03_DecreaseQuantityProduct() {
		MyStorePage mysp = new MyStorePage(driver);
		mysp.chooseProducts("Blouse");
		ProductPage pp = new ProductPage(driver);
		pp.addToCart();
		pp.toShoppingCart();
		ShoppingCartSummaryPage scsp = new ShoppingCartSummaryPage(driver);
		scsp.IncreaseQuantity();
		int beforequantity = scsp.getQuantity();
		AllureAttachment.attachText("The quantity is: " + beforequantity);
		scsp.reduceQuantity();
		int afterquantity = scsp.getQuantity();
		AllureAttachment.attachText("The quantity is: " + afterquantity);
		Assert.assertEquals(afterquantity, beforequantity - 1);
		scsp.DeleteProduct();
		scsp.toMyStore();
	}

	@Owner("Meir Nehemkin")
	@Test(description = "delete the chosen product")
	@Description("delete the chosen product")
	@Severity(SeverityLevel.CRITICAL)

	public void tc04_DeleteProduct() {
		MyStorePage mysp = new MyStorePage(driver);
		mysp.chooseProducts("Printed Chiffon Dress");
		ProductPage pp = new ProductPage(driver);
		pp.addToCart();
		pp.toShoppingCart();
		ShoppingCartSummaryPage scsp = new ShoppingCartSummaryPage(driver);
		scsp.DeleteProduct();
		String actual = scsp.getEmptyMsg();
		System.out.println("Message: " + actual);
		String expected = "Your shopping cart is empty.";
		Assert.assertEquals(actual, expected);
		scsp.toMyStore();
	}

	@Owner("Meir Nehemkin")
	@Test(description = "directing back to Product page by image of chosen product")
	@Description("directing back to Product page by image of chosen product")
	@Severity(SeverityLevel.MINOR)
	public void tc05_DirectingToProductPageByIMage() {
		MyStorePage mysp = new MyStorePage(driver);
		mysp.chooseProducts("Printed Chiffon Dress");
		ProductPage pp = new ProductPage(driver);
		pp.addToCart();
		pp.toShoppingCart();
		ShoppingCartSummaryPage scsp = new ShoppingCartSummaryPage(driver);
		scsp.goToProdPageByImage();
		String actual = pp.getName();
		System.out.println("The name of the product is: " + actual);
		String expected = "Printed Chiffon Dress";
		Assert.assertEquals(actual, expected);
		pp.toMyStorePage();
	}
}
