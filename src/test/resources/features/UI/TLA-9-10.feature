@devPrep
Feature: Developer Preparation application tests
  Background: Open login/registration page
    Given I navigate to login page
    When I log in with valid email and password


  @TLA9_Q&ASection
  Scenario: Verify each question has an answer section
    And I navigate to All Topics
    Then I verify each question contains a Question
    And I verify each question has an Answer section

  @TLA10_AnswerCount
  Scenario: Verify each question has a count of answers
    And I navigate to All Topics
    Then I verify there is an Answer count for each question
    And I verify Answer count corresponds to the actual count of answers under a question

