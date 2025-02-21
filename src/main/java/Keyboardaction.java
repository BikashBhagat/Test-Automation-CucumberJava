import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Keyboardaction {
public static void main(String[] args){
    
		String projectPath = System.getProperty("user.dir");
		System.getProperty("webdriver.chrome.driver", projectPath +"/src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		open in maximize mode
		
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        Actions a = new Actions(driver);
        a.scrollToElement(driver.findElement(By.xpath("//legend[text()='iFrame Example']"))).build().perform();
        a.moveToElement(driver.findElement(By.id("mousehover"))).build().perform();
        driver.findElement(By.cssSelector("a[href='#top']")).click();
        // iframes 
        driver.switchTo().frame("courses-iframe");
        driver.findElement(By.cssSelector("a[class='header-top-link']")).click();

        // Windows
        Set<String> windows = driver.getWindowHandles(); //[parentid,childid,subchildId]

        Iterator <String>it = windows.iterator();

        String parentId = it.next();

        String childId = it.next();

        driver.switchTo().window(childId);
        System.out.println(driver.findElement(By.cssSelector("p.hero_heading")).getText()); 
        driver.close();
        driver.switchTo().window(parentId);
        driver.findElement(By.id("openwindow")).click();
        String currentWindow = driver.getWindowHandle();  //will keep current window to switch back
        for(String winHandle : driver.getWindowHandles()){
            if (driver.switchTo().window(winHandle).getTitle().contains("QAClick")) {
            //This is the one you're looking for
            break;
            } 
            else {
            driver.switchTo().window(currentWindow);
            } 
        }
        // driver.getTitle();
        System.out.println(driver.getTitle());
}
}


