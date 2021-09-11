package mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class ReviewFormPage extends BasePage {
	@FindBy(css = "comment_title")
	private WebElement tittleField;
	@FindBy(css = "content")
	private WebElement contentTextField;
	@FindBy(css = "#submitNewMessage")
	private WebElement sendBtn;

	public ReviewFormPage(WebDriver driver) {
		super(driver);

	}

	// Actions
	@Step("fill title field:{0},fill text box{1}")
	public void writeReview(String tittle, String text) {
		fillText(tittleField, tittle);
		fillText(contentTextField, text);
		explicitWaitClickable(sendBtn);
		click(sendBtn);
	}

}
