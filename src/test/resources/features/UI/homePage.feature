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
  #Best
  @DashReview @VerifyDupName
  Scenario: Each dashboard should not have same name
    When user login as "admin"
    Then Verify each DashBoard won't contain duplicate topicname
  #Best
  @DashReview @CreateNewDashBoard
  Scenario: user have ability to create new ones.
    When user login as "admin"
    When  User create new dashboard name with "newTopicName"
    And   user click on "+ Add" button
    Then  Verify new dashboard has same name as as we created
    Then  Verify dashboard contains image
  #Best
  @DashReview @existingDashBoard
  Scenario: user is unable to create new dash board with existing name
    When user login as "admin"
    Then  Verify the error message appeared as existing TopicName already exists

    ##----------------------Muneer-started--------------------------
  #Muneer
  #deleteOptionAsAmin
  @deleteTest @dashNotDeletable
  Scenario Outline: Verify three main dashboard is not deletable
    When user login as "admin"
    Then I verify dashboard "<dashboard>" doesn't have delete option
    Examples:
      | dashboard   |
      | All Topics  |
      | Coding      |
      | Soft skills |

  #Muneer
  #deleteOptionAsAmin
  @deleteTest @deleteExistingDash
  Scenario Outline: Verify delete option on existing dashboards
    When user login as "admin"
    When user click on "<dashboard>" button
    And user get number of questions
    When user navigate to main page
    When I delete a "<dashboard>"
    Then I verify Pop up warning message displayed
    Then I verify Pop up warning message contains "<dashboard>" and number of questions
    When user click on "Cancel" button
    Then I verify dashboard "not deleted"
    Examples:
      | dashboard |
      | CSS       |
      | MongoDB   |
      | NodeJS    |

  #Muneer
  #deleteOptionAsAmin
  @deleteTest @deleteDash
  Scenario: Admin should be able to delete dashboards
    When user login as "admin"
    When  User create new dashboard name with "admintest"
    And   user click on "+ Add" button
    When I delete a "admintest"
    Then I verify Pop up warning message displayed
    And I verify Pup up waring message contain number of question is "0"
    When user click on "Delete" button
    Then I verify dashboard "deleted"

  #Muneer
  #deleteOptionAsAmin
  @deleteTest @NotDeleteDash
  Scenario: Admin should be able to delete dashboard contain question
    When user login as "admin"
    When User create new dashboard name with "admintest"
    And user click on "+ Add" button
    And user click on "admintest" button
    And user click on "Enter new question " button
    And User enters "admin role test question?" into the form
    And User clicks "Enter" button
    When user navigate to main page
    When I delete a "admintest"
    And I verify Pup up waring message contain number of question is "1"
    When user click on "Cancel" button
    Then I verify dashboard "not deleted"
    When I delete a "admintest"
    When user click on "Delete" button

#Muneer
  #deleteOptionAsAmin
  @deleteTest @addNewDash
  Scenario: Adding new dashboard only available for admin
    When user login as "admin"
    Then I verify adding "New dashboard" is visible only for admin
    When I log out
    When user login as "user"
    Then I verify adding "New dashboard" is not visible for user

    ##------------------------Muneer-ended-----------------------------















  