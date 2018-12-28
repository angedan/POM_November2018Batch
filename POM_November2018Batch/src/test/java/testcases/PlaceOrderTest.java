package testcases;

//import org.testng.SkipException;
import org.testng.annotations.Test;

//import com.aventstack.extentreports.ExtentReports;

import basetest.BaseTest;
import pages.BasketPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.ProductDisplayPage;
import pages.SearchResultsPage;
//import repo.DataUtil;

public class PlaceOrderTest extends BaseTest {
	
	@Test 
	public void placeOrderByCOD()
	{
	/*	HomePage homepage = new HomePage(driver);
		homepage.searchBook();
		
		SearchResultsPage searchResultsPage= new SearchResultsPage(driver);
		searchResultsPage.clicjSearchedBook();
		
		ProductDisplayPage productDisplayPage = new ProductDisplayPage(driver);
		productDisplayPage.navigateToBasketPage();*/
		
		extentTest= extentReports.createTest("placeOrderByCOD");
				
		/*if (DataUtil.isTestExecutatble(eat, "sheetName", "placeOrderByCOD"))//Reusable code: Can put in BaseTest
		{*/
		HomePage homepage = new HomePage(driver, extentTest);
		SearchResultsPage searchResultsPage= homepage.searchBook();
		ProductDisplayPage productDisplayPage =searchResultsPage.clicjSearchedBook();
		BasketPage basketPage = (BasketPage) productDisplayPage.navigateToBasketPage();
		CheckOutPage checkoutPage=basketPage.ProceedToCheckOut();
		checkoutPage.placeOrderByCODoption();
		/*}
		else
		{
			throw new SkipException("Skipping the test as the test runmode is not yes.");
		}*/
	}
	
	

}
