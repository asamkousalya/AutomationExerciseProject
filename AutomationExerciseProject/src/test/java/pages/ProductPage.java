package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilities.BaseClass;

public class ProductPage extends BaseClass {

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    // Products Button
    @FindBy(xpath = "//a[@href='/products']")
    WebElement productsBtn;

    // All Products Heading
    @FindBy(xpath = "//h2[text()='All Products']")
    WebElement allProductsHeading;

    // First View Product Button
    @FindBy(xpath = "(//a[contains(text(),'View Product')])[1]")
    WebElement firstViewProduct;

    // Product Name
    @FindBy(xpath = "//div[@class='product-information']/h2")
    WebElement productName;

    // Category
    @FindBy(xpath = "//div[@class='product-information']/p[1]")
    WebElement category;

    // Price
    @FindBy(xpath = "//div[@class='product-information']/span/span")
    WebElement price;

    // Availability
    @FindBy(xpath = "//b[text()='Availability:']")
    WebElement availability;

    // Condition
    @FindBy(xpath = "//b[text()='Condition:']")
    WebElement condition;

    // Brand
    @FindBy(xpath = "//b[text()='Brand:']")
    WebElement brand;

    // Search Box
    @FindBy(id = "search_product")
    WebElement searchBox;

    // Search Button
    @FindBy(id = "submit_search")
    WebElement searchButton;

    // Searched Products Heading
    @FindBy(xpath = "//h2[text()='Searched Products']")
    WebElement searchedProductsHeading;

    // Product List
    @FindBy(xpath = "//div[@class='features_items']")
    WebElement searchedProducts;

    // Methods

    public void clickProducts() {
        productsBtn.click();
    }

    public boolean isAllProductsDisplayed() {
        return allProductsHeading.isDisplayed();
    }

    public void clickFirstViewProduct() {
    	wait.until(ExpectedConditions.visibilityOf(firstViewProduct));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                firstViewProduct);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                firstViewProduct);
    }

    public boolean isProductNameDisplayed() {
        return productName.isDisplayed();
    }

    public boolean isCategoryDisplayed() {
        return category.isDisplayed();
    }

    public boolean isPriceDisplayed() {
        return price.isDisplayed();
    }

    public boolean isAvailabilityDisplayed() {
        return availability.isDisplayed();
    }

    public boolean isConditionDisplayed() {
        return condition.isDisplayed();
    }

    public boolean isBrandDisplayed() {
        return brand.isDisplayed();
    }

    public void searchProduct(String product) {
        searchBox.sendKeys(product);
        searchButton.click();
    }

    public boolean isSearchedProductsDisplayed() {
        return searchedProductsHeading.isDisplayed();
    }

    public boolean isSearchResultDisplayed() {
        return searchedProducts.isDisplayed();
    }
}