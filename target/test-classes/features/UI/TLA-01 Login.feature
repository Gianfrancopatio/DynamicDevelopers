@LogInPage
Feature: Developer Preparation application tests

  Background: User open login/registration page
    Given I open login page

  @VerifyFields
  Scenario: Verify logIn/Sign up fields are existed on the LogIn page
    Then verify "emailfield"  exists
    And  verify "passwordfield"  exists
    And  verify "signInButton"  exists
    When user click create new account
    Then verify "namefield"  exists
    And  verify "confirmpasswordfield"  exists


  @SignUpPositive
  Scenario: Verify user is able to sing up a new account
    When user click create new account
    And user provides following data with random name and email
      | password        | dd12345 |
      | confirmpassword | dd12345 |
    And  user click on signup button
    Then  verify message Successfully signed up! is up

  @SignUpWexistingName
  Scenario: Verify user is unable to sing up with existing name
    When user click create new account
    And user provides following data
      | name            | Best                |
                          ##existingName
      | email           | kk.best59@gmail.com |
      | password        | Best56780           |
      | confirmpassword | Best56780           |
    And  user click on signup button
    Then  verify message The user already exists is up


  @SignUpWexistingEmail
  Scenario: Verify user is unable to sing up with existing email
    When user click create new account
    And user provides following data
      | name            | kala                |
      | email           | kk.best59@gmail.com |
                          ##existingEmail
      | password        | Best56780           |
      | confirmpassword | Best56780           |
    And  user click on signup button
    Then  verify message The user already exists is up

  @passwordSighUpInvalid
  Scenario: verify error msg is up when user provide password less than 6 digits
    When user click create new account
    And user provides following data
      | name            | newDD45           |
      | email           | newDD45@gmail.com |
      | password        | dd123             |
                          ##password is less than 6
      | confirmpassword | dd123             |
    And  user click on signup button
    Then  verify the error message is up as Password must be at least six characters in length.

  @InvalidEmailFormat
  Scenario Outline: verify error msg is up when user fill Invalid password Format
    When user click create new account
    And user provides "<name>" "<email>" "<password>" "<confirmPassword>"
    And  user click on signup button
    Then  verify the error message is up as Invalid email format
    Examples:
      | name          | email                        | password | confirmPassword |
      | emailinvalid1 | emailinvalid1                | dd12356  | dd12356         |
      | emailinvalid2 | emailinvalid2 test@gmail.com | dd12356  | dd12356         |
      | emailinvalid3 | emailinvalid3@gmail          | dd12356  | dd12356         |
      | emailinvalid4 | emailinvalid4.com            | dd12356  | dd12356         |
      | emailinvalid5 | emailinvalid5@.com           | dd12356  | dd12356         |

  @unmatchconfirmpassword
  Scenario: verify error msg appeared when user provide unmatch confirm gitpassword to sign up
    When user click create new account
    And user provides following data
      | name            | newDD5           |
      | email           | newDD5@gmail.com |
      | password        | dd12356          |
      | confirmpassword | dd12567          |
                         #unmatch confirmpassword
    And  user click on signup button
    Then  verify message The passwords did not match is up

  @blankfield
  Scenario Outline: verify sign up button is not enable if some of the fields is blank
    When user click create new account
    And user provides "<name>" "<email>" "<password>" "<confirmPassword>"
    Then  verify sign up button is not enable
    Examples:
      | name | email            | password | confirmPassword |
      |      | newDD5@gmail.com | dd12356  | dd12356         |
      | dd   |                  | dd12356  | dd12356         |
      | dd   | newDD5@gmail.com |          | dd12356         |
      | dd   | newDD5@gmail.com | dd12356  |                 |

  @ValidSignIn
  Scenario: user is able to sign in with valid account
    When user provides valid Email
    And user provides valid password
    And  user click on signIn button
    Then  verify user on DevPrepp page

  @inValidEmail
  Scenario: user is not able to sign in with invalid Email
    When user provides invalid Email
    And user provides valid password
    And  user click on signIn button
    Then  verify the error message is up as invalid credentials

  @inValidPassword
  Scenario: user is not able to sign in with invalid password
    When user provides valid Email
    And user provides invalid password
    And  user click on signIn button
    Then  verify the error message is up as invalid credentials



