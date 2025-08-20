package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions(
        // Path to the feature files (should be in src/test/resources)
        features = "src/test/java/features",
        // Package name of step definitions
        glue = {"stepDefinitions", "hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/html-report.html",
                "json:target/cucumber-reports/report.json",
                "junit:target/cucumber-reports/report.xml"
        },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
