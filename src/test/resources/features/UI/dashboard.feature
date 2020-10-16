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

    ##-------------------------Muneer-ended-------------------------------


#Pavel

@TLA9_Q&ASection
Scenario Outline: Verify each question has an answer section
When User logs in with valid email and password
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
When User logs in with valid email and password
And User navigates to "<topic>" page
And User clicks "Enter new question " button
And User enters "Test 321" into the form
And User clicks "Enter" button
And User clicks "Test 321" link
And User inputs "Testing Answer Count 1" into the form
And User clicks "Post Your Answer" button
And User inputs "Testing Answer Count 2" into the form
And User clicks "Post Your Answer" button
Then User verifies there is an Answer count for each Question
And User verifies the answer count is "2 Answers" for "Test 321"

Examples:
| topic       |
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

@Bug_AnswerCount
Scenario Outline: Empty answer input defect
When User logs in with valid email and password
And User navigates to "<topic>" page
And User clicks "Test 321" link
And User inputs "" into the form
And User clicks "Post Your Answer" button
And User inputs "" into the form
And User clicks "Post Your Answer" button
And User verifies the answer count is "2 Answers" for "Test 321"

Examples:
| topic       |
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

#_______________________________________________________//_______________________________________________

