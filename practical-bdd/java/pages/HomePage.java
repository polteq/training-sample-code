package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    @FindBy(css = "li.my-account a")
    private WebElement myAccountButton;

    @FindBy(css = "li.contact-us a")
    private WebElement contactUs;


    @FindBys( { @FindBy(css = "section#recent-posts-2 li a") })
    private List<WebElement> recentPosts;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickMyAccount() {
        myAccountButton.click();
    }

    public void clickContactUs() {
        contactUs.click();
    }

    /**
     * Returns if a recent post with a title is present on the homepage
     * @param expectedPostWithTitle title to look for
     * @return True or false indicating if the recent post with expected title is present
     */
    public boolean isRecentPostPresent(String expectedPostWithTitle) {
        List<String> recentPostsText = new ArrayList<>();
        for (WebElement recentPost : recentPosts) {
            recentPostsText.add(recentPost.getText());
        }
        return recentPostsText.contains(expectedPostWithTitle);
    }
}
