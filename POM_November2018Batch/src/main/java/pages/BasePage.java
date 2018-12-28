package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

public class BasePage {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	public ExtentTest extentTest;
	
	public BasePage(WebDriver driver, ExtentTest extentTest )
	{
		
		this.driver=driver;
		this.extentTest=extentTest;
	}
	
	public void waitUntilElementInvisible(WebElement element)
	{
		wait = new WebDriverWait(driver, 60);
	
		
	}

}
