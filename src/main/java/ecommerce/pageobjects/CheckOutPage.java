package ecommerce.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import ecommerce.abstractcomponents.AbstractComponents;

public class CheckOutPage extends AbstractComponents {

	WebDriver driver;
	
	public  CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="p.mt-1.ng-star-inserted")
	WebElement couponAppliedMsg;
	
	@FindBy(xpath="//button[text()='Apply Coupon']")
	WebElement applyButton;
	
	@FindBy(xpath="//div[text()='Apply Coupon ']/following-sibling::input")
	WebElement couponTextBox;
	
	@FindBy(xpath="//div[text()='Name on Card ']/following-sibling::input")
	WebElement nameOnCardTextBox;
	
	@FindBy(xpath="//div[text()='CVV Code ']/following-sibling::input")
	WebElement cvvTextBox;
	
	@FindBy(xpath="//div[text()='Expiry Date ']/following-sibling::select[2]")
	WebElement expYear;
	
	@FindBy(xpath="//div[text()='Expiry Date ']/following-sibling::select[1]")
	WebElement expMonth;
	
	@FindBy(xpath="//div[text()='Credit Card Number ']/following-sibling::input")
	WebElement cardNumberTextBox;
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement countryText;
	
	@FindBy(css="span.ng-star-inserted")
	List<WebElement> appearedCountry;
	
	@FindBy(css="a.btnn.action__submit.ng-star-inserted")
	WebElement placeOrderButton;
	
	public void fillDetails() {
			cardNumberTextBox.clear();
			cardNumberTextBox.sendKeys("4321567898764567");
			selectDropdownWithText(expMonth, "08");
			selectDropdownWithText(expYear, "28");
	        cvvTextBox.sendKeys("123");
	        nameOnCardTextBox.sendKeys("Rock");
	        couponTextBox.sendKeys("rahulshettyacademy");
	        applyButton.click();
	        System.out.println(couponAppliedMsg.getText());
	        Assert.assertTrue(couponAppliedMsg.getText().contains("* Coupon Applied"));
	}
	
	public void selectCountry() {
		countryText.sendKeys("ind");
        for (int i =0;i<appearedCountry.size();i++){
            if(appearedCountry.get(i).getText().trim().equals("India")){
                appearedCountry.get(i).click();
                break;
            }
        }
	}
	
	public OrdersPage placeOrder() {
		placeOrderButton.click();
		OrdersPage ordersPage = new OrdersPage(driver);
		return ordersPage;
	}
	
}
