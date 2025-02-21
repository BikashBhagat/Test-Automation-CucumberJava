package ecommerce.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import ecommerce.abstractcomponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {
WebDriver driver;
	
	public  ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	List<WebElement> productElementList = driver.findElements(By.cssSelector("div.card-body"));
	
	@FindBy(css="div.card-body")
	List<WebElement> productElementList;
	
	By addCartLocator = By.cssSelector("button i.fa.fa-shopping-cart");
	
	@FindBy(xpath="//*[text()=' Product Added To Cart ']")
	WebElement successMsg;
	
	@FindBy(css="button[routerlink*='cart']")
	WebElement cartButton;
	
	public WebElement getProductElement(String product) {
		 WebElement productElement = productElementList.stream().filter(item->item.findElement(By.tagName("h5")).getText().equals(product)).findFirst().orElse(null);
		 return productElement;
	}
	
	public WebElement addProductToCart(String product) {
		getProductElement(product).findElement(addCartLocator).click();
		waitForElementVisible(successMsg);
		return successMsg;
		
	}
	public CartPage goToCartPage() {
		cartButton.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}

	
}
