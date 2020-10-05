@alltopics

Feature: All Topic dashboard test

  Background: Open the Login page
    Given I open "projectURL"
    When I log in with valid email "live@live.com" and password "livelive"


  Scenario: Verifying All topics dashboard is visible
    Then I verify that All Topic dash is visible
    And I verify that All Topic dash is clickable


  Scenario Outline: verify AllTopics dashboard contain all questions
    When I click on Alltopics dashboard
    And I sendKey "<question>"
    When I click "search" button
    Then I verify that AllTopic dashboad contains "<question>"
    Examples:
      | question                                                        |
      | How to get a substring?                                         |
      | Give me an example of when you’ve successfully solved a problem |
      | What is Javascript?                                             |
      | Define iframe in HTML.                                          |
      | Explain what is Bootstrap?                                      |
      | What is the difference between JavaScript and jQuery?           |

  @notExist
  Scenario Outline: Verify AllTopis dashboard Doesn't contain fake Question
    When I click on Alltopics dashboard
    And I sendKey "<question>"
    When I click "search" button
    Then I verify that AllTopic dashboad does not contains "<question>"
    Examples:
      | question                    |
      | Who can make America great? |
      | How are you doing ?         |
      | What 333 455, 333?          |
      | 1234566788 1234567??        |
      | what is your name 342344?   |
      | What should we do?          |




