Feature: Cart manipulation

  Background:
    Given the user opens shop's main page in "firefox"
    And the user opens "tent" products

  @Cart @AddProduct
  Scenario:Adding product to cart scenario
    When the user click buy some product
    And the user opens cart
    Then the product is in the cart


  @Cart @DeleteProduct
  Scenario: Delete product from the cart
    When the user click buy some product
    And the user opens cart
    And the user remove product from cart
    Then the cart should be empty


