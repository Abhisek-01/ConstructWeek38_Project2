Feature:  Feature to test Footware & Bags for women functionality

  @tag1
  Scenario: To validate the womenware functionality2
    Given Open browser, Enter the naptol url
    And Mause hover and navigate to Womensfootware
    And Navigate to persional serach section
    When Assert title for womens
    And Click on the women Product
    And Switch to tab1
    And proceed to checkout sandel
   Then Return to main tab page

   # Examples: 
   #   | name  | value | status  |
   #   | name1 |     5 | success |
   #   | name2 |     7 | Fail    |
