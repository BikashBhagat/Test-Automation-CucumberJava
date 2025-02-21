import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WebNavigation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String projectPath = System.getProperty("user.dir");
		System.getProperty("webdriver.chrome.driver", projectPath +"/src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		open in maximize mode
		driver.manage().window().maximize();
//		driver.get("https://google.com/"); // Comes with wait by default to wait till the page is fully loaded
//		
//		driver.navigate().to("https://rahulshettyacademy.com");// It does not come with wait by default 
//		driver.navigate().back();
//		driver.navigate().forward();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
//		Static Dropdown
		WebElement currency = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select currencyDropdown = new Select(currency);
		currencyDropdown.selectByIndex(3);
		System.out.println(currencyDropdown.getFirstSelectedOption().getText());
		currencyDropdown.selectByValue("AED");
		System.out.println(currencyDropdown.getFirstSelectedOption().getText());
		currencyDropdown.selectByVisibleText("INR");
		System.out.println(currencyDropdown.getFirstSelectedOption().getText());
		
		
	}

}
