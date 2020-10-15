@adminRole

Feature: AdminRole Test

  Background: Open the logIn page
    Given I open login page
    When I log in with valid email "admin@gmail.com" and password "admin123"

    @deleteDash
  Scenario: Admin should be able to delete dashboards
    When  User create new dashboard name with "newTopicName"
    And   user click on "+ Add" button
    When I delete a "newTopicName"
    Then I verify Pop up warning message displayed
    And I verify Pup up waring message contain number of question is "0"
    When user click on "Delete" button
    Then I verify dashboard "deleted"

  @deleteDash
  Scenario: Admin should be able to delete dashboards
    When  User create new dashboard name with "newTopicName"
    And   user click on "+ Add" button
    When I delete a "newTopicName"
    Then I verify Pop up warning message displayed
    And I verify Pup up waring message contain number of question is "0"
    When user click on "Cancel" button
    Then I verify dashboard "not deleted"


#  Scenario: Adding new dashboard only available for admin
#      When I create an new "dashboard"
#    Then I verify new "dashboard" created
#    And I log out
#    When I log in with valid email "live@live.com" and password "livelive"
#    Then I verify new "dashboard" created



