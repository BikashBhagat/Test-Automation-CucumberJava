import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender {
public static void main(String[] args) throws InterruptedException {

		String projectPath = System.getProperty("user.dir");
		System.getProperty("webdriver.chrome.driver", projectPath +"/src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        // Give implicit wait for 3 seconds 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        WebElement Date = driver.findElement(By.xpath("//button[contains(@class,'react-date-picker__calendar-button')]"));
        selectPastDate(driver, Date);
        System.out.println(driver.findElement(By.cssSelector("div.react-date-picker__inputGroup input")).getAttribute("value"));
        selectFutureDate(driver, Date);
        System.out.println(driver.findElement(By.cssSelector("div.react-date-picker__inputGroup input")).getAttribute("value"));
        selectCustomDate(driver, Date, "2025/10/4");
        System.out.println(driver.findElement(By.cssSelector("div.react-date-picker__inputGroup input")).getAttribute("value"));

}

public static void selectPastDate(WebDriver driver, WebElement Date) {
    Date.click();
    WebElement pastDate = driver.findElement(By.xpath("//button[contains(@class,'react-calendar__tile--now')]//preceding-sibling::button[3]"));
    pastDate.click();    
}
public static void selectFutureDate(WebDriver driver, WebElement Date) {
    Date.click();
    WebElement futureDate = driver.findElement(By.xpath("//button[contains(@class,'react-calendar__tile--now')]//following-sibling::button[3]"));
    futureDate.click();    
}
public static void selectCustomDate(WebDriver driver, WebElement Date, String customDate) {
    String[] dateToBeEntered = customDate.split("/");
    Date.click();
    driver.findElement(By.cssSelector("span.react-calendar__navigation__label__labelText")).click();
    driver.findElement(By.cssSelector("span.react-calendar__navigation__label__labelText")).click();
    driver.findElement(By.xpath("//button[text()='"+dateToBeEntered[0]+"']")).click();
    driver.findElement(By.xpath("(//button[contains(@class,'calendar__year-view__months__month')])["+dateToBeEntered[1]+"]")).click();
    driver.findElement(By.xpath("//button[contains(@class,'react-calendar__month-view__days__day')]/abbr[text()='"+dateToBeEntered[2]+"']")).click();       
}
}
