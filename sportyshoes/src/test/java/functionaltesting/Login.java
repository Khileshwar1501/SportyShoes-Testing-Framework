package functionaltesting;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	
	 private WebDriver driver;

	    @BeforeEach
	    public void setup() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.get("https://www.sportyshoes.com/login");
	    }

	    @Test
	    public void testUserSignup() {
	       
	        WebElement emailField = driver.findElement(By.id("email"));
	        WebElement passwordField = driver.findElement(By.id("password"));
	        WebElement signupButton = driver.findElement(By.id("signup"));

	        emailField.sendKeys("testuser@example.com");
	        passwordField.sendKeys("password123");
	        signupButton.click();

	       
	        WebElement dashboard = driver.findElement(By.id("user-dashboard"));
	        assert(dashboard.isDisplayed());
	    }

	    @Test
	    public void testUserLogin() {
	        
	        WebElement emailField = driver.findElement(By.id("email"));
	        WebElement passwordField = driver.findElement(By.id("password"));
	        WebElement loginButton = driver.findElement(By.id("login"));

	        emailField.sendKeys("testuser@example.com");
	        passwordField.sendKeys("password123");
	        loginButton.click();

	       
	        WebElement dashboard = driver.findElement(By.id("user-dashboard"));
	        assert(dashboard.isDisplayed());
	    }

	    @AfterEach
	    public void tearDown() {
	        driver.quit();
	    }
	}


