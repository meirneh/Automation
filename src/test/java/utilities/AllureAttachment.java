package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Attachment;

public class AllureAttachment {
	@Attachment(value = "{0}", type = "text/plain", fileExtension = ".txt")
	public static String attachText(String message) {
		return message;
	}
	@Attachment(value = "Page Screenshot", type = "image/png", fileExtension = ".png")
	 static byte[] attachScreenshot(WebDriver driver) {
	  return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	 }
}
