package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

public class CheckOutPage extends BasePage {

	public CheckOutPage(WebDriver driver, ExtentTest extentTest) {
		super(driver, extentTest);
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(how = How.XPATH, using= "//input[@id='billing_first_name' ]" )
	private WebElement firstNameTextbox;
	@FindBy(xpath="//input[@id='billing_first_name']")
	private WebElement lastNameTextBox;
	@FindBy(xpath="//input[@id='billing_email' ]")
	private WebElement emailAdresstextbox;
	@FindBy(xpath="//input[@name='billing_address_1']")
	private WebElement addressTextbox;
	@FindBy(xpath="//input[@name='billing_city']")
	private WebElement cityTextbox;
	@FindBy(xpath="//input[@name='billing_postcode']")
	private WebElement zipCodeTextbox;
	@FindBy(xpath="//input[@id='payment_method_cod']")
	private WebElement cashOnDelevery;
	@FindBy(xpath="//input[@id='place_order']")
	private WebElement placeOrderButton;
	@FindBy(xpath="//input[@id='payment_method_bac']")
	private WebElement netbankingRadioButton;
	
	
	
	public void placeOrderByCODoption()
	{
		firstNameTextbox.sendKeys("Dan");
		extentTest.info("Entering First Name");
		lastNameTextBox.sendKeys("Angelo");
		extentTest.info("Entering Last Name");
		emailAdresstextbox.sendKeys("angelo@gmail.com");
		addressTextbox.sendKeys("Software Park");
		cityTextbox.sendKeys("Dalian");
		zipCodeTextbox.sendKeys("12345");
		cashOnDelevery.click();
		placeOrderButton.click();
		
	}
	
	public void placeOrderNetBankingOption()
	{
		firstNameTextbox.sendKeys("Dan");
		lastNameTextBox.sendKeys("Angelo");
		emailAdresstextbox.sendKeys("angelo@gmail.com");
		addressTextbox.sendKeys("Software Park");
		cityTextbox.sendKeys("Dalian");
		zipCodeTextbox.sendKeys("12345");
		netbankingRadioButton.click();
		//UserName
		//Password
		
		placeOrderButton.click();
		
	}
	
	

}
