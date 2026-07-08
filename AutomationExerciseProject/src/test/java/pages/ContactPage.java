package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        contactUsBtn.click();
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