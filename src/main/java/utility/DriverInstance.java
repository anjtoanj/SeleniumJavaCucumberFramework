package utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverInstance{

    private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static void initDriver(String browser) {
        if (getDriver() != null) return;

        switch (browser.toLowerCase()) {
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions fo = new FirefoxOptions();
                //     if (headless) fo.addArguments("-headless");
                tlDriver.set(new FirefoxDriver(fo));
            }
            case "chrome" -> {
                WebDriverManager.chromedriver().browserVersion("139").setup();
                ChromeOptions co = new ChromeOptions();
                //     if (headless) co.addArguments("--headless=new");
                co.addArguments("--window-size=1920,1080");
                tlDriver.set(new ChromeDriver(co));
            }
            case "edge" -> {
                System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");
                EdgeOptions eo = new EdgeOptions();
                //       if (headless) eo.addArguments("--headless=new");
                eo.addArguments("--window-size=1920,1080");
                tlDriver.set(new EdgeDriver(eo));
            }
            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
    }

    public static WebDriver getDriver() { return tlDriver.get(); }

    public static void quitDriver() {
        if (getDriver() != null) { getDriver().quit(); tlDriver.remove(); }
    }
}
