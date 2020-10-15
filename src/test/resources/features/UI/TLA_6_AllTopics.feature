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
    Then user verify that AllTopic dashboard contains questions from "<buttonname>"
    Examples:
      | buttonname  |
      | Soft skills |
      | JavaScript  |
      | NodeJS      |
      | MySQL       |
      | Python      |

  Scenario: verify AllTopics dashboard contains new added question
    And User navigates to "Coding" page
    And User clicks "Enter new question " button
    And User enters "Test question for TLA_6 story?" into the form
    And User clicks "Enter" button
    When user navigate to main page
    When user click on "All Topics" button
    Then user verify that AllTopic dashboard contains "Test question for TLA_6 story?" from "Coding"






