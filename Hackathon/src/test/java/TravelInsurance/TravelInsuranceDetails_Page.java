package TravelInsurance;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelInsuranceDetails_Page{
	WebDriver driver;
	public TravelInsuranceDetails_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	// SELECT EUROPEAN COUNTRY 
	
	@FindBy(xpath="//div[@id='favourite-country']/p[@class='countryButton'][text()='United Kingdom']")
	WebElement country;
	public void Eu_country() {
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//				  .withTimeout(Duration.ofSeconds(30))
//				  .pollingEvery(Duration.ofSeconds(5))
//				  .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.elementToBeClickable(country));

		country.click();
	}
	
	// CLICK NEXT BUTTON 
	
	@FindBy(className="travel_main_cta")
	WebElement next_button;
	public void nextButton() throws InterruptedException {
		next_button.click();
	}
	
	// DATE
	
	@FindBy(xpath="//div[@class='MuiPickersDateRangePickerInput-root']/div[1]")
	WebElement dtpckr;
	public void datePicker() {
		
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(dtpckr));
        
		dtpckr.click();
	}
	
	// START DATE
	
	@FindBy(xpath="//button[@aria-label='Aug 14, 2023']")
	WebElement startdt;
	public void startDate() {
	
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(startdt));
        
		startdt.click();
	}
	
	// END DATE
	
	@FindBy(xpath="//button[@aria-label='Aug 18, 2023']")
	WebElement enddt;
	public void endDate() {
		
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(enddt));
        
		enddt.click();
	}
	
	// NUMBER OF PEOPLE
	
	@FindBy(xpath="//label[text()='2']")
	WebElement nop;
	public void numberOfPeople() {
		nop.click();
	}
	
	// DROPDOWN FOR PERSON 1 AGE
	
	@FindBy(xpath="//div[contains(text(),'Select age of traveller 1')]")
	WebElement dropdown1;
	public void dropDown1() {
		dropdown1.click();
	}
	
	// SELECT AGE 21 FOR PERSON 1
	
	@FindBy(xpath="//label[text()='21 years']")
	WebElement age21;
	public void age1() {
		age21.click();
		}

	// DROPDOWN FOR PERSON 2 AGE
	
	@FindBy(xpath="//div[contains(text(),'Select age of traveller 2')]")
	WebElement dropdown2;
	public void dropDown2() {
		dropdown2.click();
	}
	
	// SELECT AGE 22 FOR PERSON 2
	
	@FindBy(xpath="//label[text()='22 years']")
	WebElement age22;
	public void age2() {
		age22.click();
	}
	
	// DISEASE SELECT NO
	
	@FindBy(xpath="//input[@id='ped_no']")
	WebElement nodisease;
	public void nodisease() {
		nodisease.click();
	}
	
	// VALID PHONE NUMBER INPUT
	
	@FindBy(css="#mobileNumber")
	WebElement mobnum;
	public void mobileNumber(String validMob) {
		mobnum.sendKeys(validMob);
	}
//   END
}
