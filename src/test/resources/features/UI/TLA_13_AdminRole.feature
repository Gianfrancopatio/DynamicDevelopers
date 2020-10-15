@adminRole

  Feature: AdminRole Test
    Background: Open the logIn page
      Given I open login page
      When I log in with valid email "admin@gmail.com" and password "admin123"

    Scenario: Admin should see delete option for dashboards
      Then I verify delete button is visible
      Then user signs out by pressing welcome button
      When I log in with valid email "live@live.com" and password "livelive"
      Then I verify that delete button in not visible


#  Scenario: Admin should be able to delete dashboards
#     When I create an new "dashboard"
#      Then I verify new "dashboard" created
#    When I delete a "dashboard"
#    Then I verify dashboard deleted
#    And I log out
#    When I log in with valid email "live@live.com" and password "livelive"
#    Then I verify that deleted dashboard is not displayed
#
#    Scenario: Verify popUp warning message on deleting dashboards
#      When I create an new "dashboard"
#      When I delete a "dashboard"
#      Then I verify Pop up warning message displayed
#      And I verify Pup up waring message contain number of question
#      When user click on "Delete" button
#      Then I verify that deleted dashboard is not displayed
#
#    Scenario: Verify popUp warning message on deleting dashboards
#      When I create an new "dashboard"
#      When I delete a "dashboard"
#      Then I verify Pop up warning message displayed
#      And I verify Pup up waring message contain number of question
#      When user click on "Cancel" button
#      Then I verify that deleted dashboard is displayed
#
#  Scenario: Admin should be able to add new dashboard
#      When I create an new "dashboard"
#    Then I verify new "dashboard" created
#    And I log out
#    When I log in with valid email "live@live.com" and password "livelive"
#    Then I verify new "dashboard" created



