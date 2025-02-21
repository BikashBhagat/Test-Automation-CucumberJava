import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebDriverAction1 {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		String projectPath = System.getProperty("user.dir");
		
		System.getProperty("webdriver.chrome.driver", projectPath +"/src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("Bikash");
		driver.findElement(By.name("inputPassword")).sendKeys("HelloBikash");
		driver.findElement(By.className("signInBtn")).click();
		String errormessage = driver.findElement(By.className("error")).getText();
		System.out.println(errormessage);
		driver.findElement(By.xpath("//a[text()='Forgot your password?']")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("reset-pwd-btn")).click();
		String infomessage = driver.findElement(By.className("infoMsg")).getText();
		String temppass = infomessage.split("'")[1];
		System.out.println(temppass);
		driver.findElement(By.className("go-to-login-btn")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("inputUsername")).sendKeys("Bikash");
		driver.findElement(By.name("inputPassword")).sendKeys(temppass);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(1000);
		String LoginPage = driver.findElement(By.cssSelector("div h2")).getText();
		Assert.assertEquals(LoginPage,"Hello Bikash,");
		System.out.println(LoginPage);
		String LoginPagepara = driver.findElement(By.tagName("p")).getText();
		Assert.assertEquals(LoginPagepara, "You are successfully logged in.");
		System.out.println(LoginPagepara);
		driver.quit();
	}

}
