package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement txtEmail;

    @FindBy(name = "password")
    WebElement txtPassword;

    @FindBy(xpath = "//button[text()='Login']")
    WebElement btnLogin;

    @FindBy(xpath = "//a[contains(text(),'Logged in as')]")
    WebElement loggedInUser;

    @FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
    WebElement loginErrorMsg;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement btnLogout;

    @FindBy(xpath = "//h2[text()='Login to your account']")
    WebElement loginSection;

    public void enterCredentials(String email, String password) {
        txtEmail.clear();
        txtPassword.clear();

        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
    }

    public void clickLogin() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(btnLogin));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                btnLogin);

        wait.until(ExpectedConditions.elementToBeClickable(btnLogin));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                btnLogin);
    }

    public void clickLogout() {
        btnLogout.click();
    }

    public boolean verifyLoggedInUser() {
        return loggedInUser.isDisplayed();
    }

    public boolean verifyLoginError() {
        return loginErrorMsg.isDisplayed();
    }

    public boolean verifyLoginSectionVisible() {
        return loginSection.isDisplayed();
    }

    public boolean verifyEmailValidation() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        return !(Boolean) js.executeScript(
                "return arguments[0].checkValidity();",
                txtEmail);
    }

    public boolean verifyRequiredValidation() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        return !(Boolean) js.executeScript(
                "return arguments[0].checkValidity();",
                txtEmail);
    }
}