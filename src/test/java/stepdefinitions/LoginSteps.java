package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverFactory;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    public LoginSteps() {
        this.driver = DriverFactory.getDriver(ConfigReader.getProperty("browser"));
        this.loginPage = new LoginPage(driver);
    }

    @Given("I am on the Demo Web Shop homepage")
    public void i_am_on_the_demo_web_shop_homepage() {
        driver.get(ConfigReader.getProperty("url"));
    }

    @When("I navigate to the login page")
    public void i_navigate_to_the_login_page() {
        loginPage.navigateToLogin();
    }

    @When("I enter valid login credentials")
    public void i_enter_valid_login_credentials() {
        loginPage.login(ConfigReader.getProperty("valid_email"), ConfigReader.getProperty("valid_password"));
    }

    @When("I enter invalid login credentials")
    public void i_enter_invalid_login_credentials() {
        loginPage.login(ConfigReader.getProperty("invalid_email"), ConfigReader.getProperty("invalid_password"));
    }

    @Then("I should be redirected to the homepage")
    public void i_should_be_redirected_to_the_homepage() {
        Assert.assertTrue(loginPage.isHomepageDisplayed(), "Homepage not displayed after valid login");
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for invalid login");
    }
}
