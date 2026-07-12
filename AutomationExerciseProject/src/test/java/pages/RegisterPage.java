package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

    WebDriver driver;
    WebDriverWait wait;

    public RegisterPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Home Page

    @FindBy(xpath = "//a[contains(text(),'Signup / Login')]")
    WebElement signup;

    // Signup Page

    @FindBy(name = "name")
    WebElement name;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement email;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    WebElement signupButton;

    @FindBy(xpath = "//p[text()='Email Address already exist!']")
    WebElement emailExistsMsg;

    // Account Information

    @FindBy(id = "id_gender1")
    WebElement maleGender;

    @FindBy(id = "id_gender2")
    WebElement femaleGender;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "days")
    WebElement day;

    @FindBy(id = "months")
    WebElement month;

    @FindBy(id = "years")
    WebElement year;

    // Address Information

    @FindBy(id = "first_name")
    WebElement firstName;

    @FindBy(id = "last_name")
    WebElement lastName;

    @FindBy(id = "company")
    WebElement company;

    @FindBy(id = "address1")
    WebElement address1;

    @FindBy(id = "address2")
    WebElement address2;

    @FindBy(id = "country")
    WebElement country;

    @FindBy(id = "state")
    WebElement state;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "zipcode")
    WebElement zipcode;

    @FindBy(id = "mobile_number")
    WebElement mobileNumber;

    // Create Account

    @FindBy(xpath = "//button[text()='Create Account']")
    WebElement createAccountButton;

    @FindBy(xpath = "//b[text()='Account Created!']")
    WebElement accountCreatedMessage;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    WebElement continueButton;

    // ================= Methods =================

    public void clickSignup() {

        wait.until(ExpectedConditions.elementToBeClickable(signup));
        signup.click();
    }

    public void enterSignup(String userName, String emailId) {

        name.clear();
        email.clear();

        name.sendKeys(userName);
        email.sendKeys(emailId);
    }

    public void clickSignupButton() {

        wait.until(ExpectedConditions.elementToBeClickable(signupButton));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", signupButton);
    }

    public void accountDetails(String gender,
                               String pwd,
                               String d,
                               String m,
                               String y) {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        if (gender.equalsIgnoreCase("Male")) {

            js.executeScript("arguments[0].click();", maleGender);

        } else {

            js.executeScript("arguments[0].click();", femaleGender);
        }

        password.sendKeys(pwd);

        new Select(day).selectByValue(d);

        // If feature file uses January, February...
        new Select(month).selectByVisibleText(m);

        // If feature file uses 1,2,3... replace above with:
        // new Select(month).selectByValue(m);

        new Select(year).selectByValue(y);
    }

    public void addressDetails(String fname,
                               String lname,
                               String addr,
                               String countryValue,
                               String stateValue,
                               String cityValue,
                               String zipValue,
                               String mobileValue) {

        firstName.sendKeys(fname);

        lastName.sendKeys(lname);

        company.sendKeys("Wipro");

        address1.sendKeys(addr);

        address2.sendKeys("Near Metro Station");

        new Select(country).selectByVisibleText(countryValue);

        state.sendKeys(stateValue);

        city.sendKeys(cityValue);

        zipcode.sendKeys(zipValue);

        mobileNumber.sendKeys(mobileValue);
    }

    public void createAccount() {

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);",
                        createAccountButton);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();",
                        createAccountButton);
    }

    public boolean verifyAccountCreated() {

        return accountCreatedMessage.isDisplayed();
    }

    public void clickContinue() {

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();",
                        continueButton);
    }
    public void enterNameAndEmail() {

        enterSignup(
                "TestUser",
                "test"+System.currentTimeMillis()+"@gmail.com");
    }

    public boolean verifyAccountInformationPage() {

        return driver.getCurrentUrl().contains("signup");
    }

    public void enterAccountDetails() {

        accountDetails(
                "Male",
                "Test@123",
                "10",
                "May",
                "1998");
    }

    public void enterAddressDetails() {

        addressDetails(
                "Test",
                "User",
                "Hyderabad",
                "India",
                "Telangana",
                "Hyderabad",
                "500001",
                "9876543212");
    }

    // Negative Scenarios

    public void enterExistingUser() {

        enterSignup(
                "Existing User",
                "vaibhavmakne0601@gmail.com");

        clickSignupButton();
    }

    public boolean verifyEmailExists() {

        return emailExistsMsg.isDisplayed();
    }

    public void enterInvalidEmail() {

        enterSignup(
                "Test User",
                "abcgmail.com");

        clickSignupButton();
    }

    public void enterEmptyName() {

        name.clear();

        email.clear();

        email.sendKeys("test@gmail.com");

        clickSignupButton();
    }

    public void enterEmptyEmail() {

        name.clear();

        email.clear();

        name.sendKeys("Test User");

        clickSignupButton();
    }

    public void enterEmptyNameAndEmail() {

        name.clear();

        email.clear();

        clickSignupButton();
    }

    public void enterSpecialCharacterName() {

        enterSignup(
                "@@@Test###",
                "test" + System.currentTimeMillis() + "@gmail.com");

        clickSignupButton();
    }

    public void enterLongName() {

        enterSignup(
                "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ",
                "test" + System.currentTimeMillis() + "@gmail.com");

        clickSignupButton();
    }

    public void enterNameWithSpaces() {

        enterSignup(
                "   Test User   ",
                "test" + System.currentTimeMillis() + "@gmail.com");

        clickSignupButton();
    }

    public boolean verifySignupPage() {

        return driver.getCurrentUrl().contains("signup");
    }
}