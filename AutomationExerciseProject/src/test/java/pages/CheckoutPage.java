package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    WebElement continueBtn;

    @FindBy(xpath = "//a[contains(text(),'Cart')]")
    WebElement cart;

    @FindBy(xpath = "//a[contains(text(),'Proceed To Checkout')]")
    WebElement checkout;

    @FindBy(xpath = "//a[contains(text(),'Signup / Login')]")
    WebElement registerLogin;

    @FindBy(name = "message")
    WebElement comment;

    @FindBy(xpath = "//a[contains(text(),'Place Order')]")
    WebElement placeOrder;

    @FindBy(name = "name_on_card")
    WebElement cardName;

    @FindBy(name = "card_number")
    WebElement cardNumber;

    @FindBy(name = "cvc")
    WebElement cvc;

    @FindBy(name = "expiry_month")
    WebElement month;

    @FindBy(name = "expiry_year")
    WebElement year;

    @FindBy(id = "submit")
    WebElement payBtn;

    @FindBy(xpath = "//p[contains(text(),'Congratulations! Your order has been confirmed!')]")
    WebElement success;

    @FindBy(xpath = "//*[contains(text(),'Address Details')]")
    WebElement address;

    public void addProduct() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,500)");

        WebElement addCart = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("a[data-product-id='1']")));

        js.executeScript("arguments[0].click();", addCart);

        WebElement continueShopping = wait.until(
                ExpectedConditions.visibilityOf(continueBtn));

        js.executeScript("arguments[0].click();", continueShopping);
    }

    public void openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cart)).click();
    }

    public void proceedCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(checkout)).click();
    }

    public void clickRegisterLogin() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement register = wait.until(
                ExpectedConditions.elementToBeClickable(registerLogin));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", register);
    }

    public boolean verifyAddress() {
        return driver.getPageSource().contains("Address Details");
    }

    public void enterComment() {
        comment.sendKeys("Automation Testing");
    }

    public void placeOrder() {
        placeOrder.click();
    }

    public void payment() {

        cardName.sendKeys("Test User");
        cardNumber.sendKeys("4111111111111111");
        cvc.sendKeys("123");
        month.sendKeys("12");
        year.sendKeys("2028");
    }

    public void confirmOrder() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", payBtn);
        js.executeScript("arguments[0].click();", payBtn);
    }

    public boolean verifyOrder() {
        return success.isDisplayed();
    }
}