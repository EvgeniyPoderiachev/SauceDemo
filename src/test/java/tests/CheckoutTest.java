package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {


    @Test
    public void lastNameShouldBeRequired() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
        checkoutPage.loginToCheckout("Evgen","","1234");
        assertEquals(checkoutPage.getError(),"Error: Last Name is required");
   }
    @Test
    public void firstNameShouldBeRequired() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
        checkoutPage.loginToCheckout("","","");
        assertEquals(checkoutPage.getError(),"Error: First Name is required");
    }
    @Test
    public void postalCodeShouldBeRequired() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
        checkoutPage.loginToCheckout("Evgen","Evgend","");
        assertEquals(checkoutPage.getError(),"Error: Postal Code is required");
    }
}
