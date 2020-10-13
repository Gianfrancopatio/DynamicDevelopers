@DashReview
Feature: Developer Preparation application tests

  Background: User open login/registration page
    Given I open login page
    When user provides valid Email
    And user provides valid password
    And  user click on signIn button


  @VerifyImage
  Scenario: Each dashboard will have it’s own name and image
    Then Verify each DashBoard contains own "topicName"
    Then Verify each DashBoard contains own "image

  @VerifyName
  Scenario: Each dashboard should not have same name
    Then Verify each DashBoard won't contain same topicname


  @CreateNewDashBoard
  Scenario: user have ability to create new ones.
    When  User create new dashboard name with "newtopicname"
    And   User click add button
    Then  Verify dashboard increase by one
    Then  Verify new dashboard has same name as as we created
    Then  Verify dashboard contains image

  @existingDashBoard
  Scenario: user is unable to create new dash board with existing name
    When  User create new dashboard name with "existingTopicName"
    And   User click add button
    Then  Verify the error message appeared as {existing TopicName} already exists






