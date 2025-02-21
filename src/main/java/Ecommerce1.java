import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Ecommerce1 {
    public static void main(String[] args) throws InterruptedException {

		String projectPath = System.getProperty("user.dir");
		System.getProperty("webdriver.chrome.driver", projectPath +"/src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        // Give implicit wait for 3 seconds 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//		open in maximize mode
        String[] item = {"Cucumber","Carrot","Pumpkin"};
		driver.manage().window().maximize();
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
        List itemList = Arrays.asList(item);
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        int j =0;
        for (int i = 0; i<products.size();i++){
            String itemName = products.get(i).getText().split("-")[0].trim();
            if(itemList.contains(itemName)){
                driver.findElements(By.cssSelector("div.product-action button")).get(i).click();
                j++;
            }
            if(j==item.length){
                break;
            }
        }
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();


        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        /* Give Explicite wait to deal with this situation, 2 ways webdriverwait and fluent wait */ 
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());


        driver.findElement(By.xpath("//button[text()='Place Order']")).click();
        WebElement country = driver.findElement(By.tagName("select"));
        Select countryDropdown = new Select(country);
        countryDropdown.selectByValue("India");
        driver.findElement(By.cssSelector("input.chkAgree")).click();
        driver.findElement(By.xpath("//button[text()='Proceed']")).click();
        System.out.println(driver.findElement(By.tagName("span")).getText());
        }
}
