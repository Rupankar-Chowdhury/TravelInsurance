package VehicleInsurance;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class CarInsuranceDetails {
		public WebDriver driver;
		public CarInsuranceDetails(WebDriver driver) {
			PageFactory.initElements(driver, this);
			this.driver=driver;
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		// PROCEED WITHOUT CAR NUMBER
		
		@FindBy(xpath="//button[text()='Proceed without car number']")
		WebElement car_number;
		public void carNumber() {
			car_number.click();
		}
		
		// CITY
		
		@FindBy(xpath="//div[contains(text(),'Delhi')]")
		WebElement city_name;
		public void city() {
	        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	        wait.until(ExpectedConditions.elementToBeClickable(city_name));
	        city_name.click();
		}
		
		// REGION
		
		@FindBy(xpath="//span[text()='DL1']")
		WebElement region_name;
		public void region() {
			region_name.click();
		}
		
		// BRAND
		
		@FindBy(xpath="//span[text()='Maruti']")
		WebElement brand_name;
		public void brand() {
			brand_name.click();
		}
		
		// MODEL
		
		@FindBy(xpath="//span[text()='ALTO']")
		WebElement model_name;
		public void model() {
			model_name.click();
		}
		
		// FUEL TYPE
		
		@FindBy(xpath="//span[text()='CNG']")
		WebElement fuel_type;
		public void fuelType() {
			fuel_type.click();
		}
		
		// FUEL VARIANT
		
		@FindBy(xpath="//ul[@class='other-model-wise other-variants']//span[@class='text'][text()='LX CNG']")
		WebElement fuel_variant;
		public void fuelVariant() {
			fuel_variant.click();
		}
		
		// REGISTRATION YEAR
		
		@FindBy(xpath="//span[text()='2019']")
		WebElement regyear;
		public void year() {
			regyear.click();
		}
		
		// NAME ENTER
		
		@FindBy(id="txtName")
		WebElement name_text_field;
		public void name(String name) {
			name_text_field.sendKeys(name);
		}
		
		// EMAIL ENTER
		
		@FindBy(id="txtEmail")
		WebElement email_text_field;
		public void email(String invEmail) {
			email_text_field.sendKeys(invEmail);
		}
		
		// PHONE NUMBER ENTER
		
		@FindBy(id="mobNumber")
		WebElement phnumber_txt_field;
		public void mobNumber(String mob) {
			phnumber_txt_field.sendKeys(mob);
		}
		
		// VIEW PRICE	   
		
		@FindBy(xpath="//div[@class='button btnOrange']")
		WebElement vwpricbtn;
		public void viewPrices() {
			vwpricbtn.click();
		}
		
		// CAPTURE INVALID EMAIL MESSAGE
		
		@FindBy(xpath="//div[contains(text(),'Please enter valid email address')]")
		WebElement inv_email;
		public void invalidEmail() {
			System.out.println("Scenario 2 : ");
			System.out.println("\n"+inv_email.getText());
		}
		
		// CAPTURE INVALID PHONE NUMBER MESSAGE
		
		@FindBy(xpath="//div[contains(text(),'Please enter valid mobile number')]")
		WebElement inv_phoneno;
		public void invalidNumber() {
			System.out.println(inv_phoneno.getText());
			
		}
	}