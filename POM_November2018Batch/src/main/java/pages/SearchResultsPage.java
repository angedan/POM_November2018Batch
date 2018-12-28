package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class SearchResultsPage extends BasePage {
	
	
	public SearchResultsPage(WebDriver driver, ExtentTest extentTest)
	{
		super(driver, extentTest);
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath= "//a[@title='Selenium Ruby']")
	private WebElement searchREsultsBookTitle;
	
	public ProductDisplayPage clicjSearchedBook()
	{
		
		searchREsultsBookTitle.click();
		
		return new ProductDisplayPage(driver, extentTest);
	}

}