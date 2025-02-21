package ecommerce.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import ecommerce.abstractcomponents.AbstractComponents;

public class CartPage extends AbstractComponents {

	WebDriver driver;
	
	public  CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="div.cartSection h3")
	WebElement OrderItem;
	
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkOut;
	
	public String verifyOrder(String product) {
		System.out.println(OrderItem.getText());
		return OrderItem.getText();
        
	}
	
	public CheckOutPage goTOCheckOut() {
		checkOut.click();
		CheckOutPage checkOut = new CheckOutPage(driver);
		return checkOut;
	}

}
