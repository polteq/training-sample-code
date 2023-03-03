using OpenQA.Selenium;

namespace Polteq.Training.PracticalBDD.PageObjects
{
    public class HomePage : BasePage
    {
        private IWebElement MyAccountButton => driver.FindElement(By.CssSelector("li.my-account a"));
        private IWebElement ContactUs => driver.FindElement(By.CssSelector("li.contact-us a"));
        private IReadOnlyCollection<IWebElement> RecentPosts => driver.FindElements(By.CssSelector("section#recent-posts-2 li a"));

        public HomePage(IWebDriver driver) : base(driver) { }

        public void ClickMyAccount()
        {
            MyAccountButton.Click();
        }

        public void ClickContactUs()
        {
            ContactUs.Click();
        }

        /// <summary>
        /// Returns if a recent post with a title is present on the homepage
        /// </summary>
        /// <param name="expectedPostWithTitle">title to look for</param>
        /// <returns>True or false indicating if the recent post with expected title is present</returns>
        public bool IsRecentPostPresent(string expectedPostWithTitle)
        {
            var recentPostsText = new List<string>();
            foreach (IWebElement recentPost in RecentPosts)
            {
                recentPostsText.Add(recentPost.Text);
            }
            return recentPostsText.Contains(expectedPostWithTitle);
        }

    }
}
