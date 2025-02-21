import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Exercise2 {
public static void main(String[] args){
    // TODO Auto-generated method stub
		String projectPath = System.getProperty("user.dir");
		System.getProperty("webdriver.chrome.driver", projectPath +"/src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		open in maximize mode
		driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        System.out.println(driver.findElements(By.cssSelector("input[name*='checkBox']")).size());
        System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
        Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
        driver.findElement(By.id("checkBoxOption1")).click();
        System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
        Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
}
}
