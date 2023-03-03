package providedtestcode;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddProductToCartConfirmation {

    private WebDriver driver;
    private WebDriverWait myWaitVar;

    @Test
    public void AddProductToCartConfirmationTest() {

        // -- @Given( "I'm on the VGP Shop homepage" )
        // Create driver
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
        myWaitVar = new WebDriverWait(driver, 20);

        // Open the website
        driver.get("https://vgp-shop.polteq-testing.com/");
        driver.manage().window().maximize();


        // -- @When( "I go to the SHOP" )
        driver.findElement(By.cssSelector("li.my-shop a")).click();


        // -- @And( "I go to the Hoodie with logo detail page" )
        driver.findElement(By.xpath("//h2/a[contains(text(),'Hoodie with Logo')]")).click();


        // -- @And( "I add the Hoodie with lo to the cart" )
        driver.findElement(By.cssSelector("button[name='add-to-cart']")).click();


        // -- @Then( "I should get a confirmation that the product is added to the shopping cart" )
        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".woocommerce-message")));
        Assert.assertTrue("Check if empty element is visible",
                driver.findElement(By.cssSelector(".woocommerce-message")).isDisplayed());


        // -- @But( "I should not be taken directly to my shopping cart" )
        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.button.checkout")));
        Assert.assertTrue("Check if the button to be taken to the checkout is shown",
                driver.findElement(By.cssSelector("a.button.checkout")).isDisplayed());
        driver.quit();

    }

}
