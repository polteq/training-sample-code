# Glue Code Scenario Block Exercise

```csharp
        [When(@"I log in with valid credentials")]
        public void WhenILogInWithValidCredentials()
        {
            homePage.ClickMyAccount();
            var myAccountPage = new MyAccountPage(driver);
            myAccountPage.Login("email", "password");
        }

        [Then(@"I should see my username appear on top of the page")]
        public void ThenIShouldSeeMyUsernameAppearOnTopOfThePage()
        {
            var myAccountPage = new MyAccountPage(driver);
            Assert.IsTrue(
                myAccountPage.IsUsernameDisplayed("TesterAtPolteqTesting"),
                "username should be in welcome message");
        }
```
