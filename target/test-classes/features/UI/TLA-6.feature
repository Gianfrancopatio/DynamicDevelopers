@alltopics

  Feature: All Topic dashboard test
    Background: Open the Login page using
      Given I open "URL"
      When I log in with valid email "live@live.com" and password "livelive"



    Scenario: Verifying All topics dashboard is visible
      Then I verify that All Topic dash is visible
      And I verify that All Topic dash is clickable
#
#
#    Scenario Outline: verify AllTopics dashboard contain all questions
#      When I click on Alltopics dashboard
#      And I sendKey "question" from "<dashboard>"
#      When I click "search" button
#      Then I verify that AllTopic dashboad contains "question"
#      Examples:
#      |dashboard|
#      |Coding   |
#      |Soft skills|
#      |JavaScript |
#      |HTML       |
#      |BootStrap  |
#      |JQuery     |
#
#
#
#    Scenario: Verify AllTopis dashboard Doesn't contain fake Question
#      When I click on Alltopics dashboard
#      And I sendKey "question" from "random"
#      When I click "search" button
#      Then I verify that AllTopic dashboad does not contains "question"





