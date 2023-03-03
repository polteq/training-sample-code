package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    @FindBy(css = "input#username")
    private WebElement emailTextfield;

    @FindBy(css = "input#password")
    private WebElement passwordTextfield;

    @FindBy(css = "[name='login']")
    private WebElement loginButton;

    @FindBy(id = "reg_username")
    private WebElement registrationUsername;

    @FindBy(id = "reg_email")
    private WebElement newUserMail;

    @FindBy(id = "reg_password")
    private WebElement newPassword;

    @FindBy(css = "button[name='register']")
    private WebElement createNewUserButton;

    @FindBy(css = "div.woocommerce-notices-wrapper ul.woocommerce-error")
    private WebElement errorMessage;

    @FindBy(css = "div.woocommerce-MyAccount-content")
    private WebElement myAccountContent;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isErrorMessageDisplayed(){
        return errorMessage.isDisplayed();
    }

    public boolean isMyAccountContentDisplayed(){
        return myAccountContent.isDisplayed();
    }

    public boolean isUsernameDisplayed(String username) {
        return myAccountContent.getText().contains(username);
    }

    public void login(String email, String password) {
        emailTextfield.sendKeys(email);
        passwordTextfield.sendKeys(password);
        loginButton.click();
    }

    public void registerNewUser(String username, String emailAddress, String password){
        registrationUsername.sendKeys(username);
        newUserMail.sendKeys(emailAddress);
        newPassword.sendKeys(password);
        createNewUserButton.click();
    }

}
