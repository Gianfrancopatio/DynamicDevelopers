@devPrep
Feature: Developer Preparation application tests

  Background: Open login/registration page
    Given I navigate to login page


  @TLA9_Q&ASection
  Scenario: Verify each question has an answer section
    When I log in with valid email and password
    And I navigate to All Topics
    Then I verify each question contains a Question
    And I verify each question has an Answer section

  @TLA10_AnswerCount
  Scenario: Verify each question has a count of answers
    When I log in with valid email and password
    And I navigate to All Topics
    Then I verify there is an Answer count for each question