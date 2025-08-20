package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.DriverInstance;


import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By logo = By.className("logo");
    private final By loginUsername = By.name("username");
    private final By loginPassword = By.name("password");
    private final By loginButton = By.cssSelector("input[value='Log In']");
    private final By registerLink = By.linkText("Register");
    private final By contactUsLink = By.linkText("Contact");

    public HomePage() {
        this.driver = DriverInstance.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public boolean isLogoDisplayed() {
        return driver.findElement(logo).isDisplayed();
    }

    public boolean isRegisterLinkDisplayed() {
        return driver.findElement(registerLink).isDisplayed();
    }

    public boolean isContactLinkDisplayed() {
        return driver.findElement(contactUsLink).isDisplayed();
    }

    public void enterUsername(String username) {
        driver.findElement(loginUsername).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(loginPassword).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isLoginSuccessful() {
        // After login, dashboard page contains "Accounts Overview" title
        return driver.getTitle().contains("ParaBank | Accounts Overview");
    }

}
