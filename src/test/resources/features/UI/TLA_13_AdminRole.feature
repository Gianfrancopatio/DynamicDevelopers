@adminRole

Feature: AdminRole Test

  Background: Open the logIn page
    Given I open login page
    When I log in with valid email "admin@gmail.com" and password "admin123"

    Scenario Outline: Verify three main dashboard is not deletable
      Then I verify dashboard "<dashboard>" doesn't have delete option
      Examples:
      |dashboard|
      |All Topics|
      |Coding    |
      |Soft skills|





  @deleteDash
  Scenario: Admin should be able to delete dashboards
    When  User create new dashboard name with "admintest"
    And   user click on "+ Add" button
    When I delete a "admintest"
    Then I verify Pop up warning message displayed
    And I verify Pup up waring message contain number of question is "0"
    When user click on "Delete" button
    Then I verify dashboard "deleted"

  @NotDeleteDash
  Scenario: Admin should be able to delete dashboard contain question
    When  User create new dashboard name with "admintest"
    And   user click on "+ Add" button
    And   user click on "admintest" button
    And user click on "Enter new question " button
    And User enters "admin role test question?" into the form
    And User clicks "Enter" button
    When user navigate to main page
    When I delete a "admintest"
    And I verify Pup up waring message contain number of question is "1"
    When user click on "Cancel" button
    Then I verify dashboard "not deleted"
    When I delete a "admintest"
    When user click on "Delete" button


  Scenario: Adding new dashboard only available for admin

#    And I log out
#    When I log in with valid email "live@live.com" and password "livelive"
#    Then I verify new "dashboard" created



