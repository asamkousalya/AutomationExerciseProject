package stepDefinitions;
 
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.BaseClass;

public class LoginSteps extends BaseClass{
	LoginPage login;
 
	@Then("Verify Login section visible")
	public void verify(){
 
		}
 
	@When("User enters email and password")
	public void enter(){
 
	login=new LoginPage(driver);
 
	login.login(
			"vaibhavmakne0601@gmail.com",
			"Vaibhav@100"
			);
 
	}
 
@When("User clicks Login button")
public void click(){
login.clickLogin();
}
@Then("Verify logged in username")
public void verify_logged_in_username() {

    Assert.assertTrue(login.verifyLoggedInUser());

}
 
}
 