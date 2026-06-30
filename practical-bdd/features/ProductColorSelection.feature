Feature: Product color selection
  As a user of the webshop
  I want to be able to select the product color
  So that I can add the correct color to my order

  Scenario: Selected color will be shown in the confirmation
    Given I'm on the VGP Shop homepage
    When I go to the SHOP
    And I go to the Hoodie with logo detail page
    When I change the color of the product to Red
    And I add the product to the cart
    Then I should get a confirmation that the product is added to the shopping cart
    And the confirmation should show that the selected color is Red

  Scenario Outline: Selecting a color will change the product image to selected color
    Given I'm on the VGP Shop homepage
    When I go to the SHOP
    And I go to the Hoodie with logo detail page
    When I change the color of the product to "<color>"
    Then the product image will change to the color "<color>"

    Examples:
      | color |
      | Blue  |
      | Gray  |
      | Green |
      | Red   |
