package mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class SendtoaFriendPage extends BasePage {

	@FindBy(css = "#friend_name")
	private WebElement friendnameField;
	@FindBy(css = "#friend_email")
	private WebElement friendemailField;
	@FindBy(css = "#sendEmail")
	private WebElement sendemailBtn;
	@FindBy(css = ".fancybox-inner .button")
	private WebElement okBtn;
	@FindBy(css = "#send_friend_form_error")
	private WebElement erroremptyMsg;

	public SendtoaFriendPage(WebDriver driver) {
		super(driver);

	}

	// Actions
	@Step("fill name field:{0},fill email field:{1}")
	public void sendEmailtoFriend(String name, String email) {
		fillText(friendnameField, name);
		fillText(friendemailField, email);
		explicitWaitClickable(sendemailBtn);
		click(sendemailBtn);
	}

	// Validations

	public String getErrorEmptyMsg() {
		// sleep(1000);
		return getText(erroremptyMsg);

	}

}
