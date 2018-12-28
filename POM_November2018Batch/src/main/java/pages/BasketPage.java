package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class BasketPage extends BasePage {

	public BasketPage(WebDriver driver, ExtentTest extentTest) {
		super(driver, extentTest);
		
		PageFactory.initElements(driver, this );
				
	}
	
	@FindBy(xpath="//input[@name='coupon_code']")
	private WebElement couponCodeTextbox;
	@FindBy(xpath="//input[@name='apply_coupon']")
	private WebElement applyCouponCodeButton;
	@FindBy(xpath="//a[@class='checkout-button button alt wc-forward']")
	private WebElement proceedToCheckoutButton;
	
	
	public CheckOutPage ProceedToCheckOut()
	{
		couponCodeTextbox.sendKeys("Angelo Dan");
		applyCouponCodeButton.click();
		proceedToCheckoutButton.click();
		
		return new CheckOutPage(driver, extentTest);
		
	}
	
	

}
