@doAndDontsTable

  Feature:Do's and Dont's table test
    Background: Open DevPrepp site
      Given Using "https://devprepp.herokuapp.com/"
      When I log in with email "gianfrancopatio@hotmail.com" and password "DevPrepp1"

    @doDontTable
    Scenario: Verifying tables DO's and Dont's exist
      Then I verify Do's table exists
      And I verify Dont's table exists




