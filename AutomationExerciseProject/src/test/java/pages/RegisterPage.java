package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {

    WebDriver driver;

    public RegisterPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()=' Signup / Login']")
    WebElement signup;

    @FindBy(name = "name")
    WebElement name;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement email;

    @FindBy(xpath = "//button[text()='Signup']")
    WebElement signupBtn;

    @FindBy(id = "id_gender1")
    WebElement gender;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "days")
    WebElement day;

    @FindBy(id = "months")
    WebElement month;

    @FindBy(id = "years")
    WebElement year;

    @FindBy(id = "first_name")
    WebElement fname;

    @FindBy(id = "last_name")
    WebElement lname;

    @FindBy(id = "address1")
    WebElement address;

    @FindBy(id = "country")
    WebElement country;

    @FindBy(id = "state")
    WebElement state;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "zipcode")
    WebElement zipcode;

    @FindBy(id = "mobile_number")
    WebElement mobile;

    @FindBy(xpath = "//button[text()='Create Account']")
    WebElement create;

    @FindBy(xpath = "//b[text()='Account Created!']")
    WebElement accountCreated;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    WebElement continueBtn;

    public void clickSignup() {
        signup.click();
    }

    public void enterSignup(String uname, String mail) {
        name.sendKeys(uname);
        email.sendKeys(mail);
    }

    public void clickSignupButton() {
        signupBtn.click();
    }

    public void accountDetails() {

        gender.click();
        password.sendKeys("Test@123");

        new Select(day).selectByValue("1");
        new Select(month).selectByValue("1");
        new Select(year).selectByValue("2000");
    }

    public void addressDetails() {

        fname.sendKeys("Kousalya");
        lname.sendKeys("A");
        address.sendKeys("Hyderabad");

        new Select(country).selectByVisibleText("India");

        state.sendKeys("Telangana");
        city.sendKeys("Hyderabad");
        zipcode.sendKeys("500001");
        mobile.sendKeys("9876543210");
    }

    public void createAccount() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", create);
        Thread.sleep(1000);
        js.executeScript("arguments[0].click();", create);
    }

    public boolean created() {
        return accountCreated.isDisplayed();
    }

    public void clickContinue() {
        continueBtn.click();
    }
}