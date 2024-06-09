package StepDefinations;

import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;


public class GoogleSearch {
	WebDriver driver=null;
	
	@SuppressWarnings("deprecation")
	@Given("new chrom drive window is opened")
	public void new_chrom_drive_window_is_opened() {
		String projectPath = System.getProperty("user.dir");
		
		System.getProperty("webdriver.chrome.driver", projectPath +"/src/test/resources/drivers/chrome.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@And("user present in google serch page")
	public void user_present_in_google_serch_page() {
		driver.navigate().to("https://www.google.com/");

	}

	@When("user enters keyword to search")
	public void user_enters_keyword_to_search() {
		driver.findElement(By.id("APjFqb")).sendKeys("Gateway of India");
		
	}

	@And("user hit enter")
	public void user_hit_enter() {
		driver.findElement(By.id("APjFqb")).sendKeys(Keys.ENTER);
	}

	@Then("user validate search result page is opened")
	public void user_validate_search_result_page_is_opened() {
		driver.getPageSource().contains("Gateway of India - Wikipedia");
		driver.close();
		driver.quit();
	}

}
