package ecommerce.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecommerce.abstractcomponents.AbstractComponents;

public class LogInPage extends AbstractComponents {
	
	WebDriver driver;
	
	public  LogInPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#userEmail")
	WebElement username;
	
	@FindBy(css="#userPassword")
	WebElement password;
	
	@FindBy(css="#login")
	WebElement loginBtn;

	@FindBy(css=".toast-message.ng-star-inserted")
	WebElement errorMsg;
	
	public ProductCatalogue doLogIn(String name, String pass) {
		username.sendKeys(name);
		password.sendKeys(pass);
		loginBtn.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}

	public String getErrorMsg(){
		return errorMsg.getText().trim();
	}
	
	public String getTitle() {
		return driver.getTitle();
		
	}

}
