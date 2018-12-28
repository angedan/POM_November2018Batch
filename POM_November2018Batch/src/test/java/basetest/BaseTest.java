package basetest;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.io.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import repo.ExcelApiTest;

public class BaseTest {
	
	//Some base tests for all the tests like opening and closing pages 

	public WebDriver driver;
	
	public FileInputStream fis = null; //To read any file
	public Properties config = null; // Creating an Object of the Properties class.
	public ExcelApiTest eat = null;
	
	public ExtentHtmlReporter extentHtmlReporter;
	public ExtentReports extentReports;
	public ExtentTest extentTest;
	
	@BeforeSuite
	
	public void init() throws IOException
	{
		//eat=new ExcelApiTest("C:\\Users\\adan\\Desktop\\TestData.xlsx");
		
		eat = new ExcelApiTest ("D:\\Java_Training_Workspace\\POM_November2018Batch\\src\\main\\resources\\TestData.xlsx");
		
		fis = new FileInputStream("D:\\Java_Training_Workspace\\POM_November2018Batch\\src\\main\\resources\\config.properties");
		config = new Properties();
		config.load(fis);
		
		if (extentHtmlReporter==null)
		{
			extentHtmlReporter =  new ExtentHtmlReporter("D:\\Java_Training_Workspace\\POM_November2018Batch\\src\\main\\resources\\adaReport.html");
			extentReports= new ExtentReports();
			extentReports.attachReporter(extentHtmlReporter);
			
			
			extentReports.setSystemInfo("UserName", "Angelo Dan");
			extentReports.setSystemInfo("Environment", "QA");
			
			extentHtmlReporter.config().setChartVisibilityOnOpen(true);
			extentHtmlReporter.config().setDocumentTitle("Automation Report");
			extentHtmlReporter.config().setReportName("adan Report");
			extentHtmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
			extentHtmlReporter.config().setTheme(Theme.DARK);
			
			
		}
		
    if(driver==null)
			
		{
           
		        System.setProperty("webdriver.chrome.driver", "D:\\a_Library\\chrome_new\\chromedriver.exe");             		      
                 driver = new ChromeDriver();
		}
			
			
			
	      driver.get("http://practice.automationtesting.in/");
	     
		
	 }
	
	public static String capture(WebDriver driver, String screenshotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = "D:\\Java_Training_Workspace\\POM_November2018Batch\\src\\main\\resources\\screenshot" +screenshotName+".png";
		File destination = new File(dest);
		org.openqa.selenium.io.FileHandler.copy(source, destination);
		
		return dest;
		

	}
	
	
	@AfterMethod
	public void getResult(ITestResult result) throws IOException
	{
		if (result.getStatus()==ITestResult.FAILURE)
		{
			extentTest.fail("Test Failed");
			extentTest.fail(result.getThrowable());
			String path = capture(driver, "SampleScreenshot");
			extentTest.fail("Find Screenshot Below:", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
		else if (result.getStatus()==ITestResult.SUCCESS)
		{
			extentTest.pass("Test passed");
		}
		else
		{
			extentTest.skip("Test Skipped");
			extentTest.skip(result.getThrowable());
			
		}
	}
				

	@AfterSuite
	public void tearDown() throws InterruptedException
	
	{
		extentReports.flush();
		
		if (driver != null)
		{
			Thread.sleep(5000);
			driver.quit();
		}
		
	}
}
