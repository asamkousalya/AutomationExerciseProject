package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubscriptionPage {

    WebDriver driver;


    @FindBy(xpath="//h2[contains(text(),'Subscription')]")
    WebElement subscriptionText;


    @FindBy(id="susbscribe_email")
    WebElement emailBox;

    @FindBy(id="subscribe")
    WebElement subscribeBtn;


    @FindBy(xpath="//*[contains(text(),'You have been successfully subscribed!')]")
    WebElement successMessage;


    @FindBy(xpath="//a[contains(text(),'Cart')]")
    WebElement cartBtn;

    public SubscriptionPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean verifySubscriptionText() {

        return subscriptionText.isDisplayed();
    }

    public void enterEmail() {

        emailBox.sendKeys("soham@gmail.com");
    }

    public void clickSubscribeButton() {

        subscribeBtn.click();
    }

    public String getSuccessMessage() {

        return successMessage.getText();
    }

    public void clickCart() {

        cartBtn.click();
    }
}
