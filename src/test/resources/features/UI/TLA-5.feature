@AddStatements
Feature:Do's and Dont's table Statements
  Background: Open DevPrepp site
    Given Using "https://devprepp.herokuapp.com/"
    When I log in with email "cristinacoronado68@gmail.com" and password "Cava2020!"


  @AddStatementsToTable
  Scenario: Verifying Do's new statement are added to the bottom of the table
    When I click on Add Do button
    Then I sendKey "New Statements" and I verify it

  Scenario: Verifying Dont's new statements are added to the bottom of the table
    When I click on Add Don't button
    Then I sendKey "Second Statements" and I verify it

