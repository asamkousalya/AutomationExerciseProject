package hooks;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.qameta.allure.Allure;
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
    public void closeBrowser(Scenario scenario) throws IOException {

        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        String base64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

        if (scenario.isFailed()) {

            // Allure Report
            Allure.addAttachment("Failure Screenshot", "image/png",
                    new ByteArrayInputStream(screenshot), ".png");

            // Extent Report
            test.fail("Scenario Failed")
                .addScreenCaptureFromBase64String(base64);

        } else {

            // Allure Report
            Allure.addAttachment("Passed Screenshot", "image/png",
                    new ByteArrayInputStream(screenshot), ".png");

            // Extent Report
            test.pass("Scenario Passed")
                .addScreenCaptureFromBase64String(base64);
        }
        tearDown();
    }
    @AfterAll
    public static void afterAll() {
        extent.flush();
    }
}