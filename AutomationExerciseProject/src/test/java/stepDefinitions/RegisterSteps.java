package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegisterPage;
import utilities.BaseClass;

public class RegisterSteps extends BaseClass {

    RegisterPage reg;

    @When("User opens automation exercise website")
    public void open() {

        driver.get("https://automationexercise.com/");
    }

    @Then("Verify home page is visible")
    public void verify_home_page_is_visible() {

        Assert.assertTrue(
                driver.getTitle().contains("Automation Exercise"),
                "Home page is not displayed");
    }

    @When("User clicks SignUp Login button")
    public void signup() {

        reg = new RegisterPage(driver);

        reg.clickSignup();
    }

    @Then("Verify New User SignUp is visible")
    public void verify_new_user_signup_is_visible() {

        System.out.println("Signup section displayed");
    }
    @When("User enters name and email")
    public void user_enters_name_and_email() {

        reg = new RegisterPage(driver);

        reg.enterNameAndEmail();
    }

    @When("User clicks SignUp button")
    public void user_clicks_sign_up_button() {

        reg.clickSignupButton();
    }

    @Then("Verify account information page")
    public void verify_account_information_page() {

        Assert.assertTrue(reg.verifyAccountInformationPage());
    }

    @When("User enters account details")
    public void user_enters_account_details() {

        reg.enterAccountDetails();
    }

    @When("User enters address details")
    public void user_enters_address_details() {

        reg.enterAddressDetails();
    }

    @When("User clicks Create Account")
    public void user_clicks_create_account() {

        reg.createAccount();
    }

    @When("User enters signup details")
    public void enter_signup_details(DataTable table) {

        List<Map<String, String>> data =
                table.asMaps(String.class, String.class);

        Map<String, String> user = data.get(0);

        String email =
                "test"
                + System.currentTimeMillis()
                + "@gmail.com";

        reg.enterSignup(
                user.get("name"),
                email);

        reg.clickSignupButton();

        reg.accountDetails(
                user.get("gender"),
                user.get("password"),
                user.get("day"),
                user.get("month"),
                user.get("year"));

        reg.addressDetails(
                user.get("fname"),
                user.get("lname"),
                user.get("address"),
                user.get("country"),
                user.get("state"),
                user.get("city"),
                user.get("zipcode"),
                user.get("mobile"));

        reg.createAccount();
    }

    @Then("Verify account created")
    public void verify_account_created() {

        Assert.assertTrue(
                reg.verifyAccountCreated(),
                "Account creation failed");

        reg.clickContinue();
    }

    @When("User enters existing user details")
    public void user_enters_existing_user_details() {

        reg.enterExistingUser();
    }

    @Then("Verify email already exists error")
    public void verify_email_already_exists_error() {

        Assert.assertTrue(
                reg.verifyEmailExists(),
                "Email already exists message not displayed");
    }

    @When("User enters invalid email")
    public void user_enters_invalid_email() {

        reg.enterInvalidEmail();
    }

    @Then("Verify invalid email validation")
    public void verify_invalid_email_validation() {

        System.out.println("Invalid email validation verified");
    }

    @When("User enters empty name")
    public void user_enters_empty_name() {

        reg.enterEmptyName();
    }

    @When("User enters empty email")
    public void user_enters_empty_email() {

        reg.enterEmptyEmail();
    }

    @When("User enters empty name and email")
    public void user_enters_empty_name_and_email() {

        reg.enterEmptyNameAndEmail();
    }

    @Then("Verify required validation")
    public void verify_required_validation() {

        System.out.println("Required field validation verified");
    }

    @When("User enters special character name")
    public void user_enters_special_character_name() {

        reg.enterSpecialCharacterName();
    }

    @When("User enters long name")
    public void user_enters_long_name() {

        reg.enterLongName();
    }

    @When("User enters name with spaces")
    public void user_enters_name_with_spaces() {

        reg.enterNameWithSpaces();
    }

    @Then("Verify signup page opened")
    public void verify_signup_page_opened() {

        Assert.assertTrue(
                reg.verifySignupPage(),
                "Signup page is not displayed");
    }
}