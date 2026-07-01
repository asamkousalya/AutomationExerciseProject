package pages;
 
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
 
public class LoginPage {
 
WebDriver driver;
 
public LoginPage(WebDriver driver){
 
this.driver=driver;
 
PageFactory.initElements(driver,this);
 
}
 
@FindBy(xpath="//input[@data-qa='login-email']")
WebElement email;
 
@FindBy(name="password")
WebElement pass;
 
@FindBy(xpath="//button[text()='Login']")
WebElement login;
@FindBy(xpath="//a[contains(text(),'Logged in as')]")
WebElement loggedUser;
 
public void login(String user,String pwd){
 
email.sendKeys(user);
 
pass.sendKeys(pwd);
 
}
 
public void clickLogin(){
 
login.click();
 
}
public boolean verifyLoggedInUser() {
    return loggedUser.isDisplayed();
}
 
}
 