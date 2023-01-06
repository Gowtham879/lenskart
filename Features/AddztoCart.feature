Feature: Lenskart Add to Cart

  Scenario Outline: User add the product to cart and verifies it
    Given The User has launched Leanskart Application
    When The User select the product "<category>" from "<subCategory>" from "<mainCategory>"
    And The User applies the filters
      | Filter    | Filtervalue    |
      | <Filter1> | <Filtervalue1> |
      | <Filter2> | <Filtervalue2> |
    And Select item "<Product>" and click on Add to Cart
    Then User verifies the cart using "<Product>" text
    Examples:
      |mainCategory       | subCategory | category              | Filter1          | Filtervalue1 | Filter2     | Filtervalue2 | Product            |
      |COMPUTER GLASSES   |women        |women                  |FRAME SHAPE       |Square        |FRAME COLOR  |Blue(14)      |Lenskart Blu        |