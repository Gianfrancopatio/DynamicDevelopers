@sessionExpires

  Feature: Session should expire when user signs out
    Background: Open DevPrepp site
<<<<<<< HEAD
      Given Using "https://devprepp.herokuapp.com/"
      When I log in with email "asimbuttar84@hotmail.com" and password "Japan2020!"


     @expiredSession
      Scenario: Verifying session has expired
       Then user signs out
       And I verify session is expired

=======
      Given Website opening
      When I log in with email "devDD@gmail.com" and password "dev5678"


    @expiredSession
      Scenario: Verifying session has expired
       Then user signs out by pressing welcome button
        Then user clicks on sign out
       And I verify session is expired
>>>>>>> 3b997306d05d78d6673f4fcfdee23773dbc0544a
