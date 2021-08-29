package mystore.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import mystore.pageobjects.MessagePage;
import mystore.pageobjects.MyStorePage;
import mystore.pageobjects.ProductPage;
import mystore.pageobjects.SendtoaFriendPage;
import utilities.AllureAttachment;

public class ProductPageTest extends BaseTests {

	@Owner("Meir Nehemkin")
	@Test(description = "choose a product and add to cart ,close and back to product page")
	@Description("choose a product and add to cart ,close and back to the Product page")
	@Severity(SeverityLevel.CRITICAL)

	public void tc01_ChooseProductAndAddToCart() {
		MyStorePage mysp = new MyStorePage(driver);
		mysp.chooseProducts("Blouse");
		ProductPage pp = new ProductPage(driver);
		pp.addToCart();
		String actual = pp.getInnSuccessAddMsg().trim();
		String expected = "Product successfully added to your shopping cart";
		Assert.assertEquals(actual, expected);
		AllureAttachment.attachText("message 1: " + actual);
		pp.closeAddCartPage();
		pp.toMyStorePage();

	}

	@Owner("Meir Nehemkin")
	@Test(description = "choose and add to cart more than one product")
	@Description("choose and add to cart more than one product")
	@Severity(SeverityLevel.CRITICAL)
	public void tc02_ChooseMoreThanOneProduct() {
		MyStorePage mysp = new MyStorePage(driver);
		mysp.chooseProducts("Blouse");
		ProductPage pp = new ProductPage(driver);
		pp.addToCart();
		pp.continueShopping();
		pp.toMyStorePage();
		mysp.chooseProducts("Faded Short Sleeve T-shirts");
		pp.addToCart();
		String actual = pp.getInnSuccessAddMsg().trim();
		String expected = "Product successfully added to your shopping cart";
		Assert.assertEquals(actual, expected);
		AllureAttachment.attachText("message 2: " + actual);
		pp.closeAddCartPage();
		pp.toMyStorePage();
	}

	@Owner("Meir Nehemkin")
	@Test(description = "increase the quantity of chosen product")
	@Description("increase the quantity of a chosen product")
	@Severity(SeverityLevel.CRITICAL)
	public void tc03_IncreaseQuantityProduct() {
		MyStorePage mysp = new MyStorePage(driver);
		mysp.chooseProducts("Blouse");
		ProductPage pp = new ProductPage(driver);
		long beforequantity = pp.getQuantity();
		AllureAttachment.attachText("QUANTITY: " + beforequantity);
		pp.addQuantity();
		long afterquantity = pp.getQuantity();
		AllureAttachment.attachText("QUANTITY: " + afterquantity);
		Assert.assertEquals(afterquantity, beforequantity + 1);
		pp.toMyStorePage();
	}

	@Owner("Meir Nehemkin")
	@Test(description = "decrease the quantity of chosen product")
	@Description("decrease the quantity of a chosen product")
	@Severity(SeverityLevel.CRITICAL)
	public void tc04_DecreaseQuantityProduct() {
		MyStorePage mysp = new MyStorePage(driver);
		mysp.chooseProducts("Blouse");
		ProductPage pp = new ProductPage(driver);
		pp.addQuantity();
		long actualquantity = pp.getQuantity();
		System.out.println("QUANTITY: " + actualquantity);
		pp.reduceQuantity();
		long afterquantity = pp.getQuantity();
		System.out.println("QUANTITY: " + afterquantity);
		Assert.assertEquals(afterquantity, actualquantity - 1);
		pp.toMyStorePage();

	}

	@Owner("Meir Nehemkin")
	@Test(description = "send an email to a friend")
	@Description("send an email to a friend")
	@Severity(SeverityLevel.CRITICAL)
	public void tc05_sendtoafriendfromChooseProduct() {
		MyStorePage mysp = new MyStorePage(driver);
		mysp.chooseProducts("Blouse");
		ProductPage pp = new ProductPage(driver);
		pp.sendToFriend();
		SendtoaFriendPage stafp = new SendtoaFriendPage(driver);
		stafp.sendEmailtoFriend("meir", "meirnehemkin@gmail.com");

		MessagePage msgp = new MessagePage(driver);
		String actual = msgp.getSuccesssEndMsg();
		String expected = "Your e-mail has been sent successfully";
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
		msgp.clickOK();
		pp.toMyStorePage();

	}

}
