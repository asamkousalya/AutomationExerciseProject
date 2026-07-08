package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ContactPage;
import utilities.DriverFactory;

public class ContactSteps {

    WebDriver driver;
    ContactPage contactPage;

    @Given("User launches browser")
    public void launchBrowser() {

        driver = DriverFactory.getDriver();
        contactPage = new ContactPage(driver);
    }

    @When("User opens Automation Exercise website")
    public void openWebsite() {

        driver.get("https://automationexercise.com/");
    }

    @Then("Home page should be visible")
    public void verifyHomePage() {

        Assert.assertTrue(driver.getTitle().contains("Automation"));
    }

    @When("User clicks Contact Us button")
    public void clickContactUs() {

        contactPage.clickContactUs();
    }

    @Then("GET IN TOUCH should be visible")
    public void verifyGetInTouch() {

        Assert.assertTrue(contactPage.verifyGetInTouch());
    }

    @When("User enters contact details")
    public void enterDetails() {

        contactPage.enterDetails();
    }

    @When("User uploads file")
    public void uploadFile() {

        String path = System.getProperty("user.dir")
                + "\\TestData\\sample.txt";

        contactPage.uploadDocument(path);
    }

    @When("User clicks submit button")
    public void clickSubmit() {

        contactPage.clickSubmit();
    }

    @When("User accepts alert")
    public void acceptAlert() {

        driver.switchTo().alert().accept();
    }

    @Then("Success message should be displayed")
    public void verifySuccessMessage() {

        Assert.assertTrue(
                contactPage.getSuccessMessage()
                .contains("Success"));
    }

    @When("User clicks Home button")
    public void clickHomeButton() {

        contactPage.clickHome();
    }


    @Then("User should navigate to home page")
       public void verifyNavigation() {

       System.out.println("Current URL = "
                 + driver.getCurrentUrl());

         Assert.assertTrue(
               driver.getCurrentUrl()
                 .contains("automationexercise.com"));
}

}