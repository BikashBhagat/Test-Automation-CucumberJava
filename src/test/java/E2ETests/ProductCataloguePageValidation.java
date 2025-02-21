package E2ETests;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import ecommerce.pageobjects.CartPage;
import ecommerce.pageobjects.CheckOutPage;
import ecommerce.pageobjects.LogInPage;
import ecommerce.pageobjects.OrdersPage;
import ecommerce.pageobjects.ProductCatalogue;

public class ProductCataloguePageValidation extends BaseTest  {


	@Test(enabled=false)
    public void VerifyAddtoCartMsg() throws IOException{
        String username = "smasherrock33@gmail.com";
		String password = "Smasher@123";
		String product = "ADIDAS ORIGINAL";
		LogInPage logInPage = launchApplication("https://rahulshettyacademy.com/client");
		// launch URL and do log in
		ProductCatalogue productCatalogue = logInPage.doLogIn(username, password);
		String Title = logInPage.getTitle();
		Assert.assertEquals(Title, "Let's Shop");
		// Select products
		WebElement msg = productCatalogue.addProductToCart(product);
		Assert.assertTrue(msg.isDisplayed());
    }
	
	@Test
	public void submitOrder() throws IOException {
		String username = "smasherrock33@gmail.com";
		String password = "Smasher@123";
		
		LogInPage logInPage = launchApplication("https://rahulshettyacademy.com/client");
		// launch URL and do log in
		ProductCatalogue productCatalogue = logInPage.doLogIn(username, password);
		String Title = logInPage.getTitle();
		Assert.assertEquals(Title, "Let's Shop");
		String product = "ADIDAS ORIGINAL";
		// Select products
		WebElement msg = productCatalogue.addProductToCart(product);
		Assert.assertTrue(msg.isDisplayed());
		CartPage cartPage = productCatalogue.goToCartPage();
		// VerifyOrder Details
		Assert.assertTrue(cartPage.verifyOrder(product).contains(product));
		CheckOutPage checkOut = cartPage.goTOCheckOut();
		// Fill Details in CheckOut Page
		checkOut.fillDetails();
		checkOut.selectCountry();
		OrdersPage ordersPage = checkOut.placeOrder();
	}
	
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void verfyOrderHistory() throws IOException {
		String username = "smasherrock33@gmail.com";
		String password = "Smasher@123";
		String product = "ADIDAS ORIGINAL";
		LogInPage logInPage = launchApplication("https://rahulshettyacademy.com/client");
		// launch URL and do log in
		ProductCatalogue productCatalogue = logInPage.doLogIn(username, password);
		String Title = logInPage.getTitle();
		Assert.assertEquals(Title, "Let's Shop");
		
		OrdersPage orderspage = productCatalogue.gotoOrderHistory();

		Assert.assertTrue(orderspage.verifyProductName(product));
		
	}
}
