package Test;
//import org.testng.annotations.*;
import org.testng.annotations.Test;

import BasePackage.Base;
import Home.HomePage;

//import HealthInsurance.HealthInsurance;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class HealthInsuranceTest extends Base{
	HomePage hi;
	@BeforeClass
	public void initialize()
	{
		hi=new HomePage(driver);
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
		logger=report.createTest("Health Insurance Menu Items Report","3");
	}
	
	// HEALTH INSURANCE DROPDOWN MOUSE HOVER CLICK ON HOMEPAGE
	
	@Test(priority=1)
	public void hover_on_insuranceProducts_dropdown() {
		
		try {
			hi.InsuranceProductsHover();
			reportPass("Hover on insurance menu");
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			reportFail(e.getMessage());
		}
	}

	// HEALTH INSURANCE MENU ITEM SELECTION ON HOMEPAGE
	
	@Test(dependsOnMethods = "hover_on_insuranceProducts_dropdown")
	public void extract_HealthInsurance_menu_items() {
		
		try {
			hi.insuranceList();
			reportPass("Extract Health Insurance menu items");
			
		}catch(Exception e){
			System.out.println(e.getMessage());
			reportFail(e.getMessage());
		}
	}
}