package ecommerce.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import ecommerce.abstractcomponents.AbstractComponents;

public class OrdersPage extends AbstractComponents{

	WebDriver driver;
	
	public  OrdersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	

	By viewButton = By.cssSelector("td button.btn.btn-primary");
	By deleteButton = By.cssSelector("td button.btn.btn-danger");
	
	@FindBy(css="h1.hero-primary")
	WebElement successMsg;
	@FindBy(css="label.ng-star-inserted")
	WebElement orderMsg;
	@FindBy(css="button[routerlink*='myorder']")
	WebElement myOrderButton;
	@FindBy(css="table.table tbody tr")
	List<WebElement> orderRow;
	@FindBy(css="div.email-title")
	WebElement summaryHeaders;
	@FindBy(css="div.title")
	WebElement productName;
	@FindBy(css="div[routerlink*='myorder']")
	WebElement myOrder;
	@FindBy(css="table.table tbody tr")
	List<WebElement> orderRow1;
	@FindBy(css="table.table tbody td:nth-child(3)")
	List<WebElement> productNames;
	
	@FindBy(xpath = "//*[text()=' Orders Deleted Successfully ']")
	WebElement deletedMsg;
	
	public void close() {
		driver.close();
	}
	
	public String[] verifySuccessMessage() {
		 System.out.println(successMsg.getText());
	        String orderid = orderMsg.getText().split(" ")[1];
	        String msg = successMsg.getText();
	        String [] ls = {msg,orderid};
	        return ls;
	}
	
	public void verifyOrderIdInMyorders(String orderid) {
		myOrderButton.click();
	        for (int i =0; i<orderRow.size();i++){
	            if (orderRow.get(i).findElement(By.tagName("th")).getText().trim().equals(orderid)){
	                orderRow.get(i).findElement(viewButton).click();
	                break;
	            }
	        }
	}
	
	public String [] orederedProductName(String product) {
		System.out.println(summaryHeaders.getText());
		String orderHeader = summaryHeaders.getText();
		String prod = productName.getText().trim();
        Actions a = new Actions(driver);
        a.moveToElement(myOrder).click().build().perform();
        String [] ls = {orderHeader,prod};
        return ls;
	}
	
	public void deleteProductFromHistory(String orderid) {
	        for (int i =0; i<orderRow1.size();i++){
	            System.out.println(orderRow1.get(i).getText());
	            if (orderRow1.get(i).findElement(By.tagName("th")).getText().trim().equals(orderid)){
	                orderRow1.get(i).findElement(deleteButton).click();
	                Assert.assertTrue(deletedMsg.isDisplayed());
	                break;
	            }
	        }

	}
	
	
	public boolean verifyProductName(String product) {
		 boolean match = productNames.stream().anyMatch(s->s.getText().trim().equalsIgnoreCase(product));
		return match;
		
	}
	
	
}
