package mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MessagePage extends BasePage {

	@FindBy(css = "[value='OK']")
	private WebElement OKBtn;
	@FindBy(css = ".fancybox-inner > p:nth-child(2)")
	private WebElement successsendMsg;
	public MessagePage(WebDriver driver) {
		super(driver);

	}

	// Actions
	//Click OK button
	public void clickOK() {
	explicitWaitClickable(OKBtn);
		click(OKBtn);
	}
	// Validations
    //Get a Success Message 
	public String getSuccesssEndMsg() {
		sleep(1000);
		return getText(successsendMsg);

	}
	//Get a Success send Review
	public String getSuccessSendReviewMsg() {
		sleep(500);
		return getText(successsendMsg);
	}
	
}
