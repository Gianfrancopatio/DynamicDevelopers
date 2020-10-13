@devPrep
Feature: Developer Preparation application tests
  Background: Open login/registration page
    Given User navigates to login page
    When User logs in with valid email and password
    And User navigates to All Topics

  @TLA9_Q&ASection
  Scenario: Verify each question has an answer section
    Then User verifies each question field is not empty
    And User verifies each question has an Answer section

  @TLA10_AnswerCount
  Scenario: Verify each question has a count of answers
    Then User verifies there is an Answer count for each question
    And User verifies Answer count corresponds to the actual count of answers under a question

