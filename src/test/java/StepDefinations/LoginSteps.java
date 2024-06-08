package StepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	@Given("url launch in new window")
	public void url_launch_in_new_window() {
	    System.out.println("user logged in page open");
	}

	@And("user maximize the window")
	public void user_maximize_the_window() {
		System.out.println("Window maimize");
	    
	}

	@When("use enter user name in username textbox")
	public void use_enter_user_name_in_username_textbox() {
		System.out.println("user enter log in and pwd");
	   
	}

	@And("use enter password in password textbox")
	public void use_enter_password_in_password_textbox() {
		System.out.println("user enter pwd");
	    
	}

	@Then("user validated in user log in successfull")
	public void user_validated_in_user_log_in_successfull() {
		System.out.println("user logged in successfully");
	    
	}

}
