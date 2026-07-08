package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductPage;
import utilities.BaseClass;

public class ProductSteps extends BaseClass {

    ProductPage product = new ProductPage();

    @Given("User is on Automation Exercise Home Page")
    public void user_is_on_home_page() {
        Assert.assertTrue(driver.getTitle().contains("Automation"));
    }

    @When("User clicks on Products button")
    public void user_clicks_on_products_button() {
        product.clickProducts();
    }

    @Then("User should navigate to All Products page")
    public void user_should_navigate_to_all_products_page() {
        Assert.assertTrue(product.isAllProductsDisplayed());
    }

    @When("User clicks on first View Product")
    public void user_clicks_on_first_view_product() {
        product.clickFirstViewProduct();
    }

    @Then("Product details should be displayed")    
    public void product_details_should_be_displayed() {

        Assert.assertTrue(product.isProductNameDisplayed());
        Assert.assertTrue(product.isCategoryDisplayed());
        Assert.assertTrue(product.isPriceDisplayed());
        Assert.assertTrue(product.isAvailabilityDisplayed());
        Assert.assertTrue(product.isConditionDisplayed());
        Assert.assertTrue(product.isBrandDisplayed());

    }

    @When("User searches for product {string}")
    public void user_searches_for_product(String productName) {
        product.searchProduct(productName);
    }

    @Then("Matching products should be displayed")
    public void matching_products_should_be_displayed() {

        Assert.assertTrue(product.isSearchedProductsDisplayed());
        Assert.assertTrue(product.isSearchResultDisplayed());

    }

    @Then("Search box should be displayed")
    public void search_box_should_be_displayed() {
        Assert.assertTrue(product.isSearchBoxDisplayed());
    }

    @Then("Search button should be displayed")
    public void search_button_should_be_displayed() {
        Assert.assertTrue(product.isSearchButtonDisplayed());
    }

    @Then("First View Product button should be displayed")
    public void first_view_product_button_should_be_displayed() {
        Assert.assertTrue(product.isViewProductButtonDisplayed());
    }

    @Then("Product list should be displayed")
    public void product_list_should_be_displayed() {
        Assert.assertTrue(product.isProductListDisplayed());
    }

}
