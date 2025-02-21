package StepDefinations;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import TestComponents.BaseTest;
import ecommerce.pageobjects.CartPage;
import ecommerce.pageobjects.CheckOutPage;
import ecommerce.pageobjects.LogInPage;
import ecommerce.pageobjects.OrdersPage;
import ecommerce.pageobjects.ProductCatalogue;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class EcommerceStepDefination extends BaseTest{


	public LogInPage logInPage;
    public ProductCatalogue productCatalogue;
    public CartPage cartPage;
    public CheckOutPage checkOut;
    public OrdersPage ordersPage;


    @Given("the ecommerce application is Launch")
    public void launchEcommerceApplication() throws IOException {
        logInPage = launchApplication("https://rahulshettyacademy.com/client");
    }

    @Given("^the user logged in with (.+) and (.+)$")
    public void loginWithUserNameAndPassowrd(String username,String password){
       productCatalogue = logInPage.doLogIn(username, password);
    }
    @And("^the user add the (.+) into cart$")
    public void addProductToCart(String product){
        WebElement msg = productCatalogue.addProductToCart(product);
		Assert.assertTrue(msg.isDisplayed());
		cartPage = productCatalogue.goToCartPage();
    }

    @And("^the user checkout (.+) and submit Order$")
    public void checkoutAndSubmitOrder(String product){
        Assert.assertTrue(cartPage.verifyOrder(product).contains(product));
		checkOut = cartPage.goTOCheckOut();
		// Fill Details in CheckOut Page
		checkOut.fillDetails();
		checkOut.selectCountry();
		ordersPage = checkOut.placeOrder();
    }

    @Then("the user validates {string} message is displayed")
    public void the_user_validates_message_is_displayed(String string){
        // Verify orders
		String[] orderid = ordersPage.verifySuccessMessage();
		Assert.assertEquals(orderid[0], string);
		
		
    }
    
    @And("the user closes the driver")
    public void driver_close(){
        // Verify orders
		driver.close();
		
    }
}
