# Glue Code Scenario Block Exercise

## Java code
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
        Assertions.assertTrue(
                myAccountPage.isUsernameDisplayed("TesterAtPolteqTesting"),
                "username should be in welcome message");
    }
```

## C# code
```csharp
  // TODO
```
