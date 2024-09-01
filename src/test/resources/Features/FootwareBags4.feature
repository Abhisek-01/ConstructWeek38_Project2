 Feature:  Feature to test Footware & Bags for TravelUtilityBag functionality
  @tag1
  Scenario: To validate the womenware functionality4
    Given Open browser, Enter the naptol_url
    And Mause hover and navigate to TravelUtilityBag
    And Navigate to persional feature
    When Assert title for TravelUtilityBag
    And Click on the TravelUtilityBag Product
    And Switch to subtab1
    And proceed to checkout Bag
   Then Return to home-main page

		Given Mause hover and navigate to TravelUtilityBag1
    And Navigate to persional feature1
    When Assert title for TravelUtilityBag1
    And Click on the TravelUtilityBag Product1
    And Switch to subtab2
    And proceed to checkout Bag1
   Then Return to home-main page1
