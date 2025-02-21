package ecommerce.abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ecommerce.pageobjects.OrdersPage;

public class AbstractComponents {
	
	@FindBy(css="button[routerlink*='myorders']")
	WebElement orderButton;
	
	WebDriver driver;

	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitForElementVisible(WebElement Ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(Ele));
	}
	
	public void selectDropdownWithText(WebElement dropdown, String text) {
		Select drop = new Select(dropdown);
		drop.selectByVisibleText(text);
		
	}
	
	
	public OrdersPage gotoOrderHistory() {
		orderButton.click();
		OrdersPage ordersPage = new OrdersPage(driver);
		return ordersPage;
		}
	
	
}
