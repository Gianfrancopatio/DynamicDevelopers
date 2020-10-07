@AddStatements
Feature:Do's and Dont's table Statements
  Background: Open DevPrepp site
    Given Starting Website
    When I log in with email "devDD@gmail.com" and password "dev5678"


  #@AddStatementsToTable
  Scenario: Verifying Do's new statement are added to the bottom of the table
    When I click on Add Do button
    Then I sendKeys "New Statements" and I verify it
    When I click enter button to enter new statement
    Then I verify that new statements appear at the bottom of the do table

  #Scenario: Verifying Dont's new statements are added to the bottom of the table
    When I click on Add Don't button
    Then I sendKey "Second Statements" and I verify it
    When I click enter button to enter
    Then I verify that new statements appear at the bottom of the don't table

