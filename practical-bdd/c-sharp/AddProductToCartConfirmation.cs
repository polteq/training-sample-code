using NUnit.Framework;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Edge;
using OpenQA.Selenium.Support.UI;

namespace Polteq.Training.Practical.BDD.ProvidedTestCode
{
    [TestFixture]
    public class AddProductToCartConfirmation
    {
        private IWebDriver? driver;
        private WebDriverWait? myWaitVar;

        [Test]
        public void AddProductToCartConfirmationTest()
        {

            // -- [Given(@"I'm on the VGP Shop homepage")]

            // Create Edge driver
            //driver = new EdgeDriver();

            // Create Chrome driver
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.AddArgument("--no-sandbox");
            driver = new ChromeDriver(chromeOptions);

            driver.Manage().Window.Maximize();
            myWaitVar = new WebDriverWait(driver, TimeSpan.FromSeconds(10));

            // open the website
            driver.Url = "https://vgp-shop.polteq-testing.com/";

            // -- [When(@"I go to the SHOP")]
            driver.FindElement(By.CssSelector("li.my-shop a")).Click();


            // -- [When(@"I go to the Hoodie with logo detail page")]
            driver.FindElement(By.XPath("//h2/a[contains(text(),'Hoodie with Logo')]")).Click();


            // -- [When(@"I add the Hoodie with logo to the cart")]
            driver.FindElement(By.CssSelector("button[name='add-to-cart']")).Click();


            // -- [Then(@"I should get a confirmation that the product is added to the shopping cart")]
            var messageDisplayed = myWaitVar.Until(d => d.FindElement(By.CssSelector(".woocommerce-message")).Displayed);
            Assert.That(messageDisplayed, Is.True, "Check if empty element is visible");


            // -- [Then(@"I should not be taken directly to my shopping cart")]
            var buttonDisplayed = myWaitVar.Until(d => d.FindElement(By.CssSelector("a.button.checkout")).Displayed);
            Assert.That(buttonDisplayed, Is.True, "Check if the button to be taken to the checkout is shown");

            // Quit browser
            driver.Quit();

        }

    }
}
