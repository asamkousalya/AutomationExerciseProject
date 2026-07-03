package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.BaseClass;

public class LoginSteps extends BaseClass {

    LoginPage login;

    @Then("Verify Login section visible")
    public void verify() {

        login = new LoginPage(driver);

    }

    @When("User enters valid email and password")
    public void validLogin() {

        login.login(
                "vaibhavmakne0601@gmail.com",
                "Vaibhav@100");
    }

    @When("User enters invalid email and password")
    public void invalidLogin() {

        login.login(
                "wrong@gmail.com",
                "Wrong123");
    }

    @When("User enters invalid email format and password")
    public void invalidEmailFormat() {

        login.login(
                "wrongemail",
                "Vaibhav@100");
    }

    @When("User leaves email and password empty")
    public void emptyFields() {

        login.login("", "");
    }

    @When("User clicks Login button")
    public void click() {

        login.clickLogin();
    }

    @Then("Verify logged in username")
    public void verify_logged_in_username() {

        Assert.assertTrue(login.verifyLoggedInUser());

    }

    @Then("Verify login error message")
    public void verifyLoginError() {

        Assert.assertTrue(login.verifyLoginError());

    }

    @Then("Verify email validation message")
    public void verifyEmailValidation() {

        Assert.assertTrue(login.verifyEmailValidation());

    }

    @Then("Verify required field validation")
    public void verifyRequiredFieldValidation() {

        Assert.assertTrue(login.verifyRequiredValidation());

    }

}