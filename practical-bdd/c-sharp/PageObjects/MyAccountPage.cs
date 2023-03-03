using OpenQA.Selenium;

namespace Polteq.Training.PracticalBDD.PageObjects
{
    public class MyAccountPage : BasePage
    {
        private IWebElement EmailTextfield => driver.FindElement(By.CssSelector("input#username"));
        private IWebElement PasswordTextfield => driver.FindElement(By.CssSelector("input#password"));
        private IWebElement LoginButton => driver.FindElement(By.CssSelector("[name='login']"));
        private IWebElement RegistrationUsername => driver.FindElement(By.Id("reg_username"));
        private IWebElement NewUserMail => driver.FindElement(By.Id("reg_email"));
        private IWebElement NewPassword => driver.FindElement(By.Id("reg_password"));
        private IWebElement CreateNewUserButton => driver.FindElement(By.CssSelector("button[name='register']"));
        private IWebElement ErrorMessage => driver.FindElement(By.CssSelector("div.woocommerce-notices-wrapper ul.woocommerce-error"));
        private IWebElement MyAccountContent => driver.FindElement(By.CssSelector("div.woocommerce-MyAccount-content"));

        public MyAccountPage(IWebDriver driver) : base(driver) { }

        public bool IsErrorMessageDisplayed()
        {
            return ErrorMessage.Displayed;
        }

        public bool IsMyAccountContentDisplayed()
        {
            return MyAccountContent.Displayed;
        }

        public bool IsUsernameDisplayed(string username)
        {
            return MyAccountContent.Text.Contains(username);
        }

        public void Login(string email, string password)
        {
            EmailTextfield.SendKeys(email);
            PasswordTextfield.SendKeys(password);
            LoginButton.Click();
        }

        public void RegisterNewUser(string username, string emailAddress, string password)
        {
            RegistrationUsername.SendKeys(username);
            NewUserMail.SendKeys(emailAddress);
            NewPassword.SendKeys(password);
            CreateNewUserButton.Click();
        }
    }
}
