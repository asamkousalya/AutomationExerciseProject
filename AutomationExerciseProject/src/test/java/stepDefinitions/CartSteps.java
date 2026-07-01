package stepDefinitions;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
public class CartSteps {
    CartPage cart = new CartPage();
 
    @Given("User opens cart page")
    public void openCart() {
        cart.openCart();
    }
 
    @When("User scrolls to footer")
    public void scrollFooter() {
    }
 
    @When("User enters email and subscribes")
    public void subscribe() {
        cart.subscribe("test@gmail.com");
    }
 
    @Then("Subscription success message should display")
    public void verifySubscribe() {
 
        Assert.assertTrue(
                cart.verifySubscription());
    }
 
    @Given("User opens products page")
    public void productsPage() {
        cart.openProducts();
    }
 
    @When("User adds first and second product")
    public void addProducts() {
        cart.addProducts();
    }
    @When("User opens cart")
    public void user_opens_cart() {
    	cart.openCart();
    }
 
    @Then("Products should display in cart")
    public void verifyCart() {
        System.out.println("Products added");
    }
 
    @Given("User opens product details")
    public void openProduct() {
    }
 
    @When("User increases quantity to {string}")
    public void quantity(String qty) {
        cart.setQuantity(qty);
    }
 
    @When("User adds product into cart")
    public void addCart() {
    }
 
    @Then("Product quantity should display correctly")
    public void verifyQuantity() {
    }
 
    @Given("User added products")
    public void alreadyAdded() {
        cart.addProducts();
    }
 
    @When("User removes product")
    public void remove() {
        cart.removeProduct();
    }
 
    @Then("Product should be removed")
    public void removed() {
    		Assert.assertTrue(cart.verifyRemoved());
    }
 
    @Given("User searches product")
    public void search() {
    	cart.openProducts();
        cart.searchProduct("Blue Top");
    }
 
    @When("User adds searched products to cart")
    public void addSearch() {
    }
 
    @When("User login and open cart")
    public void login() {
    }
 
    @Then("Products should remain in cart")
    public void verifyRemain() {
    }
 
    @When("User selects brand")
    public void selectBrand() {
    }
 
    @Then("Brand products should display")
    public void verifyBrand() {
    }
}
 