package mystore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAddressesPage extends BasePage {

	@FindBy(css = ".address_update a:nth-child(1) ")
	private WebElement updateBtn;
	@FindBy(css = "div:nth-child(2) >ul>li.address_update>a:nth-child(2)")
	private WebElement deleteaddress;
	@FindBy(css = ".address_phone")
	private WebElement addressphone;
	@FindBy(css = ".address_phone_mobile")
	private WebElement addressmobile;
	@FindBy(css = "[title='Add an address']")
	private WebElement addAddressBtn;
	@FindBy(css = ".center_column > ul > li:nth-child(2) ")
	private WebElement homeBtn;
	@FindBy(css = ".last_item.alternate_item.box .page-subheading")
	private WebElement alternAddress;
    @FindBy(css =".last_item.alternate_item.box")
    private WebElement alternBlockAddress;
	public MyAddressesPage(WebDriver driver) {
		super(driver);

	}

	// action
	// Click on Update button
	public void updateInfo() {
		explicitWaitClickable(updateBtn);
		click(updateBtn);
	}

	// Click on Add a new address button
	public void addNewAddress() {
		explicitWaitClickable(addAddressBtn);
		click(addAddressBtn);
	}

	// Delete the address
	public void deleteAddress() {
		explicitWaitClickable(deleteaddress);
		click(deleteaddress);
		alertOK();
	}

	// Back to My Store page
	public void backToMyStorePage() {
		// explicitWaitClickable(homeBtn);
		explicitWaitClickable(homeBtn);
		click(homeBtn);
	}

	// validation
	// Get the phone number
	public String getAddressPhone() {
		return getText(addressphone);

	}

	// Get the cell number
	public String getAddressMobile() {
		return getText(addressmobile);

	}

	// Get the added address name
	public String getAlternAddress() {
		return getText(alternAddress);
	}
    //Get all the data of the added address
	public String getAlternBlockAddress() {
		sleep(1000);
		return getText(alternBlockAddress);
	}
	
	//Get Alias of the other address
	public String getNewAlias() {
		return getNewAlias();
	}
	//Validation the not exist  address
	public boolean notExistsElement() {
		try {
			driver.findElement(By.cssSelector(".last_item.alternate_item.box .page-subheading"));
		} catch (NoSuchElementException e) {
			return true;
		}
		return true;
	}

}
