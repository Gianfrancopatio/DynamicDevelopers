@sessionExpires

  Feature: Session should expire when user signs out
    Background: Open DevPrepp site
      Given Using "https://devprepp.herokuapp.com/"
      When I log in with email "asimbuttar84@hotmail.com" and password "Japan2020!"


     @expiredSession
      Scenario: Verifying session has expired
       Then user signs out
       And I verify session is expired

