package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    public static final By USER_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.name("login-button");

    public static final By CHECKOUT_BUTTON = By.id("checkout");
    public static final By USER_FIRST_NAME_INPUT = By.cssSelector("#first-name");
    public static final By USER_LAST_NAME_INPUT = By.cssSelector("#last-name");
    public static final By USER_ZIP_CODE_INPUT = By.cssSelector("#postal-code");
    public static final By CONTINUE_BUTTON = By.name("continue");
    public static final By ERROR_MESSAGE = By.cssSelector(".error-message-container");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(baseUrl + "/checkout-step-one.html");
    }
    public void openCheckoutPage() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public void login(String user, String password) {
        driver.findElement(USER_INPUT).sendKeys(user);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void loginToCheckout(String first_name, String last_name, String zip_code) {
        driver.findElement(USER_FIRST_NAME_INPUT).sendKeys(first_name);
        driver.findElement(USER_LAST_NAME_INPUT).sendKeys(last_name);
        driver.findElement(USER_ZIP_CODE_INPUT).sendKeys(zip_code);
        driver.findElement(CONTINUE_BUTTON).click();

    }

    public String getError() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
