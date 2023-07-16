package TravelInsurance;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelPlanView_Page {
	WebDriver driver;
	public TravelPlanView_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	// CLICK ON STUDENT PLANS
	
	@FindBy(id="student-trip-desktop")
	WebElement studentplanBtn;
	public void studentPlanView() {
		
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(studentplanBtn));
        
		studentplanBtn.click();
	}

	// SELECT TRAVELLER 1 OF AGE 21
	
	@FindBy(id="Traveller_1")
	WebElement traveller1Btn;
	public void travellerSelect1() {
		
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(traveller1Btn));
        
		traveller1Btn.click();
	}

	// SELECT TRAVELLER 2 OF AGE 22
	
	@FindBy(id="Traveller_2")
	WebElement traveller2Btn;
	public void travellerSelect2() {
		
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(traveller2Btn));
        
		traveller2Btn.click();
	}

	// CLICK ON TRAVEL DURATION DROPDOWN
	
	@FindBy(xpath="//select[@id='feet']")
	WebElement durations;
	public void durationSelector() {
		durations.click();
		Select s = new Select(durations);
		s.selectByIndex(1);
	}

	// CLICK ON APPLY BUTTON
		
	@FindBy(className="pqCtaWrapper")
	WebElement applydur;
	public void applyDuration() {
		applydur.click();
	}

	// CLICK ON SORT-BY BUTTON
	
	@FindBy(linkText="Sort by")
	WebElement sortby;
	public void sort_By() {
		sortby.click();
	}

	// SELECT Premium low to high
		
	@FindBy(xpath="//input[@id='17']")
	WebElement prem;
	public void premLowToHigh() throws InterruptedException {
		prem.click();
	}
	
	// CLICK ON APPLY BUTTON
	
	@FindBy(xpath="//button[text()='Apply']")
	WebElement apply;
	public void apply() {
		apply.click();
	}

	// SHOW 3 LOWEST TRAVEL INSURANCE PLAN FOR 2 STUDENTS AGED 21 AND 22
		
	@FindBy(className="premiumPlanPrice")
	List<WebElement> plan_Price;
		
	@FindBy(className="quotesCard--insurerName")
	List<WebElement> Insurer_Name;
		
	public void showPlans() 
	{
	     System.out.println("Scenario 1 : ");
	     System.out.println();
	     for(int i=0;i<3;i++)
	     {
	         //Extract Name of insurance company
	         WebElement ele1 = Insurer_Name.get(i);
	         String name = ele1.getText();

	         //Extract price of respective insurance company
	         WebElement ele=plan_Price.get(i);
	         String price = ele.getText();

	         System.out.println("Company Name : "+name+"  ,  Price : "+price);
	     }
	     try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
//   END 
	
}
