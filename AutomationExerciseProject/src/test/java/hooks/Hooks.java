package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import utilities.BaseClass;
import utilities.ExtentReportManager;

public class Hooks extends BaseClass {

    static ExtentReports extent;
    static ExtentTest test;

    @BeforeAll
    public static void beforeAll() {

        extent = ExtentReportManager.getReportInstance();

    }

    @Before
    public void launchBrowser(Scenario scenario) {

        setup();
        test = extent.createTest(scenario.getName());

    }

    @After
    public void closeBrowser(Scenario scenario) {

        if (scenario.isFailed()) {

            String screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BASE64);

            test.fail("Scenario Failed")
                    .addScreenCaptureFromBase64String(screenshot);

        } else {

            test.pass("Scenario Passed");

        }

        tearDown();

    }

    @AfterAll
    public static void afterAll() {

        extent.flush();

    }

}