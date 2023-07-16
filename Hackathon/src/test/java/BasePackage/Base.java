package BasePackage;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.ExtentTest;

import report.ExtentReport;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public WebDriver driver;
	public ExtentReports report=ExtentReport.getReportInstance();
	public ExtentTest logger;
	public String link="https://policybazaar.com";
	
	
	@Parameters("browser")
	@BeforeClass
	public void openBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		
		ExtentHtmlReporter report = new ExtentHtmlReporter("D:\\eclipse_workspace\\Hackathon\\src\\test\\resources\\report");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(report);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void reportPass(String report)
	{
		logger.log(Status.PASS, report);
	}
	
	public void reportFail(String report)
	{
		logger.log(Status.FAIL, report);
	}
	
	@AfterTest
	public void reportend() {
		report.flush();

	}
	
	@AfterClass
	public void close()
	{
		driver.quit();
	}
}