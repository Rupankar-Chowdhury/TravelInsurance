package Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BasePackage.Base;
//import TravelInsurance.TravelInsurance;
import Home.HomePage;
import TravelInsurance.TravelInsuranceDetails_Page;
import TravelInsurance.TravelPlanView_Page;
import dataProvider.ExcelDataProvider;

public class TravelInsuranceTest extends Base {

	HomePage t;
	TravelInsuranceDetails_Page ds;
	TravelPlanView_Page tplv;
	
	@BeforeClass
	public void initialize() {
		t = new HomePage(driver);
		ds = new TravelInsuranceDetails_Page(driver);
		tplv = new TravelPlanView_Page(driver);
	}
	
	//Open PolicyBazaar Website
	
	@BeforeClass
	public void openWebsite() throws InterruptedException
	{
		try {
			driver.get(link);
			reportPass("Link opened");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	@BeforeTest
	public void log() {
		logger=report.createTest("3 Lowest Travel Insuarance Plan for 2 students Report","1");
	}
	
	// TRAVEL INSURANCE BUTTON CLICK ON HOMEPAGE

	@Test(priority=1)
	public void travel_insurance_button() throws InterruptedException
	{
		try
		{
		t.travelBtnClick();
		reportPass("Click on Travel Button");
		}
		catch(Exception e)
		{
		reportFail(e.getMessage());
		}
	}
	
	//           ---------------------------- TRAVEL INSURANCE DETAILS PAGE TEST CASES ---------------------------- 
	
	// COUNTRY SELECTION 
	
	@Test(dependsOnMethods = "travel_insurance_button")
	public void country_selection()
	{
		try{
		ds.Eu_country();
		reportPass("Click country selection text box");
		ds.nextButton();
		reportPass("Click next button");
		}
		catch(Exception e)
		{
		reportFail(e.getMessage());
		}
	}
	
	// DATE PICKER TEST CASES 
	
	@Test(dependsOnMethods = "country_selection")
	public void checkInOut_Date() throws InterruptedException
	{
		try{
			ds.datePicker();
			reportPass("Click check-in check-out date selection text box");
			ds.startDate();
			reportPass("Select check-in date");
			ds.endDate();			
			reportPass("Select check-out date");
			ds.nextButton();
			reportPass("Click next button");
		}
		catch(Exception e)
		{
		reportFail(e.getMessage());
		}		
	}	

	// NUMBER OF PEOPLE AND AGE SELECTION TEST CASES

	@Test( dependsOnMethods = "checkInOut_Date")
	public void people_and_age() throws InterruptedException
	{
		try{
			ds.numberOfPeople();
			reportPass("Select number of people travelling");
			ds.dropDown1();
			reportPass("Click age selection drodown box for first person");
			ds.age1();			
			reportPass("Select age of first person");
			ds.dropDown2();
			reportPass("Click age selection drodown box for second person");
			ds.age2();
			reportPass("Select age of second person");
			ds.nextButton();
			reportPass("Click next button");						
		}
		catch(Exception e)
		{
		reportFail(e.getMessage());
		}	
	}
	
	// DISEASE CHECKER TEST CASES 
	
	@Test(dependsOnMethods = "people_and_age")
	public void disease()
	{		
		try{
			ds.nodisease();
			reportPass("Select no for disease check");
			ds.nextButton();
			reportPass("Click next button");						
		}
		catch(Exception e)
		{
		reportFail(e.getMessage());
		}			
	}
	
	// PHONE NUMBER INPUT TEST CASES 
	
	@Test(dependsOnMethods = "disease",dataProvider="getData",dataProviderClass=ExcelDataProvider.class)
	public void mobileNo(String numb1,String na,String em,String im)
	{
		try{
			ds.mobileNumber(numb1);
			reportPass("Send Mobile Number");
			ds.nextButton();
			reportPass("Click View Plans button");						
		}
		catch(Exception e)
		{
		reportFail(e.getMessage());
		}
	}

	//           ---------------------------- TRAVEL PLAN VIEW PAGE TEST CASES ---------------------------- 

	// STUDENT AGES 
	
	@Test(dependsOnMethods = "mobileNo")
	public void age_of_students()
	{
		try{
			tplv.studentPlanView();
			reportPass("Student Plan");		
			tplv.travellerSelect1();
			reportPass("Selected first student age");	
			tplv.travellerSelect2();
			reportPass("Selected second student age");
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
	}

	// DURATION SELECT
	
	@Test(dependsOnMethods = "age_of_students")
	public void duration()
	{
		try{
			tplv.durationSelector();
			reportPass("Duration selected");
			tplv.applyDuration();
			reportPass("Duration apllied");
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
	}
	
	// SORT ASCENDING ORDER

	@Test(dependsOnMethods = "duration")
	public void sort_low_to_high()
	{
		try{
			tplv.sort_By();
			reportPass("click on sortBy");		
			tplv.premLowToHigh();
			reportPass("Select Low to High");	
			tplv.apply();
			reportPass("Click Apply");
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
	}
	
	// TRAVEL PLAN PRICE AND NAME DISPLAY TEST CASES 
	
	@Test(dependsOnMethods = "sort_low_to_high")
	public void display_3_lowest_plans()
	{
		try{
			tplv.showPlans();
			reportPass("3 lowest Plans showed with price and name");			
		}
		catch(Exception e)
		{
			reportFail(e.getMessage());
		}
	}

// END
	
}