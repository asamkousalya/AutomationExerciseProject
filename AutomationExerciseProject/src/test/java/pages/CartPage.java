package pages;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BaseClass;
 
public class CartPage extends BaseClass {
 
    WebDriver driver = BaseClass.driver;
 
    By cartBtn =
            By.xpath("//a[contains(text(),'Cart')]");
 
    By subscriptionEmail =
            By.id("susbscribe_email");
 
    By subscribeBtn =
            By.id("subscribe");
 
    By successMsg =
            By.xpath("//*[contains(text(),'successfully subscribed')]");
 
    By productsBtn =
            By.xpath("//a[contains(text(),'Products')]");
 
    By firstAdd =
            By.xpath("(//a[contains(text(),'Add to cart')])[1]");
 
    By continueBtn =
            By.xpath("//button[contains(text(),'Continue')]");
 
    By secondAdd =
            By.xpath("(//a[contains(text(),'Add to cart')])[2]");
 
    By viewCart =
            By.xpath("//u[contains(text(),'View Cart')]");
 
    By quantity =
            By.id("quantity");
 
    By remove =
            By.className("cart_quantity_delete");
 
    By search =
            By.name("search");
 
    By searchBtn =
            By.id("submit_search");
 
    public void openCart() {
    	 
        WebElement cart =
            new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(cartBtn));
     
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].scrollIntoView(true);", cart);
     
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", cart);
    }
 
    public void subscribe(String email) {
    	 
    	driver.findElement(subscriptionEmail)
    	.sendKeys(email);
    	 
    	JavascriptExecutor js =
    	(JavascriptExecutor) driver;
    	 
    	WebElement subscribe =
    	driver.findElement(subscribeBtn);
    	 
    	js.executeScript(
    	"arguments[0].scrollIntoView(true);",
    	subscribe);
    	 
    	WebDriverWait wait =
    	new WebDriverWait(
    	driver,
    	Duration.ofSeconds(10));
    	 
    	wait.until(
    	ExpectedConditions.elementToBeClickable(
    	subscribe));
    	 
    	subscribe.click();
    	}
 
    public boolean verifySubscription() {
        return driver.findElement(successMsg)
                .isDisplayed();
    }
 
    public void openProducts() {
        driver.findElement(productsBtn).click();
    }
 
    public void addProducts() {
    	 
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	 
    	WebElement first =
    	wait.until(ExpectedConditions.elementToBeClickable(
    	By.xpath("(//a[contains(text(),'Add to cart')])[1]")));
    	 
    	((JavascriptExecutor)driver)
    	.executeScript("arguments[0].scrollIntoView(true);", first);
    	 
    	((JavascriptExecutor) driver).executeScript("arguments[0].click();", first);
    	}
 
    public void setQuantity(String qty) {
    	 
        WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(20));
     
        WebElement viewProduct =
            wait.until(
                ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(text(),'View Product')]")
                ));
     
        ((JavascriptExecutor) driver)
            .executeScript(
                "arguments[0].scrollIntoView(true);",
                viewProduct);
     
        ((JavascriptExecutor) driver)
            .executeScript(
                "arguments[0].click();",
                viewProduct);
     
        // page load wait
        wait.until(
            ExpectedConditions.urlContains("product"));
     
        WebElement quantity =
            wait.until(
                ExpectedConditions.elementToBeClickable(
                    By.id("quantity")));
     
        quantity.clear();
        quantity.sendKeys(qty);
    }
     
    	 
 
    public void removeProduct() {
    	 
        addProducts();
     
        driver.findElement(
        By.xpath("//u[text()='View Cart']"))
        .click();
     
        WebDriverWait wait =
        new WebDriverWait(driver,
        Duration.ofSeconds(10));
     
        WebElement delete =
        wait.until(
        ExpectedConditions.elementToBeClickable(
        By.className("cart_quantity_delete")));
     
        delete.click();
    }
    public boolean verifyRemoved() {
    	return driver.getPageSource().contains("Cart is empty");
    }
 
    public void searchProduct(String product) {
    	 
    	WebDriverWait wait =
    	new WebDriverWait(driver, Duration.ofSeconds(20));
    	 
    	wait.until(ExpectedConditions
    	.visibilityOfElementLocated(By.name("search")));
    	 
    	driver.findElement(By.name("search"))
    	.sendKeys(product);
    	
    	driver.findElement(By.id("submit_search"))
    	.click();
    	}
}
 
