@alltopics

Feature: All Topic dashboard test

  Background: Open the Login page
    Given I open "URL"
    When I log in with valid email "live@live.com" and password "livelive"


  Scenario: Verifying All topics dashboard is visible
    Then I verify that All Topic dash is visible
    And I verify that All Topic dash is clickable


  Scenario Outline: verify AllTopics dashboard contain all questions
    When I click on Alltopics dashboard
    And I sendKey "<question>" from "<dashboard>"
    When I click "search" button
    Then I verify that AllTopic dashboad contains "question"
    Examples:
      | question                                                        |  | dashboard   |
      | How to get a substring?                                         |  | Coding      |
      | Give me an example of when you’ve successfully solved a problem |  | Soft skills |
      | What is Javascript?                                             |  | JavaScript  |
      | Define iframe in HTML.                                          |  | HTML        |
      | Explain what is Bootstrap?                                      |  | BootStrap   |
      | What is the difference between JavaScript and jQuery?           |  | JQuery      |


  Scenario: Verify AllTopis dashboard Doesn't contain fake Question
    When I click on Alltopics dashboard
    And I sendKey "question" from "random"
    When I click "search" button
    Then I verify that AllTopic dashboad does not contains "question"




