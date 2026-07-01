package pages;
 
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
 
public class RegisterPage {
 
WebDriver driver;
 
public RegisterPage(WebDriver driver){
this.driver=driver;
PageFactory.initElements(driver,this);
}
 
@FindBy(xpath="//a[text()=' Signup / Login']")
WebElement signup;
 
@FindBy(name="name")
WebElement name;
 
@FindBy(xpath="//input[@data-qa='signup-email']")
WebElement email;
 
@FindBy(xpath="//button[text()='Signup']")
WebElement signupBtn;
 
@FindBy(id="password")
WebElement password;
 
@FindBy(id="first_name")
WebElement fname;
 
@FindBy(id="last_name")
WebElement lname;
 
@FindBy(xpath="//button[text()='Create Account']")
WebElement create;
 
public void clickSignup(){
signup.click();
}
public void enterSignup(String uname,String mail){
name.sendKeys(uname);
email.sendKeys(mail);
}
public void clickSignupButton(){
signupBtn.click();
}
public void accountDetails(){
password.sendKeys("Test@123");
}
public void addressDetails(){
fname.sendKeys("Kousalya");
lname.sendKeys("A");
}
public void createAccount() throws InterruptedException {

    JavascriptExecutor js = (JavascriptExecutor) driver;

    js.executeScript("arguments[0].scrollIntoView(true);", create);

    Thread.sleep(1000);

    js.executeScript("arguments[0].click();", create);
}
}