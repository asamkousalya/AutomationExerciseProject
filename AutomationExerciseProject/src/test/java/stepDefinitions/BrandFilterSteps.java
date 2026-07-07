package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.BrandFilterPage;

public class BrandFilterSteps {

    BrandFilterPage brandFilterPage = new BrandFilterPage();

    @And("User clicks on {string} brand")
    public void user_clicks_on_brand(String brandName) {

        brandFilterPage.clickBrand(brandName);
    }

    @Then("Brand page should be displayed")
    public void brand_page_should_be_displayed() {

        Assert.assertTrue(
                brandFilterPage.isBrandPageDisplayed(),
                "Brand page is not displayed");
    }
}