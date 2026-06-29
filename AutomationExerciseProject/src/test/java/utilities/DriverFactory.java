package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {

    private static WebDriver driver;

    
    public static WebDriver initDriver() {

        String browser = ConfigReader.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } 
        else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }

        
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }

  
    public static WebDriver getDriver() {
        return driver;
    }

  
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
