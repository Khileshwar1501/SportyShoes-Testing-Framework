package functionaltesting;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Dashboard {
	
	private WebDriver driver;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.sportyshoes.com/dashboard");
    }

    @Test
    public void testProfileEditing() {
        
        WebElement editProfileButton = driver.findElement(By.id("edit-profile"));
        editProfileButton.click();

        WebElement nameField = driver.findElement(By.id("name"));
        nameField.clear();
        nameField.sendKeys("New Name");

        WebElement saveButton = driver.findElement(By.id("save-profile"));
        saveButton.click();

      
        WebElement nameDisplay = driver.findElement(By.id("profile-name"));
        assert(nameDisplay.getText().equals("New Name"));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

