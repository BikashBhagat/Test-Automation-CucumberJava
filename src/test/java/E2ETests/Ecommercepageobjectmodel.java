package E2ETests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import ecommerce.pageobjects.CartPage;
import ecommerce.pageobjects.CheckOutPage;
import ecommerce.pageobjects.LogInPage;
import ecommerce.pageobjects.OrdersPage;
import ecommerce.pageobjects.ProductCatalogue;

public class Ecommercepageobjectmodel extends BaseTest {


	@Test
	public void ecommerceTestE2E() throws InterruptedException, IOException {
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
		CartPage cartPage = productCatalogue.goToCartPage();
		// VerifyOrder Details
		Assert.assertTrue(cartPage.verifyOrder(product).contains(product));
		CheckOutPage checkOut = cartPage.goTOCheckOut();
		// Fill Details in CheckOut Page
		checkOut.fillDetails();
		checkOut.selectCountry();
		OrdersPage ordersPage = checkOut.placeOrder();
		// Verify orders
		String[] orderid = ordersPage.verifySuccessMessage();
		Assert.assertEquals(orderid[0], "THANKYOU FOR THE ORDER.");
		// verify the order id
		ordersPage.verifyOrderIdInMyorders(orderid[1]);
		// verify ordered product
		String confirmation[] = ordersPage.orederedProductName(product);
		Assert.assertTrue(confirmation[0].equalsIgnoreCase("order summary"));
		Assert.assertTrue(confirmation[1].contains(product));
		// Delete Order
		ordersPage.deleteProductFromHistory(orderid[1]);

	}
}
