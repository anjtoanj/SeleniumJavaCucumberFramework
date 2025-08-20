package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utility.ConfigReader;
import utility.DriverInstance;



public class Hooks {
    @Before
    public void setUp(Scenario scenario) { // Each scenario runs with its own WebDriver.
        // Get browser from system property first (set via TestNG XML)
        String browser = System.getProperty("browser");

        // Override if scenario has a browser tag - Each scenario reads its own browser from the tags.
        if (scenario.getSourceTagNames().contains("@chrome")) {
            browser = "chrome";
        } else if (scenario.getSourceTagNames().contains("@edge")) {
            browser = "edge";
        }

        // If not provided, fallback to config file
        if (browser == null || browser.isEmpty()) {
            browser = ConfigReader.getProperty("browser");
        }

        // If config also missing, use chrome as default
        if (browser == null || browser.isEmpty()) {
            browser = "chrome";
        }

        System.out.println("Initializing browser: " + browser);
        DriverInstance.initDriver(browser);
    }
    @After
    public void tearDown() {
        DriverInstance.quitDriver();
    }

}
