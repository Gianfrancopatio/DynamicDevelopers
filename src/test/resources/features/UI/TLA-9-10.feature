@devPrep
Feature: Developer Preparation application tests

  Background: Open login/registration page
    Given User navigates to login page
    When User logs in with valid email and password

  @TLA9_Q&ASection
  Scenario Outline: Verify each question has an answer section
    And User navigates to "<topic>" page
    Then User verifies each question field is not empty
    And User verifies each question has an Answer section

    Examples:
      | topic       |
      | All Topics  |
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


  @TLA10_AnswerCount
  Scenario Outline: Verify each question has a correct Answer Count
    And User navigates to "<topic>" page
    And User clicks "Enter new question " button
    And User enters "Test Pavel Z" into the form
    And User clicks "Enter" button
    And User clicks "Test Pavel Z" link
    And User inputs "Testing Answer Count 1" into the form
    And User clicks "Post Your Answer" button
    And User inputs "Testing Answer Count 2" into the form
    And User clicks "Post Your Answer" button
    Then User verifies there is an Answer count for each Question
    And User verifies Answer count corresponds to the actual count of answers under a question

    Examples:
      | topic       |
      | All Topics  |
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


