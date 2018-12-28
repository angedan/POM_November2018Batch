package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class HomePage extends BasePage {
	
	
	public HomePage(WebDriver driver, ExtentTest extentTest)
	{
		super(driver, extentTest);
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(id="s")
	private WebElement searchTextbox;
		
	public SearchResultsPage searchBook()
	{
		searchTextbox.sendKeys("selenium");
		searchTextbox.sendKeys(Keys.ENTER);
		
		return new SearchResultsPage(driver, extentTest);
		
	}

}
