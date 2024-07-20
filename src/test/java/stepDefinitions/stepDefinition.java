package stepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class stepDefinition {
	
	@Given("^User is on Snapfish landing page$")
	public void User_is_on_Snapfish_landing_page() {
		System.out.println("User is on Snapfish landing page");
	}
	@When("User login into application with {string} and password {string}")
	public void user_login_into_application_with_and_password(String arg1, String arg2) {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println(arg1);
	   System.out.println(arg2);
	}
	@Then("^Home page is displayed$")
	public void Home_page_is_displayed() {
		System.out.println("Home page is displayed");
	}
	@And("Photos are displayed {string}")
	public void photos_are_displayed(String arg3) {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println(arg3);
	}

	
}
