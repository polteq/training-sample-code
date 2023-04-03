package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactPage extends BasePage {

    @FindBy(css = "input[name='your-stay-location'][value='Ja']")
    private WebElement stayLocationJa;

    @FindBy(css = "input[name='your-stay-location'][value='Nee']")
    private WebElement stayLocationNee;

    @FindBy(css = "input[name='your-name']")
    private WebElement name;

    @FindBy(css = "input[name='your-email']")
    private WebElement email;

    @FindBy(css = "input[name='your-subject']")
    private WebElement subject;

    @FindBy(css = "textarea[name='your-message']")
    private WebElement message;

    @FindBy(css = "select#your-department")
    private WebElement department;

    @FindBy(css = "input#send-button")
    private WebElement sendButton;

    private final String messageSentIndicatorLocator = "div.wpcf7-response-output";

    @FindBy(css = messageSentIndicatorLocator)
    private WebElement messageSentIndicator;

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public void sendContactMessage (
            String stayAtPark,
            String name,
            String email,
            String subject,
            String message,
            String department
    ) {
        selectStayAtPark(stayAtPark);
        this.name.sendKeys(name);
        this.email.sendKeys(email);
        this.subject.sendKeys(subject);
        this.message.sendKeys(message);
        selectDepartment(department);
        sendButton.click();
    }

    public boolean isMessageSent() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(messageSentIndicatorLocator)));
        return messageSentIndicator.isDisplayed();
    }

    private void selectStayAtPark(String stayAtPark) {

        switch (stayAtPark.toLowerCase()) {
            case "ja":
                stayLocationJa.click();
                break;
            case "nee":
                stayLocationNee.click();
                break;
            default:
                Assert.fail("invalid stay at park value " + stayAtPark);
        }
    }

    private void selectDepartment(String department) {
        Select selectDepartment = new Select(this.department);
        selectDepartment.selectByValue(department);
    }

}
