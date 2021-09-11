package mystore.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTests {

	WebDriver driver;

	 @BeforeClass
	protected void setup(ITestContext testContext) {
		driver = WebDriverManager.chromedriver().create();
		testContext.setAttribute("WebDriver", this.driver);
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
