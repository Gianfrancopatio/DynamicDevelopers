@sessionExpires

  Feature: Session should expire when user signs out
    Background: Open DevPrepp site
      Given Website opening
      When I log in with email "devDD@gmail.com" and password "dev5678"


    @expiredSession
      Scenario: Verifying session has expired
       Then user signs out by pressing welcome button
        Then user clicks on sign out
       And I verify session is expired
