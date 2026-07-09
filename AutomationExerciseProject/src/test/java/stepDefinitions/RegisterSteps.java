package stepDefinitions;

import org.testng.Assert;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegisterPage;
import utilities.BaseClass;

public class RegisterSteps extends BaseClass {
RegisterPage reg;


@When("User opens automation exercise website")
public void open() {
}
@Then("Verify home page is visible")
public void verify_home() {
}
@When("User clicks SignUp Login button")
public void signup() {
reg = new RegisterPage(driver);
reg.clickSignup();
}
@Then("Verify New User SignUp is visible")
public void verify_signup() {
}
@When("User enters name and email")
public void details() {
    reg = new RegisterPage(driver);
    reg.enterSignup(
        "TestUser",
        "test" + System.currentTimeMillis() + "@gmail.com"
    );
}
@When("User clicks SignUp button")
public void signupBtn() {
reg.clickSignupButton();
}
@Then("Verify account information page")
public void accountPage() {
}
@When("User enters account details")
public void account() {
reg.accountDetails();
}
@When("User enters address details")
public void address() {
reg.addressDetails();
}
@When("User clicks Create Account")
public void create() throws InterruptedException {
reg.createAccount();
}
@Then("Verify account created")
public void created() {
	  Assert.assertTrue(reg.created());

	    reg.clickContinue();

}

}