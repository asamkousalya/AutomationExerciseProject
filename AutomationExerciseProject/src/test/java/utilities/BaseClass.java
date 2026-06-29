package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseClass {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public void setup() {
        driver = DriverFactory.initDriver();
        driver.get(ConfigReader.getUrl());

       
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
