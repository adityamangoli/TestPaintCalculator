package testPaintCalculator.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testPaintCalculator.uiActions.DimensionCalculationPage;
import testPaintCalculator.uiActions.HomePage;

public class TC001_VerifyHappyPath {
	
	//create objects of the classes to invoke them in the test script
	WebDriver driver; 
	HomePage homepage;
	DimensionCalculationPage dimcalc;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\adity\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://127.0.0.1:5000/");
		driver.manage().window().maximize();
		
	}

	@Test
	public void verifyHappyPath() {
		//test case to enter number of rooms and provide data for calculation
		homepage = new HomePage(driver);
		
		homepage.enterNumberOfRooms("1");
						
		dimcalc = new DimensionCalculationPage(driver);
		
		dimcalc.enterDimensionCalculationDetails("5", "10", "15");
		
		//validation for calculation of total gallons for above data
		
		Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/h5")).getText(), "Total Gallons Required: 2");
		
	}
	
	@AfterClass
	public void endTest() throws InterruptedException {
		//kept thread sleep intentionally so that final page can be viewed from ui
		Thread.sleep(2000);
		driver.close();
		
	}
	
}


