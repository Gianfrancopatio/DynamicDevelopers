@alltopics

Feature: All Topic dashboard test

  Background: Open the Login page
    Given I open login page
    When I log in with valid email "live@live.com" and password "livelive"


  Scenario: Verifying All topics dashboard is visible
    Then I verify that All Topic dash is visible
    And I verify that All Topic dash is clickable


  Scenario Outline: verify AllTopics dashboard contain all questions
    When user click on "<buttonname>" button
    And user capture questions from "<buttonname>"
    When user navigate to main page
    When user click on "All Topics" button
    Then user verify that AllTopic dashboard contains question
    Examples:
      | buttonname  |
      | Coding      |
      | Soft skills |
      | JavaScript  |
      | Html        |
      | Bootstrap   |
      | Jquery      |
      | NodeJS      |
      | MySQL       |
      | MongoDB     |
      | React       |
      | java        |
      | Python      |
      | CSS         |







