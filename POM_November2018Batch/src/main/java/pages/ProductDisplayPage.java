package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class ProductDisplayPage extends BasePage {
	
	public ProductDisplayPage(WebDriver driver, ExtentTest extentTest)
	{
		super(driver, extentTest);
		PageFactory.initElements(driver, this);
		
	}
	
	 @FindBy(xpath= "//button[@type='submit']")
	 private WebElement addToBasket;
	 @FindBy(xpath="//a[@class='button wc-forward']")
	 private WebElement viewBasket;
	 
	  public BasketPage navigateToBasketPage()
	  {
		  addToBasket.click();
		  viewBasket.click();
		  
		  return new BasketPage(driver, extentTest);
		  
	  }
	 

}
