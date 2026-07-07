package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilities.BaseClass;

public class BrandFilterPage extends BaseClass {

    public BrandFilterPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickBrand(String brandName) {

        WebElement brand = driver.findElement(
                By.xpath("//a[contains(@href,'/brand_products/') and contains(.,'"
                        + brandName + "')]"));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                brand);

        wait.until(ExpectedConditions.elementToBeClickable(brand));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                brand);
    }

    public boolean isBrandPageDisplayed() {

        return driver.getCurrentUrl().contains("brand_products");
    }
}