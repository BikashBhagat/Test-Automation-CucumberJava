package E2ETests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import ecommerce.pageobjects.LogInPage;
import ecommerce.pageobjects.ProductCatalogue;

public class LogInValidation extends BaseTest {
	

	@Test(dataProvider = "getData")
	public void loginSuccessfullValidation(HashMap<String, String> input) throws IOException {

		LogInPage logInPage = launchApplication("https://rahulshettyacademy.com/client");
		// launch URL and do log in
		ProductCatalogue productCatalogue = logInPage.doLogIn(input.get("username"), input.get("password"));
		String Title = logInPage.getTitle();
		Assert.assertEquals(Title, "Let's Shop");
	}

	@Test(groups = { "ErrorValidation" })
	public void loginErrorValidation() throws IOException {
		String username = "smasherrock33@gmail.com";
		String password = "Smasher@";
		String product = "ADIDAS ORIGINAL";
		LogInPage logInPage = launchApplication("https://rahulshettyacademy.com/client");
		// launch URL and do log in
		ProductCatalogue productCatalogue = logInPage.doLogIn(username, password);
		String errorMsg = logInPage.getErrorMsg();
		Assert.assertEquals(errorMsg, " email or password.");
	}

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonData(
				System.getProperty("user.dir") + "\\src\\test\\java\\Data\\LogInValidation.json.txt");
		return new Object[][] { { data.get(0) }, { data.get(1) } };

//        	HashMap<String, String> map = new HashMap<String, String>();
//        	map.put("username", "smasherrock33@gmail.com");
//        	map.put("password", "Smasher@123");
//        	map.put("product", "ADIDAS ORIGINAL");
//        	
//        	HashMap<String, String> map1 = new HashMap<String, String>();
//        	map1.put("username", "paper@gmail.com");
//        	map1.put("password", "paper@123");
//        	map1.put("product", "ADIDAS ORIGINAL");
	}

}
