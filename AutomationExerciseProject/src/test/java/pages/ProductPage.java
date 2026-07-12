package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BaseClass;

public class ProductPage extends BaseClass {

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Products')]")
    WebElement productsBtn;

    @FindBy(xpath = "//h2[contains(text(),'All Products')]")
    WebElement allProductsHeading;

    @FindBy(xpath = "(//a[contains(text(),'View Product')])[1]")
    WebElement firstViewProduct;

    @FindBy(xpath = "//div[@class='product-information']/h2")
    WebElement productName;

    @FindBy(xpath = "//div[@class='product-information']/p[1]")
    WebElement category;

    @FindBy(xpath = "//div[@class='product-information']/span/span")
    WebElement price;

    @FindBy(xpath = "//b[text()='Availability:']")
    WebElement availability;

    @FindBy(xpath = "//b[text()='Condition:']")
    WebElement condition;

    @FindBy(xpath = "//b[text()='Brand:']")
    WebElement brand;

    @FindBy(id = "search_product")
    WebElement searchBox;

    @FindBy(id = "submit_search")
    WebElement searchButton;

    @FindBy(xpath = "//h2[text()='Searched Products']")
    WebElement searchedProductsHeading;

    @FindBy(xpath = "//div[@class='features_items']")
    WebElement searchedProducts;

    @FindBy(xpath = "//div[@class='features_items']")
    WebElement productList;

    public void clickProducts() {
        productsBtn.click();
    }

    public boolean isAllProductsDisplayed() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(allProductsHeading));

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
        searchBox.clear();
        searchBox.sendKeys(product);
        searchButton.click();
    }

    public boolean isSearchedProductsDisplayed() {
        return searchedProductsHeading.isDisplayed();
    }

    public boolean isSearchResultDisplayed() {
        return searchedProducts.isDisplayed();
    }

    public boolean isSearchBoxDisplayed() {
        return searchBox.isDisplayed();
    }

    public boolean isSearchButtonDisplayed() {
        return searchButton.isDisplayed();
    }

    public boolean isViewProductButtonDisplayed() {
        return firstViewProduct.isDisplayed();
    }

    public boolean isProductListDisplayed() {
        return productList.isDisplayed();
    }

}











