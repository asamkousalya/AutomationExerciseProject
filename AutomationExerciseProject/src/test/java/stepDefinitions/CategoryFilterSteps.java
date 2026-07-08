package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CategoryFilterPage;

public class CategoryFilterSteps {

    CategoryFilterPage categoryPage = new CategoryFilterPage();

    @And("User clicks {string} category")
    public void user_clicks_category(String category) {

        categoryPage.clickCategory(category);
    }

    @Then("{string} products should be displayed")
    public void products_should_be_displayed(String category) {

        Assert.assertTrue(
                categoryPage.isCategoryDisplayed(),
                "Category page is not displayed");
    }
}