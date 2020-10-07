@likebuttonfunctionality

  Feature: Like Option for Do's and don'ts
    Background: Open DevPrepp site
      Given Website starting
      When I log in with user email "devDD@gmail.com" and user password "dev5678"

    #@likeoptionsDosandDonts
      Scenario: Verifying like buttons functionality
        When I like a statement in the Do's table I verify the like button works properly
        Then the Don't table as well
        And I verify the like functionality works