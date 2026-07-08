package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilities.BaseClass;

public class CategoryFilterPage extends BaseClass {

    public void clickCategory(String category) {

        if (category.equalsIgnoreCase("Women")) {

            WebElement women = driver.findElement(
                    By.xpath("//a[@href='#Women']"));

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", women);

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//a[@href='/category_products/1']")));

            WebElement dress = driver.findElement(
                    By.xpath("//a[@href='/category_products/1']"));

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", dress);
        }

        else if (category.equalsIgnoreCase("Men")) {

            WebElement men = driver.findElement(
                    By.xpath("//a[@href='#Men']"));

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", men);

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//a[@href='/category_products/3']")));

            WebElement tshirts = driver.findElement(
                    By.xpath("//a[@href='/category_products/3']"));

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", tshirts);
        }

        else if (category.equalsIgnoreCase("Kids")) {

            WebElement kids = driver.findElement(
                    By.xpath("//a[@href='#Kids']"));

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", kids);

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//a[@href='/category_products/5']")));

            WebElement dress = driver.findElement(
                    By.xpath("//a[@href='/category_products/5']"));

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", dress);
        }
    }

    public boolean isCategoryDisplayed() {

        wait.until(ExpectedConditions.urlContains("category_products"));

        return driver.getCurrentUrl()
                .contains("category_products");
    }
}