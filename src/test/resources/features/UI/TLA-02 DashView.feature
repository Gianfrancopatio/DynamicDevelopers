@DashReview
Feature: Developer Preparation application tests

  Background: User open login/registration page
    Given I open login page
    When user provides valid Email
    And user provides valid password
    And  user click on signIn button


  @VerifyImage
  Scenario: Each dashboard will have it’s own name and image
    Then  Verify each dashBoard contains own topic name
    Then  verify each dash board has image present


  @VerifyDupName
  Scenario: Each dashboard should not have same name
    Then Verify each DashBoard won't contain duplicate topicname

  @CreateNewDashBoard
  Scenario: user have ability to create new ones.
    When  User create new dashboard name with "newTopicName"
    And   User click add button
    Then  Verify new dashboard has same name as as we created
    Then  Verify dashboard contains image

  @existingDashBoard
  Scenario: user is unable to create new dash board with existing name
    When  User create new dashboard name with "existingtopicname"
    And   User click add button
    Then  Verify the error message appeared as existing TopicName already exists






