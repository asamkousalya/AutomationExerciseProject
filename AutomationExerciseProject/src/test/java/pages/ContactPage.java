package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage {

    WebDriver driver;

    @FindBy(xpath="//a[contains(text(),'Contact us')]")
    WebElement contactUsBtn;

    @FindBy(xpath="//h2[text()='Get In Touch']")
    WebElement getInTouchText;

    @FindBy(name="name")
    WebElement name;

    @FindBy(name="email")
    WebElement email;

    @FindBy(name="subject")
    WebElement subject;

    @FindBy(id="message")
    WebElement message;

    @FindBy(name="upload_file")
    WebElement uploadFile;

    @FindBy(name="submit")
    WebElement submitBtn;

    @FindBy(xpath="//div[@class='status alert alert-success']")
    WebElement successMsg;


    @FindBy(xpath="//a[contains(text(),'Home')]")
    WebElement homeBtn;


    public ContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickContactUs() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(contactUsBtn));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true);", contactUsBtn);

        js.executeScript("arguments[0].click();", contactUsBtn);
    }

    public boolean verifyGetInTouch() {
        return getInTouchText.isDisplayed();
    }

    public void enterDetails() {

        name.sendKeys("Soham");
        email.sendKeys("soham@gmail.com");
        subject.sendKeys("Automation Testing");
        message.sendKeys("Testing Contact Form");
    }

    public void uploadDocument(String path) {
        uploadFile.sendKeys(path);
    }

    public void clickSubmit() {
        submitBtn.click();
    }

    public String getSuccessMessage() {
        return successMsg.getText();
    }

    public void clickHome() {
        homeBtn.click();
    }
}