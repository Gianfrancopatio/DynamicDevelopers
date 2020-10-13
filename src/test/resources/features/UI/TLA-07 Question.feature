@createQuestion
Feature: TL7 story case
  Background: Open login/registration page
    Given User navigates to login page
    When User log in with valid email and password


  @TLA_07Question
  Scenario: Verify question option works
    And User can navigate to Coding Dashboard
    Then User clicks on yellow icon
    Then User can input NEW questions under yellow icon
    Then User can type question "What is coding?"
    When User click enter for question
    And Time stamp is verified