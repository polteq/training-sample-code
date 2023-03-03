using OpenQA.Selenium;
using OpenQA.Selenium.Support.UI;

namespace Polteq.Training.PracticalBDD.PageObjects
{
    public abstract class BasePage
    {
        protected IWebDriver driver;
        protected WebDriverWait wait;

        public BasePage(IWebDriver driver)
        {
            this.driver = driver;
            wait = new WebDriverWait(this.driver, TimeSpan.FromSeconds(10));
        }
    }
}
