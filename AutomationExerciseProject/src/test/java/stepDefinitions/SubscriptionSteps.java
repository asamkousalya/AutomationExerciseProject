package stepDefinitions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.SubscriptionPage;
import utilities.DriverFactory;

public class SubscriptionSteps {

    WebDriver driver;
    SubscriptionPage subscriptionPage;
    

    public void initialize() {

         driver = DriverFactory.getDriver();

         if(subscriptionPage == null) {
            subscriptionPage = new SubscriptionPage(driver);
         }
    }


    @When("User scrolls to footer")
    public void scrollToFooter() {
    	
    	initialize();

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "window.scrollTo(0,document.body.scrollHeight)");
    }

    @Then("Subscription text should be displayed")
    public void verifySubscriptionText() {
    	
    	initialize();

        Assert.assertTrue(
                subscriptionPage.verifySubscriptionText());
    }

    @When("User enters email for subscription")
    public void emailEnter() {
    	
    	initialize();

        subscriptionPage.enterEmail();
    }

    @When("User clicks subscription button")
    public void clickSubscribe() {
    	
    	initialize();

        subscriptionPage.clickSubscribeButton();
    }

    @Then("Subscription success message should appear")
    public void verifySuccessMessage() {
    	
    	initialize();

        Assert.assertTrue(
                subscriptionPage.getSuccessMessage()
                .contains("successfully subscribed"));
    }

    @When("User clicks Cart button")
    public void clickCart() {
    	
    	initialize();

        subscriptionPage.clickCart();
    }
}