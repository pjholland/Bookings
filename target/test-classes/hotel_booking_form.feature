@current
Feature: Hotel Booking Form

        In order to maintain an on-line booking service
        I want a Booking Form web page
        So that visitors can book their accommodation on line

      Background:
          Given the visitor is on the hotel booking form page

       Scenario: An online visitor can book a hotel room
           And the visitor makes a booking
           Then their booking will appear on the form

      Scenario: Each booking will have an associated Delete button
           And the visitor makes a booking
           Then each booking will have a Delete button
           And their booking will appear on the form

       Scenario: An on line visitor can delete their booking
           And the visitor decides to delete their booking
           Then the booking will no longer be visible on the form

       Scenario: An online visitor is must fill in all fields before making a booking
           When the visitor attempts to save the booking form without completing all fields
           Then the booking will not be made







