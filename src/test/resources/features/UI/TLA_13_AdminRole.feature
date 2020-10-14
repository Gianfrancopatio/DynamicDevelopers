@adminRole

  Feature: AdminRole Test
    Background: Open the logIn page
      Given I open login page
      When I log in with valid email "admin@gmail.com" and password "admin123"


#  Scenario: Admin should be able to hide dashboard
#    Given I verify hide button is working properly
#    When I hide a dashboard
#    And I log out as AdminRole
#    When I log in with valid email "live@live.com" and password "livelive"
#    Then I verify that hidden dashboard is not displayed
#
#  Scenario: Admin should be able to delete dashboard
#    Given I verify delete button is working properly
#    When I delete a dashboard
#    And I log out as AdminRole
#    When I log in with valid email "live@live.com" and password "livelive"
#    Then I verify that deleted dashboard is not displayed
#
#
#  Scenario: Admin should be able to disable adding new dashboard option
#    When I click disable button
#    Then I verify disable button is working properly
#    When I disable the adding new dashboard option
#    And I log out as AdminRole
#    When I log in with valid email "live@live.com" and password "livelive"
#    Then I verify that adding new dashboard option is not displayed
#
#  Scenario: Admin should be able to enable adding  new dashboard option
#    When I click enable button
#    Then I verify enable button is working properly
#    When I enable the adding new dashboard option
#    And I log out as AdminRole
#    When I log in with valid email "live@live.com" and password "livelive"
#    Then I verify that adding new dashboard option is displayed
#
#  Scenario: Verify popUp warning message on deleting dashboards with more then 10 questions
#    Given I verify that dashboard contain more than 10 questions
#    When I delete dashboard with more then 10 question
#    Then I verify popUp warning message

