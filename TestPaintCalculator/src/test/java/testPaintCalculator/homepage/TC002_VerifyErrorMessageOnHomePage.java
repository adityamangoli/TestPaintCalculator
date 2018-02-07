package testPaintCalculator.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testPaintCalculator.uiActions.HomePage;

public class TC002_VerifyErrorMessageOnHomePage {

	//create objects of the classes to invoke them in the test script
	
	WebDriver driver;
	HomePage homepage;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\adity\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://127.0.0.1:5000/");
		driver.manage().window().maximize();

	}

	@Test
	public void verifyHappyPath() {
		
		/*this attempt did not work because title attribute was either not present or was hidden. 
		I have written this code here to demonstrate my suggestion of resolving that issue.*/
			
			homepage = new HomePage(driver);
			String test = homepage.enterNumberOfRooms("0");
			//created if else, so that in future when data will be parameterized, it can handle logic for multiple values		
			if(test == "0")
			{
				Actions action = new Actions(driver);
				//Idea is to move mouse pointer on that textbox and hover on it, so that it can enable that text.
				WebElement element = driver.findElement(By.xpath("/html/body/div/form/input[1]"));
				action.moveToElement(element).moveToElement(driver.findElement(By.xpath("/html/body/div/form/input[1]"))).build().perform();
				String tooltiptext = driver.findElement(By.xpath("/html/body/div/form/input[1]")).getAttribute("title");
				System.out.println(tooltiptext);
			}
			
			else 
			{
				WebElement submit = driver.findElement(By.xpath("/html/body/div/form/input[2]"));
				submit.click();
			}
			

			
		}
		
	

	@AfterClass
	public void endTest() throws InterruptedException {
		//kept thread sleep intentionally so that final page can be viewed from ui
		Thread.sleep(2000);
		driver.close();

	}
}
