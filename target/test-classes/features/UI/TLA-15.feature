@doAndDontsTable

  Feature:Do's and Dont's table test
    Background: User open login/registration page
      Given I open website
     When I log on with email "devDD@gmail.com" and password "dev5678"

<<<<<<< HEAD
    @doDontTable
=======
   #@doDontTable
>>>>>>> 0dbe557346a0bf2a1077fd262268d6349eaf65e9
    Scenario: Verifying tables DO's and Dont's table exist
      Then I verify Do's table exists
      And I verify Dont's table exists




