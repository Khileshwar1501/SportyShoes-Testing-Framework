package functionaltesting;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Homepage {
	
	private WebDriver driver;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.sportyshoes.com"); 
    }

    @Test
    public void testProductListings() {
  
        WebElement productList = driver.findElement(By.cssSelector(".product-list"));
        assert(productList.isDisplayed());

        WebElement firstProduct = driver.findElement(By.cssSelector(".product:first-child"));
        assert(firstProduct.findElement(By.cssSelector(".product-name")).getText().length() > 0);
        assert(firstProduct.findElement(By.cssSelector(".product-price")).getText().length() > 0);
    }

    @Test
    public void testProductDetailNavigation() {
        
        WebElement firstProduct = driver.findElement(By.cssSelector(".product:first-child"));
        WebElement productLink = firstProduct.findElement(By.cssSelector(".product-link"));
        productLink.click();

        
        WebElement productDetail = driver.findElement(By.cssSelector(".product-detail"));
        assert(productDetail.isDisplayed());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

