import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Exercise1 {
public static void main(String[] args){
    // TODO Auto-generated method stub
		String projectPath = System.getProperty("user.dir");
		System.getProperty("webdriver.chrome.driver", projectPath +"/src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		open in maximize mode
		driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//Deal with Alert
        driver.findElement(By.cssSelector("input[placeholder='Enter Your Name']")).sendKeys("Bikash");
        driver.findElement(By.id("alertbtn")).click();
//        Simple Alert
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        Assert.assertEquals(alert.getText(), "Hello Bikash, share this practice page and share your knowledge");
        alert.dismiss();
//        confirmation prompt alert
        driver.findElement(By.cssSelector("input[placeholder='Enter Your Name']")).sendKeys("Bikash");
        driver.findElement(By.id("confirmbtn")).click();
        Alert alert1 = driver.switchTo().alert();
        System.out.println(alert1.getText());
        Assert.assertEquals( alert1.getText(),"Hello Bikash, Are you sure you want to confirm?");
        alert.accept();
}
}
