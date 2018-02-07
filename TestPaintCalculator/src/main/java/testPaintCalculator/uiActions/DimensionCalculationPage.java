package testPaintCalculator.uiActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DimensionCalculationPage {

	//Find all the webelements on the page using xpath
	WebDriver driver;
	
	@FindBy(xpath="/html/body/div/form/table/tbody/tr[2]/td[2]/input")
	WebElement length;
	
	@FindBy(xpath="/html/body/div/form/table/tbody/tr[2]/td[3]/input")
	WebElement width;
	
	@FindBy(xpath="//*[@id=\"height\"]")
	WebElement height;
	
	@FindBy(xpath="/html/body/div/form/input")
	WebElement submitButton;
	
	//constructor declaration for calling to test scripts
	public DimensionCalculationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	
	//implementation to take values from test script 
	public void enterDimensionCalculationDetails(String rlength, String rwidth, String rheight) {
		
		length.sendKeys(rlength);
		width.sendKeys(rwidth);
		height.sendKeys(rheight);
		submitButton.click();
	}
	
}
