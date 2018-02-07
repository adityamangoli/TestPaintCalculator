package testPaintCalculator.uiActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	//Find all the webelements on the page using xpath
	WebDriver driver;
	
	
	@FindBy(xpath="/html/body/div/form/input[1]")
	WebElement numberOfRooms;
	
	@FindBy(xpath="/html/body/div/form/input[2]")
	WebElement submitButton;
	
	//constructor declaration for calling to test scripts
	public HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	//implementation to take values from test script 
	public String enterNumberOfRooms(String numOfRooms) {
		
		
		numberOfRooms.click();
		numberOfRooms.sendKeys(numOfRooms);
		submitButton.click();
		return numOfRooms;
		
		
	}

}
