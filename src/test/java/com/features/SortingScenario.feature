Feature: Testing sorting

  Background:
    Given the user opens shop's main page in "chrome"

  @Sorting
  Scenario Outline: Sorting scenario
    Given the user opens "<product_type>" products
    When the user sorts products by "<sorting_type>"
    Then the products should be sorted correctly
    Examples:
      | product_type       | sorting_type |
      | electro_cars       | price:asc    |
      | xiaomi_smart_watch | name:asc     |
      | tent               | price:desc   |
