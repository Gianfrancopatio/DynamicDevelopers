@likebuttonfunctionality

  Feature: Like Option for Do's and don'ts
    Background: Open DevPrepp site
      Given Using "https://devprepp.herokuapp.com/"
      When I log in with email "asimbuttar84@hotmail.com" and password "Japan2020!"

      @likeoptionsDosandDonts
      Scenario: Verifying like buttons functionality
        When I like a statement in the Do's table I verify the like button works properly
        And the Don't table as well