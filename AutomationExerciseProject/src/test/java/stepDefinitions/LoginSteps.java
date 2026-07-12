package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.BaseClass;

public class LoginSteps extends BaseClass {

    LoginPage login;

    @Then("Verify Login section visible")
    public void verifyLoginSectionVisible() {

        login = new LoginPage(driver);

        Assert.assertTrue(login.verifyLoginSectionVisible(),
                "Login section is not visible");
    }

    @When("User enters {string} and {string}")
    public void user_enters_and(String email, String password) {

        login.enterCredentials(email, password);
    }

    @When("User clicks Login button")
    public void user_clicks_login_button() {

        login.clickLogin();
    }
    @When("User enters valid email and password")
    public void user_enters_valid_email_and_password() {

        if(login == null)
            login = new LoginPage(driver);

        login.enterCredentials(
                "vaibhavmakne0601@gmail.com",
                "Vaibhav@100");
    }

    @Then("Verify logged in username")
    public void verify_logged_in_username() {

        if(login == null)
            login = new LoginPage(driver);

        Assert.assertTrue(login.verifyLoggedInUser());
    }
    @When("User clicks Logout button")
    public void user_clicks_logout_button() {
    	if(login==null) {
    		login=new LoginPage(driver);
    	}
        login.clickLogout();
    }

    @Then("Verify Login page displayed")
    public void verify_login_page_displayed() {
    	if(login==null) {
    		login=new LoginPage(driver);
    	}
        Assert.assertTrue(login.verifyLoginSectionVisible(),
                "Login page is not displayed");
    }

    @Then("Verify {string}")
    public void verify_result(String result) {

        switch (result.toLowerCase()) {

        case "success":

            Assert.assertTrue(
                    login.verifyLoggedInUser(),
                    "Login Failed");

            break;

        case "error":

            Assert.assertTrue(
                    login.verifyLoginError(),
                    "Error Message Not Displayed");

            break;

        case "emailvalidation":

            Assert.assertTrue(
                    login.verifyEmailValidation(),
                    "Email Validation Failed");

            break;

        case "required":

            Assert.assertTrue(
                    login.verifyRequiredValidation(),
                    "Required Validation Failed");

            break;

        default:

            Assert.fail("Invalid Result Type : " + result);
        }
    }
}