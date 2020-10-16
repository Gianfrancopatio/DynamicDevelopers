@dashboard

Feature: dashboard scenarios

  Background: User open login/registration page
    Given I open login page

  #Muneer
  #All Topics dashboard
  @allTopicDash
  Scenario: Verifying All topics dashboard is visible
    When user login as "user"
    Then I verify that "All Topics" dash is visible
    And I verify that "All Topics" dash is clickable

  #Muneer
  #All Topics dashboard
  @allTopicDash
  Scenario Outline: verify AllTopics dashboard contain all questions
    When user login as "user"
    When user click on "<buttonname>" button
    And user capture questions from "<buttonname>"
    When user navigate to main page
    When user click on "All Topics" button
    Then user verify that AllTopic dashboard contains questions from "<buttonname>"
    Examples:
      | buttonname  |
      | Soft skills |
      | JavaScript  |
      | NodeJS      |
      | MySQL       |
      | Python      |

    #Muneer
  #All Topics dashboard
  @allTopicDash
  Scenario: verify AllTopics dashboard contains new added question
    When user login as "user"
    When user click on "Coding" button
    And User clicks "Enter new question " button
    And User enters "Test question for TLA_6 story?" into the form
    And User clicks "Enter" button
    When user navigate to main page
    When user click on "All Topics" button
    Then user verify that AllTopic dashboard contains "Test question for TLA_6 story?" from "Coding"