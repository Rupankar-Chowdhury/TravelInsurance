package Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BasePackage.Base;

import org.testng.annotations.BeforeTest;

import VehicleInsurance.CarInsuranceDetails;
import Home.HomePage;
import dataProvider.ExcelDataProvider;

public class VehicleInsuranceTest extends Base{
	HomePage vt;
	CarInsuranceDetails cid;
	
	@BeforeClass
	public void initialize() {
		vt = new HomePage(driver);
		cid = new CarInsuranceDetails(driver);
	}

	//Open PolicyBazaar Website
	
	@BeforeClass
	public void openWebsite() throws InterruptedException
	{
		try{
			driver.get(link);
			reportPass("Link opened");
		}catch(Exception e) {
			reportFail(e.getMessage());
		}
	}
	
	@BeforeTest
	public void log() {
		logger=report.createTest("Vehicle Insuarance Invalid Details Report","2");
	}
	
	// SELECT A VEHICLE INSURANCE TYPE FROM HOVER MENU ON HOMEPAGE
	
	@Test(priority=1)
	public void hover_select()
	{
		try{
		vt.InsuranceProductsHover();
		reportPass("Hover on insurance menu");
		vt.motor();
		reportPass("Select Motor Insurance");
		}
		catch(Exception e)
		{
		reportFail(e.getMessage());
		}
	}
	
	// PROCEED WITHOUT CAR NUMBER
	
	@Test(priority=2)
	public void proceed_without_no()
	{
		try{
		cid.carNumber();
		reportPass("Click on proceed without car number");	
		}
		catch(Exception e)
		{
		reportFail(e.getMessage());
		}
	}

	// SELECT CITY AND REGION
	
	@Test(priority=3)
	public void city_region()
	{
		try{	
			cid.city();
			reportPass("Selct city");	
			cid.region();
			reportPass("Select region");
		}
		catch(Exception e)
		{
		reportFail(e.getMessage());
		}
	}

	// SELECT BRAND AND MODEL
	
	@Test(priority=4)
	public void brand_model()
	{
		try
		{
			cid.brand();
			reportPass("Select brand of car");
			cid.model();
			reportPass("Select model");
		}
		catch(Exception e)
		{
		reportFail(e.getMessage());
		}
	}

	// SELECT FUEL TYPE AND FUEL TYPE VARIANT
	
	@Test(priority=5)
	public void fuel_type_variant()
	{
		try{
			cid.fuelType();
			reportPass("Select fuel type");
			cid.fuelVariant();
			reportPass("Select fuel types's variant");
		}
		catch(Exception e)
		{
		reportFail(e.getMessage());
		}
	}

	// SELECT YEAR OF REGISTRATION
	
	@Test(priority=6)
	public void reg_year()
	{
		try{
			cid.year();
			reportPass("Select Year of Registration");
		}
		catch(Exception e)
		{
		reportFail(e.getMessage());
		}
	}
	
	// ENTER INVALID DETAILS AND VIEW PRICE
	
	@Test(priority=7, dataProvider="getData",dataProviderClass=ExcelDataProvider.class)
	public void invalidDetails(String numb1,String na,String em,String im) throws InterruptedException
	{
		try{		
		cid.name(na);
		reportPass("Enter a Name");
		cid.email(em);
		reportPass("Enter invalid Email");	
		cid.mobNumber(im);
		reportPass("Enter invalid Mobile Number");
		cid.viewPrices();
		reportPass("Click on VIEW PRICES button");	
		}
		catch(Exception e)
		{
		reportFail(e.getMessage());
		}
	}

	// INVALID DETAILS ERROR MESSAGE CAPTURE
	
	@Test(priority=8)
	public void invalidDetails_message_capture()
	{
		try{
			cid.invalidEmail();
			reportPass("Captured invalid email message");
			cid.invalidNumber();
			reportPass("Captured invalid mobile number message");
		}
		catch(Exception e)
		{
		reportFail(e.getMessage());
		}
	}
	//END
}
