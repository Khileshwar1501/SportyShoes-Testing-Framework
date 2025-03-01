package functionaltesting;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CartandCheckout {
	
	private WebDriver driver;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.sportyshoes.com");
    }

    @Test
    public void testAddToCart() {
        WebElement firstProduct = driver.findElement(By.cssSelector(".product:first-child"));
        WebElement addToCartButton = firstProduct.findElement(By.cssSelector(".add-to-cart"));
        addToCartButton.click();

        
        WebElement cartIcon = driver.findElement(By.id("cart-icon"));
        cartIcon.click();
        WebElement cartItem = driver.findElement(By.cssSelector(".cart-item"));
        assert(cartItem.isDisplayed());
    }

    @Test
    public void testCheckout() {
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();

       
        WebElement checkoutForm = driver.findElement(By.id("checkout-form"));
        assert(checkoutForm.isDisplayed());

       
        WebElement confirmPurchaseButton = driver.findElement(By.id("confirm-purchase"));
        confirmPurchaseButton.click();

        
        WebElement emptyCartMessage = driver.findElement(By.id("empty-cart-message"));
        assert(emptyCartMessage.isDisplayed());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
