package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import utility.ConfigReader;


public class HomeSteps {

    private HomePage homePage;

    @Given("I open the Parabank homepage")
    public void i_open_the_parabank_homepage() {
        homePage = new HomePage();   // initialize here, AFTER Hooks ran
        String baseUrl = ConfigReader.getProperty("baseUrl");
        homePage.openHomePage(baseUrl);
    }

    @Then("the logo should be visible")
    public void the_logo_should_be_visible() throws InterruptedException {
        Assert.assertTrue(homePage.isLogoDisplayed(), "Logo is not visible");
        Thread.sleep(3000);
    }
//
//    @Then("the Register link should be visible")
//    public void verifyRegisterLink() {
//        Assert.assertTrue(homePage.isRegisterLinkDisplayed(), "Register link not visible");
//    }
//
//    @Then("the Contact link should be visible")
//    public void verifyContactLink() {
//        Assert.assertTrue(homePage.isContactLinkDisplayed(), "Contact link not visible");
//    }

//    @When("I login with username {string} and password {string}")
//    public void login(String username, String password) {
//        homePage.enterUsername(username);
//        homePage.enterPassword(password);
//        homePage.clickLogin();
//    }

//    @Then("I should be redirected to the Accounts Overview page")
//    public void verifySuccessfulLogin() {
//        Assert.assertTrue(homePage.isLoginSuccessful(), "Login was not successful");
//    }
//
//    @Then("an error message should be displayed")
//    public void verifyLoginError() {
//        // Basic check for error message on failed login
//        Assert.assertTrue(
//                homePage.isRegisterLinkDisplayed(), // you can improve by adding actual error locator
//                "Error message not displayed"
//        );
//    }
}
