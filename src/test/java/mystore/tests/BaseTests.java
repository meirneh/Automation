package mystore.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTests {
	WebDriver driver;
	private ChromeDriverService chromeOptions;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}
	/* @BeforeClass
	 protected void setup(ITestContext testContext) {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver(chromeOptions);
	  testContext.setAttribute("WebDriver", this.driver);
	  
	  testContext.setAttribute("WebDriver", this.driver);
	  driver.get("http://automationpractice.com/index.php");
	  System.out.println("was 1 now is 2");
	 }*/

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
