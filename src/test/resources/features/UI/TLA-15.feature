

@doAndDontsTable

  Feature:Do's and Dont's table test
    Background: User open login/registration page
      Given I open login page
      When I log on with email "devDD@gmail.com" and password "dev5678"



   @doTable
    Scenario: Do's Table exits
     When I open homepage and see "Do's" table
     Then I validate "Do's" table has " Send a personalized thank you letter after the interview"

   @dontTable
     Scenario: Dont's Table exists
       When I open homepage and see "Dont's" table
       Then I validate "Dont's" table has "Not listening or responding to the questions"




