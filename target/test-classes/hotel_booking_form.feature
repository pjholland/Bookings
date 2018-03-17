Feature: Hotel Booking Form

        In order to maintain an on-line service
        I want a Booking Form web page
        So that visitors can book thier acomdation on line

      Background:
          Given the visitor is on the hotel booking form page

      @current
       Scenario: An online visitor can book a hotel room
#            Given the visitor is on the hotel booking form page
            And the visitor makes a booking
            Then their booking will appear on the form

