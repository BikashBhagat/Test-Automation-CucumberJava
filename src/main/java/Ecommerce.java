import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ecommerce {
    @Test
    public static void Demo() throws InterruptedException{
       String projectPath = System.getProperty("user.dir");
		System.getProperty("webdriver.chrome.driver", projectPath +"/src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		open in maximize mode
        String username ="smasherrock33@gmail.com";
        String password ="Smasher@123";
		driver.manage().window().maximize(); 
        driver.get("https://rahulshettyacademy.com/client");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // Log in to client app
        driver.findElement(By.cssSelector("#userEmail")).sendKeys(username);
        driver.findElement(By.cssSelector("#userPassword")).sendKeys(password);
        driver.findElement(By.cssSelector("#login")).click();
        Assert.assertEquals(driver.getTitle(), "Let's Shop");
        // Select products
        String[] productArray = {"ADIDAS ORIGINAL","IPHONE 13 PRO"};
        String product = "ADIDAS ORIGINAL";
        List<WebElement> productElement = driver.findElements(By.cssSelector("div.card-body"));
        for (int i =0; i<productElement.size();i++){
            if(productElement.get(i).findElement(By.tagName("h5")).getText().contains("ADIDAS ORIGINAL")){
                System.out.println("Match Found");
                productElement.get(i).findElement(By.cssSelector("button i.fa.fa-shopping-cart")).click();
                Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Product Added To Cart ']")).isDisplayed());
                break;
            }
        }


        driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
        System.out.println(driver.findElement(By.cssSelector("div.cartSection h3")).getText());
        Assert.assertTrue(driver.findElement(By.cssSelector("div.cartSection h3")).getText().contains(product));
        driver.findElement(By.xpath("//button[text()='Checkout']")).click();

        driver.findElement(By.xpath("//div[text()='Credit Card Number ']/following-sibling::input")).clear();
        driver.findElement(By.xpath("//div[text()='Credit Card Number ']/following-sibling::input")).sendKeys("4321567898764567");
        Select expMonth = new Select(driver.findElement(By.xpath("//div[text()='Expiry Date ']/following-sibling::select[1]")));
        Select expYear = new Select(driver.findElement(By.xpath("//div[text()='Expiry Date ']/following-sibling::select[2]")));
        
        expMonth.selectByVisibleText("08");
        expYear.selectByVisibleText("28");
        driver.findElement(By.xpath("//div[text()='CVV Code ']/following-sibling::input")).sendKeys("123");
        driver.findElement(By.xpath("//div[text()='Name on Card ']/following-sibling::input")).sendKeys("Rock");
        driver.findElement(By.xpath("//div[text()='Apply Coupon ']/following-sibling::input")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//button[text()='Apply Coupon']")).click();
        System.out.println(driver.findElement(By.cssSelector("p.mt-1.ng-star-inserted")).getText());
        Assert.assertTrue(driver.findElement(By.cssSelector("p.mt-1.ng-star-inserted")).getText().contains("* Coupon Applied"));

        driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("ind");

        List<WebElement> appearedCountry = driver.findElements(By.cssSelector("span.ng-star-inserted"));

        // appearedCountry.stream().forEach(c->{if(c.getText().trim().contains("India")){c.click();}});
        for (int i =0;i<appearedCountry.size();i++){
            if(appearedCountry.get(i).getText().trim().equals("India")){
                appearedCountry.get(i).click();
                break;
            }
        }
        driver.findElement(By.cssSelector("a.btnn.action__submit.ng-star-inserted")).click();
        System.out.println(driver.findElement(By.cssSelector("h1.hero-primary")).getText());
        Assert.assertEquals(driver.findElement(By.cssSelector("h1.hero-primary")).getText(), "THANKYOU FOR THE ORDER.");
        String orderid = driver.findElement(By.cssSelector("label.ng-star-inserted")).getText().split(" ")[1];
        // verify the order id 
        driver.findElement(By.cssSelector("button[routerlink*='myorder']")).click();
        List<WebElement> orderRow = driver.findElements(By.cssSelector("table.table tbody tr"));
        for (int i =0; i<orderRow.size();i++){
            if (orderRow.get(i).findElement(By.tagName("th")).getText().trim().equals(orderid)){
                orderRow.get(i).findElement(By.cssSelector("td button.btn.btn-primary")).click();
                break;
            }
        }
        
        System.out.println(driver.findElement(By.cssSelector("div.email-title")).getText());
        Assert.assertTrue(driver.findElement(By.cssSelector("div.email-title")).getText().equalsIgnoreCase("order summary"));
        Assert.assertTrue(driver.findElement(By.cssSelector("div.title")).getText().trim().contains(product));
        
        
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.cssSelector("div[routerlink*='myorder']"))).click().build().perform();
        // driver.findElement(By.cssSelector("div[routerlink*='myorder']")).click();
        List<WebElement> orderRow1 = driver.findElements(By.cssSelector("table.table tbody tr"));
        for (int i =0; i<orderRow1.size();i++){
            System.out.println(orderRow1.get(i).getText());
            if (orderRow1.get(i).findElement(By.tagName("th")).getText().trim().equals(orderid)){
                orderRow1.get(i).findElement(By.cssSelector("td button.btn.btn-danger")).click();
                Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Orders Deleted Successfully ']")).isDisplayed());
                break;
            }
        }

    
}
}
