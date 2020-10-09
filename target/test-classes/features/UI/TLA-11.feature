@likebutton
  Feature: LikeButton Test

    Background: Open the Login page
      Given I open "projectURL"
      When I log in with valid email "live@live.com" and password "livelive"


    Scenario: Verify that Like Button is displayed on every question
      When I click "all topics dashboard"
      Then I verify Like Button is displayed
      And I verify Like Button is clickable


      Scenario: Verify the number of likes is changing
        When I click "dashboard"
        Then I verify that numbers are changing


