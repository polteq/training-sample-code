package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract class BasePage {

    WebDriver driver;

    BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

}
