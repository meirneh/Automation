package mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderSummaryPage extends BasePage{
	@FindBy(css = "#cart_navigation>button>span")
	private WebElement confBtn;
	@FindBy(css =".cheque-indent")
	private WebElement MssgConf;
	public OrderSummaryPage(WebDriver driver) {
		super(driver);

	}
	
    
	//Actions
	//Click on Confirmation button
	public void confirmOrder() {
		explicitWaitClickable(confBtn);
		click(confBtn);
	}
	//Validation
	// Get the text of the Confirmation Message
			public String getConfMessage() {
				return getText(MssgConf);

			}
}
