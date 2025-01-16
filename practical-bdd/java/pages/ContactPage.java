package pages;

import org.junit.jupiter.api.Assertions;
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

    private final String messageSentIndicatorLocator = "form.sent div.wpcf7-response-output";

    @FindBy(css = messageSentIndicatorLocator)
    private WebElement messageSentIndicator;

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Sends a contact message by filling out the form and clicking the send button.
     *
     * @param stayAtPark the stay location value, either "ja" or "nee"
     * @param name the name of the sender
     * @param email the email address of the sender
     * @param subject the subject of the message
     * @param message the content of the message
     * @param department the department to which the message is sent
     */
    public void sendContactMessage(
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

    /**
     * Checks if the contact message was sent successfully by verifying the visibility of the message sent indicator.
     *
     * @return true if the message sent indicator is displayed, false otherwise
     */
    public boolean isMessageSent() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(messageSentIndicatorLocator)));
        return messageSentIndicator.isDisplayed();
    }

    private void selectStayAtPark(String stayAtPark) {

        switch (stayAtPark.toLowerCase()) {
            case "ja" -> stayLocationJa.click();
            case "nee" -> stayLocationNee.click();
            default -> Assertions.fail("invalid stay at park value " + stayAtPark);
        }
    }

    private void selectDepartment(String department) {
        Select selectDepartment = new Select(this.department);
        selectDepartment.selectByValue(department);
    }

}
