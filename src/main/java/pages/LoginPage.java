package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(linkText = "Log in")
    private WebElement loginLink;
    @FindBy(id = "Email")
    private WebElement emailField;
    @FindBy(id = "Password")
    private WebElement passwordField;
    @FindBy(css = "input[value='Log in']")
    private WebElement loginButton;
    @FindBy(css = ".validation-summary-errors")
    private WebElement errorMessage;
    @FindBy(linkText = "Log out")
    private WebElement logoutLink;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToLogin() {
        click(loginLink);
    }

    public void login(String email, String password) {
        sendKeys(emailField, email);
        sendKeys(passwordField, password);
        click(loginButton);
        click(loginButton , 5);
    }

    public boolean isErrorMessageDisplayed() {
        return isElementDisplayed(errorMessage);
    }

    public boolean isHomepageDisplayed() {
        return isElementDisplayed(logoutLink);
    }
}
