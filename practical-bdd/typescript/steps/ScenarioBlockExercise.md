# Glue Code Scenario Block Exercise

```typescript
When('I log in with valid credentials', async ({ homePage, myAccountPage }) => {
  await homePage.clickMyAccount();
  await myAccountPage.login("tester@polteq-testing.com", "1!QazXsw2@");
});

Then('I should see my username appear on top of the page', async ({ myAccountPage }) => {
  const isUsernameDisplayed = await myAccountPage.isUsernameDisplayed("TesterAtPolteqTesting");
  expect(isUsernameDisplayed).toBe(true);
} );
```
