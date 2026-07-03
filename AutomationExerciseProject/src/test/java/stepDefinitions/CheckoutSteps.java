package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutPage;
import utilities.BaseClass;

public class CheckoutSteps extends BaseClass {

    CheckoutPage checkout;

    @When("User adds product to cart")
    public void addProduct() {

        checkout = new CheckoutPage(driver);
        checkout.addProduct();
    }

    

    @When("User clicks Proceed To Checkout")
    public void checkout() {

        checkout.proceedCheckout();
    }

    @When("User clicks Register Login link")
    public void registerLogin() {

        checkout.clickRegisterLogin();
    }

    @Then("Verify Address Details page")
    public void verifyAddress() {

        Assert.assertTrue(checkout.verifyAddress());
    }

    @When("User enters order comment")
    public void comment() {

        checkout.enterComment();
    }

    @When("User clicks Place Order")
    public void placeOrder() {

        checkout.placeOrder();
    }

    @When("User enters payment details")
    public void payment() {

        checkout.payment();
    }

    @When("User clicks Pay and Confirm Order")
    public void confirm() {

        checkout.confirmOrder();
    }

    @Then("Verify Order placed successfully")
    public void success() {

        Assert.assertTrue(checkout.verifyOrder());
    }
}