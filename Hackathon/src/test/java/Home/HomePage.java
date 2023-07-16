package Home;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

    //             ------------------------------ TRAVEL INSURANCE ------------------------------


	// CLICK ON TRAVEL BUTTON ON HOMEPAGE
	
	@FindBy(xpath="//i[@class='icon-bg homeIconsBg icon-bg-new ti']")
	WebElement travelbtn;
	
	public void travelBtnClick() {
		travelbtn.click();
	}	
	

    //             ------------------------------ INSURANCE PRODUCTS HOVER ------------------------------	

	
	
	// INSURANCE PRODUCTS DROPDOWN MOUSE HOVER ON HOMEPAGE 
	
	@FindBy(xpath="//a[contains(text(),'Insurance Products')]")
	WebElement insuranceProductsHover;
	public void InsuranceProductsHover()
	{
		 Actions action=new Actions(driver);
	     action.moveToElement(insuranceProductsHover).build().perform();
	        try {Thread.sleep(100);
	        }catch(InterruptedException e){
	        e.printStackTrace();}
	}
	
	
    //             ------------------------------ VEHICLE INSURANCE ------------------------------	

	
	
	// CLICK ON MOTOR INSURANCE UNDER VEHICLE INSURANCE FROM INSURANCE PRODUCTS DROPDOWN
	//div[@class='ruby-col-3 hidden-md']//span[@itemprop='name'][text()='Motor Insurance']
	
	@FindBy(xpath="//div[@class='ruby-col-3 hidden-md']//span[text()='Motor Insurance']")
	WebElement motorInsurance;
	public void motor()
	{
		motorInsurance.click();
	}
	
	
    //             ------------------------------ HEALTH INSURANCE ------------------------------
	
	

	// HEALTH INSURANCE MENU ITEM(S) SELECTION FROM DROPDOWN
	//div[@class='ruby-col-3 hidden-md'][2]/ul/li/a/span
	
	@FindBy(xpath="//div[@class='ruby-col-3 hidden-md'][2]//span[@itemprop='name']")
	List<WebElement> Hmenu;
	public void insuranceList() {
		System.out.println("Scenario 3 : ");
		List<String> listItem=new ArrayList<String>();
        System.out.println("\nHealth Insurance Menu Items : ");
        System.out.println();
        for(int i=0;i<Hmenu.size();i++)        
        {
            WebElement e = Hmenu.get(i);
            listItem.add(e.getText());
        }
        for(int i=0;i<listItem.size();i++)        
        {
            System.out.println(listItem.get(i));
        }
	}
}