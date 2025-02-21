package TestComponents;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ecommerce.pageobjects.LogInPage;
import hooks.Hooks;

public class BaseTest{


	public WebDriver driver;

	
	
	public WebDriver initializeDriver() throws IOException {
		String projectPath = System.getProperty("user.dir");
		
		
		FileInputStream fis = new FileInputStream(projectPath +"/src/main/resources/GlobalData.properties");
		
		Properties prop = new Properties();
		prop.load(fis);
		
		String browserName  = prop.getProperty("browser");
		
		
		
		if (browserName.equalsIgnoreCase("chrome")) {
			System.getProperty("webdriver.chrome.driver", projectPath +"/src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			//open in maximize mode
			
		}
		else if (browserName.equalsIgnoreCase("msedge")) {
			System.getProperty("webdriver.edge.driver", projectPath +"/src/test/resources/drivers/chromedriver.exe");
			 driver = new EdgeDriver();
			//open in maximize mode
			
		}
		
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));	
		
		return driver;
	}
	
//	@BeforeMethod
	public LogInPage launchApplication(String url) throws IOException {
		WebDriver driver = initializeDriver();
		driver.get(url);
		LogInPage logInPage = new LogInPage(driver);
		return logInPage;
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeDriver() {
		driver.close(); 
	}
	
	public List<HashMap<String, String>> getJsonData(String filePath) throws IOException{
		
		String jsonData = FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
		
//		String to hashmap by jackson binder
		ObjectMapper mapper = new ObjectMapper();
		
		List<HashMap<String, String>> data = mapper.readValue(jsonData, new TypeReference<List<HashMap<String, String>>>(){
			
		});
		
		return data;
		
		
		
	}
	
	 public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
     	
     	File source = ts.getScreenshotAs(OutputType.FILE);
     	FileUtils.copyFile(source, new File(System.getProperty("user.dir")+"//screenshot//"+testCaseName+".png"));
     	return System.getProperty("user.dir")+"//screenshot//"+testCaseName+".png";
     }
	 
}
	
