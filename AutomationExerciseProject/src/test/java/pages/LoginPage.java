package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//input[@data-qa='login-email']")
    WebElement email;

    @FindBy(name="password")
    WebElement pass;

    @FindBy(xpath="//button[text()='Login']")
    WebElement loginBtn;

    @FindBy(xpath="//a[contains(text(),'Logged in as')]")
    WebElement loggedUser;

    @FindBy(xpath="//p[text()='Your email or password is incorrect!']")
    WebElement errorMsg;

    public void login(String user,String pwd) {
        email.clear();
        pass.clear();
        email.sendKeys(user);
        pass.sendKeys(pwd);
    }

    public void clickLogin() {
        loginBtn.click();
    }

    public boolean verifyLoggedInUser() {
        return loggedUser.isDisplayed();
    }

    public boolean verifyLoginError() {
        return errorMsg.isDisplayed();
    }

    public boolean verifyEmailValidation() {

        JavascriptExecutor js=(JavascriptExecutor)driver;

        return !(Boolean)js.executeScript(
                "return arguments[0].checkValidity();",
                email);
    }

    public boolean verifyRequiredValidation() {

        JavascriptExecutor js=(JavascriptExecutor)driver;

        return !(Boolean)js.executeScript(
                "return arguments[0].checkValidity();",
                email);
    }

}