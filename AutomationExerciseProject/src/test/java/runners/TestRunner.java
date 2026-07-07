package runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(

		features = "src/test/resources/features",
		glue = {
				"stepDefinitions",
				"hooks"
		},
				plugin = {
					    "pretty",
					    "html:target/cucumber-report.html",
					    "json:target/cucumber.json",
					    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
					},
		tags="@checkout",
		monochrome = true,
		publish = false
		)
public class TestRunner extends AbstractTestNGCucumberTests {
	
}


