@likebuttonfunctionality

  Feature: Like Option for Do's and don'ts
    Background: Open DevPrepp site
<<<<<<< HEAD
      Given Using "https://devprepp.herokuapp.com/"
      When I log in with email "asimbuttar84@hotmail.com" and password "Japan2020!"

      @likeoptionsDosandDonts
      Scenario: Verifying like buttons functionality
        When I like a statement in the Do's table I verify the like button works properly
        And the Don't table as well
=======
      Given Website starting
      When I log in with user email "devDD@gmail.com" and user password "dev5678"

    #@likeoptionsDosandDonts
      Scenario: Verifying like buttons functionality
        When I like a statement in the Do's table I verify the like button works properly
        Then the Don't table as well
        And I verify the like functionality works
>>>>>>> 3b997306d05d78d6673f4fcfdee23773dbc0544a
