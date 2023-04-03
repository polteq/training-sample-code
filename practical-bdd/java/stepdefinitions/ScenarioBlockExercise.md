# Glue Code Scenario Block Exercise

```java
    @When("I log in with valid credentials")
    public void iLogInWithValidCredentials() {
        homePage.clickMyAccount();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.login("email", "password");
    }

    @Then("I should see my username appear on top of the page")
    public void iShouldSeeMyUserNameAppearOnTopOfThePage() {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Assert.assertTrue(
                "username should be in welcome message",
                myAccountPage.isUsernameDisplayed("TesterAtPolteqTesting"));
    }
```