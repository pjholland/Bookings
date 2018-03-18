Feature: Hotel Booking Form

        In order to maintain an on-line booking service
        I want a Booking Form web page
        So that visitors can book thier accomdation on line

      Background:
          Given the visitor is on the hotel booking form page

      @current
       Scenario: An online visitor can book a hotel room
           And the visitor makes a booking
           Then their booking will appear on the form

      @current
       Scenario: An on line visitor can delete their booking
           And the visitor decides to delete their booking
           Then the booking will no longer be visible on the fom




