import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    String user = "standard_user";
    String link = "https://www.saucedemo.com/";


    @Test
    public void checkout() {
        driver.get(link);
        driver.findElement(By.cssSelector("input[placeholder=Username]")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        driver.findElement(By.cssSelector("#checkout")).click();
        driver.findElement(By.cssSelector("#first-name")).sendKeys("Evgen");
        driver.findElement(By.cssSelector("#last-name")).sendKeys("Poderyachev");
        driver.findElement(By.cssSelector("#postal-code")).sendKeys("1234");
        driver.findElement(By.name("continue")).click();
        driver.findElement(By.name("finish")).click();
        String text = driver.findElement(By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']")).getText();
        assertEquals(text, "THANK YOU FOR YOUR ORDER", "msg");

    }
}
