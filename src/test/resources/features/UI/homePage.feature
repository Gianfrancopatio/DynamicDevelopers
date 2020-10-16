@homePage

Feature: Homepage scenarios
  Background: User open login/registration page
    Given I open login page



  #Best
  @DashReview @VerifyImageandName
  Scenario: Each dashboard will have it’s own name and image
    When user login as "admin"
    Then  Verify each dashBoard contains own topic name
    Then  verify each dash board has image present

  @DashReview @VerifyDupName

  Scenario: Each dashboard should not have same name
    When user login as "admin"
    Then Verify each DashBoard won't contain duplicate topicname

  @DashReview @CreateNewDashBoard
  Scenario: user have ability to create new ones.
    When user login as "admin"
    When  User create new dashboard name with "newTopicName"
    And   user click on "+ Add" button
    Then  Verify new dashboard has same name as as we created
    Then  Verify dashboard contains image

  @DashReview @existingDashBoard
  Scenario: user is unable to create new dash board with existing name
    When user login as "admin"
    Then  Verify the error message appeared as existing TopicName already exists















  