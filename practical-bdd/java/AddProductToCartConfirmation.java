package providedtestcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddProductToCartConfirmation {

    private WebDriver driver;
    private WebDriverWait myWaitVar;

    @Test
    public void AddProductToCartConfirmationTest() {

        // -- @Given( "I'm on the VGP Shop homepage" )

        // Create driver / browser
        driver = new ChromeDriver(); // Create Chrome driver
        // driver = new EdgeDriver();  // Create Edge driver
        // driver = new FirefoxDriver(); // Create Firefox driver

        myWaitVar = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();

        // Open the website
        driver.get("https://vgp-shop.polteq-testing.com/");


        // -- @When( "I go to the SHOP" )
        driver.findElement(By.cssSelector("li.my-shop a")).click();


        // -- @And( "I go to the Hoodie with logo detail page" )
        driver.findElement(By.xpath("//h2/a[contains(text(),'Hoodie with Logo')]")).click();


        // -- @And( "I add the Hoodie with lo to the cart" )
        driver.findElement(By.cssSelector("button[name='add-to-cart']")).click();


        // -- @Then( "I should get a confirmation that the product is added to the shopping cart" )
        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".woocommerce-message")));
        Assertions.assertTrue(driver.findElement(By.cssSelector(".woocommerce-message")).isDisplayed(),
                "Check if empty element is visible");

        // -- @But( "I should not be taken directly to my shopping cart" )
        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.button.checkout")));
        Assertions.assertTrue(driver.findElement(By.cssSelector("a.button.checkout")).isDisplayed(),
                "Check if the button to be taken to the checkout is shown");

        // quit driver / browser
        driver.quit();

    }
}
