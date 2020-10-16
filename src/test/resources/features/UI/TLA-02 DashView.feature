@DashReview
Feature: Developer Preparation application tests

  Background: User open login/registration page
    Given I open login page


  #Best
  @VerifyImageandName
    Scenario: Each dashboard will have it’s own name and image
    When user provides valid "admin" Email and password
    And  user click on "Sign in" button
    Then  Verify each dashBoard contains own topic name
    Then  verify each dash board has image present



  @CreateNewDashBoard
  Scenario: user have ability to create new ones.
    When  User create new dashboard name with "newTopicName"
    And   user click on "+ Add" button
    Then  Verify new dashboard has same name as as we created
    Then  Verify dashboard contains image

  @existingDashBoard
  Scenario: user is unable to create new dash board with existing name

    Then  Verify the error message appeared as existing TopicName already exists











